package edu.hfnu.model;

public class ItemsTable {
	private int id;
	private String itemid;
	private String itemname;
	private int inventory;
	public ItemsTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemsTable(String itemid, String itemname, int inventory) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.inventory = inventory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
}
