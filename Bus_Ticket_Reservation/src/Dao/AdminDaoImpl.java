package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Bean.Bus;
import Utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String adminLogin(String username, String pass) {
		
		String messege ="Invalid username or password";
		
		
		if (username.equals("Admin") && password.equals("admin123")) {
			messege ="Login Successfull";
		}
		return messege;
	}

	@Override
	public String addBus(int busNo, String bName, String routeFrom, String routeTo,String bType, String arrival, String departure,
			int totalSeats, int availableSeats, int fare) {
		String msg = "Bus not added";
		
		try (Connection conn = DBUtil.provideconnection()){
//			private int busNo;
//			
//			private String busName;
//			
//			private String routFrom;
//			
//			private String routeTo;
//			
//			private String bType;
//			
//			private String arrival;
//			
//			private String departure;
//			
//			private int totalSeats;
//			
//			private int availableSeats;
			
			
			PreparedStatement ps = conn.prepareStatement("insert into bus values (?,?,?,?,?,?,?,?,?,? ) ");
			
			ps.setInt(1, busNo);
			ps.setString(2, bName);
			ps.setString(3, routeFrom);
			ps.setString(4, routeTo);
			ps.setString(5, bType);
			ps.setString(6, arrival);
			ps.setString(7, departure);
			ps.setInt(8, totalSeats);
			ps.setInt(9, availableSeats);
			ps.setInt(10, fare);
			
			int x = ps.executeUpdate();
			
			if(x >0 ) msg= "Bus added inserted Successfully";
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		
		return msg;
	}

	@Override
	public String addBus(Bus bus) {
String msg = "Bus not added";
		
		try (Connection conn = DBUtil.provideconnection()){			
			PreparedStatement ps = conn.prepareStatement("insert into bus values (?,?,?,?,?,?,?,?,?,? ) ");
			
			ps.setInt(1, bus.getBusNo());
			ps.setString(2, bus.getBusName());
			ps.setString(3, bus.getRoutFrom());
			ps.setString(4, bus.getRouteTo());
			ps.setString(5, bus.getbType());
			ps.setString(6, bus.getArrival());
			ps.setString(7, bus.getDeparture());
			ps.setInt(8, bus.getTotalSeats());
			ps.setInt(9, bus.getAvailableSeats());
			ps.setInt(10, bus.getFare());
			
			int x = ps.executeUpdate();
			
			if(x >0 ) msg= "Bus added inserted Successfully";
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		
		return msg;
	}

	@Override
	public String updateStatus(int cusId) {
		String messege = "Status not update for customerId "+cusId;
		
		try (Connection conn = DBUtil.provideconnection()) {
			
		PreparedStatement ps = conn.prepareStatement("update booking set status = true where cusId = ? ");
			ps.setInt(1, cusId);
			
			int x = ps.executeUpdate(); 
			if(x > 0) messege ="Status successfully updated for customerID : "+cusId ;
		} catch (SQLException e) {
			messege = e.getMessage();
		}
		return messege;
	}

	@Override
	public void viewAllTickets() {
		boolean flag = false;
		
		try (Connection conn = DBUtil.provideconnection()){
			
		PreparedStatement ps =	conn.prepareStatement("select * from booking");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			flag = true;
			System.out.println("---------------------------------------------------");
			System.out.println("BusId : " +rs.getInt("bId"));
			System.out.println("Bus No : "+rs.getInt("busNo"));
			if (rs.getInt("status") == 1) System.out.println("Status : Booked" );
			else System.out.println("Status : Pending" );
			System.out.println("---------------------------------------------------");
		}
		if (flag == false) System.out.println("No tickets found");

		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
