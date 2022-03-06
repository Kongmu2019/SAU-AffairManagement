package edu.hfnu.model;

/**
 * 这里是团委老师模型，对应数据库saumaster,表teachers;
 * @author a
 *
 */

public class Teacher {
	private int id;			//团委老师编号
	private String name;	
	private String password;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Teacher(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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
}
