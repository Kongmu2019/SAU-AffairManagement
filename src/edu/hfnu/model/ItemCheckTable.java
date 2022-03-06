package edu.hfnu.model;

public class ItemCheckTable {
	private int id;
	private String datebuy;
	private String item;
	private int numbers;
	private int price;
	private String status;
	private String reason;
	public ItemCheckTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ItemCheckTable(String datebuy, String item, int numbers, int price, String status,String reason) {
		super();
		this.datebuy = datebuy;
		this.item = item;
		this.numbers = numbers;
		this.price = price;
		this.status = status;
		this.reason = reason;
	}

	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDatebuy() {
		return datebuy;
	}
	public void setDatebuy(String datebuy) {
		this.datebuy = datebuy;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
