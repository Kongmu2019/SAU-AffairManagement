package edu.hfnu.model;

public class Contact1Table {
	private int id;
	private String dept;
	private String minister;
	private String sex;
	private String grade;
	private String address;
	private String mobilephone;
	public Contact1Table() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact1Table(String dept, String minister, String sex, String grade, String address, String mobilephone) {
		super();
		this.dept = dept;
		this.minister = minister;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMinister() {
		return minister;
	}
	public void setMinister(String minister) {
		this.minister = minister;
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
