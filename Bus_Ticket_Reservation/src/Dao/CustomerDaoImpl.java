package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import Bean.Customer;
import Exceptions.BusException;
import Exceptions.CustomerException;
import Utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public String cusSignup(String username, String pass, String firstname, String lastname, String address,
			String mobile) {
	String msg = "Sign up Failed";
	
	try (Connection conn = DBUtil.provideconnection()){
		
		PreparedStatement ps = conn.prepareStatement("insert into customer(username, password , firstName , lastName, address, mobile) values (?,?,?,?,?,?)");
		
		ps.setString(1, username);
		ps.setString(2, pass);
		ps.setString(3, firstname);
		ps.setString(1, lastname);
		ps.setString(1, address);
		ps.setString(1, mobile);
		
		int x = ps.executeUpdate();
		
		if(x > 0) msg ="Sign up Successfull";
		
	} catch (SQLException e) {
		msg = e.getMessage();
	}
	
	
		return msg;
	}

	
	@Override
	public String cusSignup(Customer cus) {
		String msg = "Sign up Failed";
		
		try (Connection conn = DBUtil.provideconnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into customer(username, password , firstName , lastName, address, mobile) values (?,?,?,?,?,?)");
			
			ps.setString(1, cus.getUsername());
			ps.setString(2, cus.getPassword());
			ps.setString(3, cus.getFirstname());
			ps.setString(1, cus.getLastname());
			ps.setString(1, cus.getAdress());
			ps.setString(1, cus.getMobile());
			
			int x = ps.executeUpdate();
			
			if(x > 0) msg ="Sign up Successfull";
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
			return msg;
	}

	@Override
	public Customer cusLogin(String username, String pass) throws CustomerException {
		Customer customer=null;
		try(Connection conn = DBUtil.provideconnection()) {
			
		PreparedStatement ps =	conn.prepareStatement("Select * from customer where username= ? and password =?");
		
		ps.setString(1, username);
		ps.setString(2, pass);
		
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			int cusId = rs.getInt("cusId");
			String username2 = rs.getString("username");
			String password2= rs.getString("password");
			String firstname2= rs.getString("firstname");
			String lastname2= rs.getString("lastname");
			String adress2= rs.getString("address");
			String mobile2= rs.getString("mobile");
			
			 customer = new Customer(cusId,username2,password2,firstname2,lastname2,adress2,mobile2);
			
			}else {
				throw new CustomerException();
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return customer;
	}

	@Override
	public String bookTicket(String bName, int cusId, int no) throws BusException {
	
		String message = "Ticket Booking fail";
		
		try (Connection conn = DBUtil.provideconnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from bus where bName = ?");
			ps.setString(1, bName);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				int busNo = rs.getInt("busNo");
				int totalSeats = rs.getInt("totalSeats");
				int availSeats = rs.getInt("availSeats");
				Date departure = rs.getDate("departure");
				int fare = rs.getInt("fare");
				
				PreparedStatement ps1 = conn.prepareStatement("select datediff(?,current_date()) as date");
				ps1.setDate(1, departure);
				
				ResultSet rs1 = ps1.executeQuery();
				int days = 0;
				if (rs1.next()) {
					days = rs1.getInt("date");
				}
				
				if (days <= 0) {
					throw new BusException("Booking is not available for this date");
				}
				else if (availSeats >= no) {
					int seatFrom = totalSeats - availSeats + 1;
					int seatTo = seatFrom + no -1;
					fare = fare * no;
					
					PreparedStatement ps2 = conn.prepareStatement("insert into booking(cusId, busNo, seatFrom, seatTo) values (?, ?, ?, ?)");
					ps2.setInt(1, cusId);
					ps2.setInt(2, busNo);
					ps2.setInt(3, seatFrom);
					ps2.setInt(4, seatTo);
					
					int x = ps2.executeUpdate();

					if (x > 0) {
						
						PreparedStatement ps3 = conn.prepareStatement("update bus set availseats = ? where busNo = ?");
						availSeats = availSeats - no;
						ps3.setInt(1, availSeats);
						ps3.setInt(2, busNo);
						int y = ps3.executeUpdate();
						
						if (y <= 0) throw new BusException("Available Seat is not updated");
						
						
						System.out.println( "--------------------------------------------" + "\n"
																   + "Customer Id is : " + cusId + "\n"
																   + "Bus No is : " + busNo + "\n"
																   + "Seat No is from : " + seatFrom + " to " + seatTo + "\n"
																   + "Bus fare is : " + fare + "\n"
																   + "Booking yet to be confirm by Adminstrator" + "\n" 
																   + "---------------------------------------------" );
						
						 message = "Ticket Booked Successfully";
					}
				
				}
	
			}
			else {
				throw new BusException("Bus with " + bName + " is not available");
			}
			
		}
		catch (SQLException e) {
			throw new BusException(e.getMessage());
		}
		
		return message;
	}

	

	@Override
	public void viewTicker(int cusId) {
		 boolean flag = false;
			
			try(Connection conn = DBUtil.provideconnection()){
				PreparedStatement ps1 = conn.prepareStatement("select * from booking where cusId = ?");
				ps1.setInt(1, cusId);
				
				ResultSet rs1 = ps1.executeQuery();
				
				while (rs1.next()) {
					flag = true;
					System.out.println( "---------------------------------------------" );
					System.out.println( "Bus Id : " + rs1.getInt("bId") );
					System.out.println( "Bus No : " + rs1.getInt("busNo") );
					System.out.println( "Total tickets : " + (rs1.getByte("seatTo") - rs1.getInt("seatFrom") + 1));
					if (rs1.getBoolean("status")) System.out.println( "Status : Booked"  );
					else System.out.println( "Status : Pending" );
					
					System.out.println("----------------------------------------------" );
				}
				
				if (flag == false) System.out.println( "No tickets found" );
			}
			catch (SQLException s){
				System.out.println( s.getMessage());
			}
			
	}


	@Override
	public String cancelTicket(String bName, int cusId, int no) throws BusException {
String message = "Ticket cancellation failed";
		
		try (Connection conn = DBUtil.provideconnection()){
				
				PreparedStatement ps = conn.prepareStatement("select * from bus where bName = ?");
				ps.setString(1, bName);
				
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
					
					int busNo = rs.getInt("busNo");
					int availSeats = rs.getInt("availSeats");
					
					PreparedStatement ps1 = conn.prepareStatement("select * from booking where busNo = ? and cusId = ?");
					ps1.setInt(1, busNo);
					ps1.setInt(2, cusId);
					
					ResultSet rs1 = ps1.executeQuery();
					boolean flag = false;
					int count = 0;
					
					while (rs1.next()) {
						flag = true;
						int seatFrom = rs1.getInt("seatFrom");
						int seatTo = rs1.getInt("seatTo");
						count += seatTo - seatFrom + 1;
					}
					
				    if (flag) {
						
						PreparedStatement ps2 = conn.prepareStatement("delete from booking where busNo = ? and cusId = ?");
						ps2.setInt(1, busNo);
						ps2.setInt(2, cusId);
						
						int x = ps2.executeUpdate();
						if (x > 0) {
							
							PreparedStatement ps3 = conn.prepareStatement("update bus set availseats = ? where busNo = ?");
							availSeats = availSeats + count;
							ps3.setInt(1, availSeats);
							ps3.setInt(2, busNo);
							int y = ps3.executeUpdate();
							
							if (y <= 0) throw new BusException("Available Seat is not updated");
							
							 message = "Ticket cancelled Successfully";
						}
					
					}
				    else message = "No booking found";
		
				}
				else {
					throw new BusException("Bus with " + bName + " is not available");
				}
				
			}
			catch (SQLException e) {
				throw new BusException(e.getMessage());
			}
		
		return message;
	
	}

	
	
}
