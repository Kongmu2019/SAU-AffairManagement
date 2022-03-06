package edu.hfnu.model;

public class ClubEvaluateTable {
	private int id;
	private String clubname;
	private int zhiliang;
	private int yingxiang;
	private int manyi;
	private int hudong;
	private int total;
	
	public ClubEvaluateTable() {
		super();
	}
	
	
	
	public ClubEvaluateTable(int id, String clubname, int zhiliang, int yingxiang, int manyi, int hudong, int total) {
		super();
		this.id = id;
		this.clubname = clubname;
		this.zhiliang = zhiliang;
		this.yingxiang = yingxiang;
		this.manyi = manyi;
		this.hudong = hudong;
		this.total = total;
	}



	public ClubEvaluateTable(String clubname, int zhiliang, int yingxiang, int manyi, int hudong, int total) {
		super();
		this.clubname = clubname;
		this.zhiliang = zhiliang;
		this.yingxiang = yingxiang;
		this.manyi = manyi;
		this.hudong = hudong;
		this.total = total;
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

	public int getZhiliang() {
		return zhiliang;
	}

	public void setZhiliang(int zhiliang) {
		this.zhiliang = zhiliang;
	}

	public int getYingxiang() {
		return yingxiang;
	}

	public void setYingxiang(int yingxiang) {
		this.yingxiang = yingxiang;
	}

	public int getManyi() {
		return manyi;
	}

	public void setManyi(int manyi) {
		this.manyi = manyi;
	}

	public int getHudong() {
		return hudong;
	}

	public void setHudong(int hudong) {
		this.hudong = hudong;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
	
}
