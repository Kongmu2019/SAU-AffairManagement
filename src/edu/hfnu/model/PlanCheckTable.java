package edu.hfnu.model;

public class PlanCheckTable {
	private int id;
	private String plantime;
	private String plancontent;
	private String proposer;
	private String status;
	private String reason;
	public PlanCheckTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlanCheckTable(String plantime, String plancontent, String proposer, String status,String reason) {
		super();
		this.plantime = plantime;
		this.plancontent = plancontent;
		this.proposer = proposer;
		this.status = status;
		this.reason = reason;
	}
	
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlantime() {
		return plantime;
	}
	public void setPlantime(String plantime) {
		this.plantime = plantime;
	}
	public String getPlancontent() {
		return plancontent;
	}
	public void setPlancontent(String plancontent) {
		this.plancontent = plancontent;
	}
	public String getProposer() {
		return proposer;
	}
	public void setProposer(String proposer) {
		this.proposer = proposer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
