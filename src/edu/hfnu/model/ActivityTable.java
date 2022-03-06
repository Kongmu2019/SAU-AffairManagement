package edu.hfnu.model;

public class ActivityTable {
	private int id;
	private String clubname;
	private String name;
	private String activitytime;
	private String site;
	private String scope;
	private String proprieter;
	private String status;
	private String reason;
	public ActivityTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ActivityTable(String clubname, String name, String activitytime, String site, String scope,
			String proprieter,String status,String reason) {
		super();
		this.clubname = clubname;
		this.name = name;
		this.activitytime = activitytime;
		this.site = site;
		this.scope = scope;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActivitytime() {
		return activitytime;
	}
	public void setActivitytime(String activitytime) {
		this.activitytime = activitytime;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getProprieter() {
		return proprieter;
	}
	public void setProprieter(String proprieter) {
		this.proprieter = proprieter;
	}
	
	
}
