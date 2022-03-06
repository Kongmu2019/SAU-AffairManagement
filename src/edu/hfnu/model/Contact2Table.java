package edu.hfnu.model;

public class Contact2Table {
	private int id;
	private String clubname;
	private String proprieter;
	private String sex;
	private String grade;
	private String address;
	private String mobilephone;
	public Contact2Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact2Table(String clubname, String proprieter, String sex, String grade, String address,
			String mobilephone) {
		super();
		this.clubname = clubname;
		this.proprieter = proprieter;
		this.sex = sex;
		this.grade = grade;
		this.address = address;
		this.mobilephone = mobilephone;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	
	
	
	
}
