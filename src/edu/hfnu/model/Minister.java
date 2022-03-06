package edu.hfnu.model;

/**
 * 这里是部门负责人模型，对应数据库saumaster,表ministers;
 * @author a
 *
 */


public class Minister {
	private int id;				//部门负责人编号
	private String name;
	private String password;
	private String department;
	
	
	public Minister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Minister(String name, String password, String department) {
		super();
		this.name = name;
		this.password = password;
		this.department = department;
	}
	
	
	public Minister(int id, String name, String password, String department) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.department = department;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDept() {
		return department;
	}
	public void setDept(String dept) {
		this.department = dept;
	}
}
