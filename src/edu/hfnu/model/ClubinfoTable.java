package edu.hfnu.model;

public class ClubinfoTable {
	private int id;
	private String name;
	private String pname;
	private int credit;
	
	public ClubinfoTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClubinfoTable(String name, String pname, int credit) {
		super();
		this.name = name;
		this.pname = pname;
		this.credit = credit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	
}
