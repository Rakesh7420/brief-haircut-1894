package com.bus.bean;

public class AdminBean {

	private  String username;
	
	private  String password;

	public AdminBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "AdminBean [username=" + username + ", password=" + password + "]";
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
