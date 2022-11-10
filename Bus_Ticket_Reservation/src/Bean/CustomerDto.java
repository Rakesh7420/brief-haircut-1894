package Bean;

public class CustomerDto {

	private int Bid;
	
	private String firstname;
	
	private String lastname;
	
	private String mobile;
	
	private int busNo;
	
	private String bName;
	
	private String routeTo;
	
	private String arrival;
	
	private String departure;
	
	private int fare;
	
	private int seatFrom;
	
	private int seatTo;
	
	private boolean status;

	public CustomerDto(int bid, String firstname, String lastname, String mobile, int busNo, String bName,
			String routeTo, String arrival, String departure, int fare, int seatFrom, int seatTo, boolean status) {
		super();
		Bid = bid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobile = mobile;
		this.busNo = busNo;
		this.bName = bName;
		this.routeTo = routeTo;
		this.arrival = arrival;
		this.departure = departure;
		this.fare = fare;
		this.seatFrom = seatFrom;
		this.seatTo = seatTo;
		this.status = status;
	}

	public int getBid() {
		return Bid;
	}

	public void setBid(int bid) {
		Bid = bid;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getSeatFrom() {
		return seatFrom;
	}

	public void setSeatFrom(int seatFrom) {
		this.seatFrom = seatFrom;
	}

	public int getSeatTo() {
		return seatTo;
	}

	public void setSeatTo(int seatTo) {
		this.seatTo = seatTo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerDto [Bid=" + Bid + ", firstname=" + firstname + ", lastname=" + lastname + ", mobile=" + mobile
				+ ", busNo=" + busNo + ", bName=" + bName + ", routeTo=" + routeTo + ", arrival=" + arrival
				+ ", departure=" + departure + ", fare=" + fare + ", seatFrom=" + seatFrom + ", seatTo=" + seatTo
				+ ", status=" + status + "]";
	}
	
	
	
}
