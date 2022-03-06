package edu.hfnu.model;

/**
 * 对应表格honorcheck
 * @author a
 *
 */

public class HonorCertifyTable {
	private int id;
	private String clubname;
	private String activityname;
	private String activitytime;
	private int count;
	private int count1;
	private int count2;
	private int count3;
	private int count4;
	private String proprieter;
	private String status1;
	private String status2;
	private String reason1;
	private String reason2;
	
	
	public HonorCertifyTable() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HonorCertifyTable(String clubname, String activityname, String activitytime, int count, int count1,
			int count2, int count3, int count4, String proprieter, String status1, String status2,String reason1,String reason2) {
		super();
		this.clubname = clubname;
		this.activityname = activityname;
		this.activitytime = activitytime;
		this.count = count;
		this.count1 = count1;
		this.count2 = count2;
		this.count3 = count3;
		this.count4 = count4;
		this.proprieter = proprieter;
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


	public String getActivityname() {
		return activityname;
	}


	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}


	public String getActivitytime() {
		return activitytime;
	}


	public void setActivitytime(String activitytime) {
		this.activitytime = activitytime;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getCount1() {
		return count1;
	}


	public void setCount1(int count1) {
		this.count1 = count1;
	}


	public int getCount2() {
		return count2;
	}


	public void setCount2(int count2) {
		this.count2 = count2;
	}


	public int getCount3() {
		return count3;
	}


	public void setCount3(int count3) {
		this.count3 = count3;
	}


	public int getCount4() {
		return count4;
	}


	public void setCount4(int count4) {
		this.count4 = count4;
	}


	public String getProprieter() {
		return proprieter;
	}


	public void setProprieter(String proprieter) {
		this.proprieter = proprieter;
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
