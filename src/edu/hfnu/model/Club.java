package edu.hfnu.model;

/**
 * 这里是社团信息模型，对应数据库saumaster,表clubinfo;
 * @author a
 *
 */


public class Club {
	private int id;					//社团编号
	private String name;			//社团名称
	private String proprieterName;	//此社团的社长名字
	private int credit;				//社团信用评分
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
	public String getProprieterName() {
		return proprieterName;
	}
	public void setProprieterName(String proprieterName) {
		this.proprieterName = proprieterName;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
}
