package edu.hfnu.model;

import java.util.ArrayList;

/**
 * 为了Layui数据表格特定的格式而写的实体类
 * @author a
 *
 */

public class JsonFormat {
	private int code;//接口状态
	private String msg;//提示文本
	private int count;//数据长度
	private ArrayList<Object> data;//数据列表
	public JsonFormat() {
		super();
	}
	public JsonFormat(int code, String msg, int count, ArrayList<Object> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList<Object> getData() {
		return data;
	}
	public void setData(ArrayList<Object> data) {
		this.data = data;
	}
	
	
}
