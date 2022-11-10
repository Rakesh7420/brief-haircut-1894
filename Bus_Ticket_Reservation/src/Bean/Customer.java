package Bean;

public class Customer {
	
private int cusid;

private String username;

private String password;

private String firstname;

private String lastname;

private String adress;

private String mobile;


public Customer() {
	super();
}


public Customer(String username, String password, String firstname, String lastname, String adress, String mobile) {
	super();
	this.username = username;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
	this.adress = adress;
	this.mobile = mobile;
}


public Customer(int cusid, String username, String password, String firstname, String lastname, String adress,
		String mobile) {
	super();
	this.cusid = cusid;
	this.username = username;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
	this.adress = adress;
	this.mobile = mobile;
}


public int getCusid() {
	return cusid;
}


public void setCusid(int cusid) {
	this.cusid = cusid;
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


public String getFirstname() {
	return firstname;
}


public void setFirstname(String firstname) {
	this.firstname = firstname;
}


public String getLastname() {
	return lastname;
}


public void setLastname(String lastname) {
	this.lastname = lastname;
}


public String getAdress() {
	return adress;
}


public void setAdress(String adress) {
	this.adress = adress;
}


public String getMobile() {
	return mobile;
}


public void setMobile(String mobile) {
	this.mobile = mobile;
}



}
