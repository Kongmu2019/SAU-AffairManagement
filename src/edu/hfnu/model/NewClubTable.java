package edu.hfnu.model;

public class NewClubTable {
	private int id;
	private String clubname;
	private String proprieter;
	private String applytime;
	private String status1;
	private String status2;
	private String reason1;
	private String reason2;
	public NewClubTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewClubTable(String clubname, String proprieter, String applytime, String status1, String status2,String reason1,String reason2) {
		super();
		this.clubname = clubname;
		this.proprieter = proprieter;
		this.applytime = applytime;
		this.status1 = status1;
		this.status2 = status2;
		this.reason1 = reason1;
		this.reason2 = reason2;
	}
	
	public String getReason1() {
		return reason1;
	}
	public void setReason1(String reason1) {
		this.reason1 = reason1;
	}
	public String getReason2() {
		return reason2;
	}
	public void setReason2(String reason2) {
		this.reason2 = reason2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClubname() {
		return clubname;
	}
	public void setClubname(String clubname) {
		this.clubname = clubname;
	}
	public String getProprieter() {
		return proprieter;
	}
	public void setProprieter(String proprieter) {
		this.proprieter = proprieter;
	}
	public String getApplytime() {
		return applytime;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public String getStatus2() {
		return status2;
	}
	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	
	
}
