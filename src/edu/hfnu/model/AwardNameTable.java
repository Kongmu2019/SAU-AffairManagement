package edu.hfnu.model;

public class AwardNameTable {
	private int id;
	private String clubname;
	private String activityname;
	private String prizewinner;
	private String prize;
	public AwardNameTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AwardNameTable(String clubname, String activityname, String prizewinner, String prize) {
		super();
		this.clubname = clubname;
		this.activityname = activityname;
		this.prizewinner = prizewinner;
		this.prize = prize;
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
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	public String getPrizewinner() {
		return prizewinner;
	}
	public void setPrizewinner(String prizewinner) {
		this.prizewinner = prizewinner;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	
	
}
