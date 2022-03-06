package edu.hfnu.model;

public class ActivityroomTable {
	private int id;
	private String clubname;
	private String timeblock;
	private String purpose;
	private String proprieter;
	private String status;
	private String reason;
	public ActivityroomTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActivityroomTable(String clubname,String timeblock, String purpose, String proprieter, String status,String reason) {
		super();
		this.clubname = clubname;
		this.timeblock = timeblock;
		this.purpose = purpose;
		this.proprieter = proprieter;
		this.status = status;
		this.reason = reason;
	}
	
	
	
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getClubname() {
		return clubname;
	}
	public void setClubname(String clubname) {
		this.clubname = clubname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTimeblock() {
		return timeblock;
	}
	public void setTimeblock(String timeblock) {
		this.timeblock = timeblock;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getProprieter() {
		return proprieter;
	}
	public void setProprieter(String proprieter) {
		this.proprieter = proprieter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
