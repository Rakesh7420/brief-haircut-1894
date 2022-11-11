package Dao;

import Bean.Customer;
import Exceptions.BusException;
import Exceptions.CustomerException;

public interface CustomerDao {
	
	public String cusSignup (String username , String pass, String firstname , String lastname, String address , String mobile);
	
	public String cusSignup(Customer customer );
	
	public Customer cusLogin (String username , String pass )throws CustomerException;
	
	public String bookTicket (String bName, int cusId , int no )throws BusException;

	public String cancelTicket (String bName, int cusId , int no )throws BusException;
	
	public void viewTicker(int cusId);
	

}
