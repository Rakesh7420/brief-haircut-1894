package Bean;

public class Bus {

	private int busNo;
	
	private String busName;
	
	private String routFrom;
	
	private String routeTo;
	
	private String bType;
	
	private String arrival;
	
	private String departure;
	
	private int totalSeats;
	
	private int availableSeats;
	
	private int fare;

	public Bus(int busNo, String busName, String routFrom, String routeTo, String bType, String arrival,
			String departure, int totalSeats, int availableSeats, int fare) {
		super();
		this.busNo = busNo;
		this.busName = busName;
		this.routFrom = routFrom;
		this.routeTo = routeTo;
		this.bType = bType;
		this.arrival = arrival;
		this.departure = departure;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.fare = fare;
	}

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bus [busNo=" + busNo + ", busName=" + busName + ", routFrom=" + routFrom + ", routeTo=" + routeTo
				+ ", bType=" + bType + ", arrival=" + arrival + ", departure=" + departure + ", totalSeats="
				+ totalSeats + ", availableSeats=" + availableSeats + ", fare=" + fare + "]";
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getRoutFrom() {
		return routFrom;
	}

	public void setRoutFrom(String routFrom) {
		this.routFrom = routFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
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

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
}
