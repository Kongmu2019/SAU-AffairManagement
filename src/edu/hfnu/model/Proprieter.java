package edu.hfnu.model;

/**
 * 这里是社团负责人模型，对应数据库saumaster,表proprieters;
 * @author a
 *
 */


public class Proprieter {
	private int id;				//社团负责人编号
	private String name;
	private String password;
	private String club;
	
	public Proprieter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proprieter(String name, String password, String club) {
		super();
		this.name = name;
		this.password = password;
		this.club = club;
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
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
}
