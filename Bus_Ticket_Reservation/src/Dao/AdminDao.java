package Dao;

import Bean.Bus;

public interface AdminDao {
	
	public final String username ="Admin";
	
	public final String password ="admin123";
	
	public String adminLogin(String username , String pass);
	
	public String addBus(int busNo, String bName , String routeFrom,String roteTo,String bType, String arrival , String departure, int totalSeats, int availableSeats, int fare );
	
	public String addBus(Bus bus);
	
	public String updateStatus (int cusId);
	
	public void viewAllTickets();

}
