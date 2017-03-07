package com.dzbs.bean.common;

import java.math.BigDecimal;
import java.util.Date;

public class PropertyVO {

	private int id;
	
	private Date create_date;
		
	private Date update_date;
		
	private String create_man;
		
	private String update_man;
		
	private boolean deleted;
	//用于存贮中间变量
	private int c;
	
	//姓名 
	private String name;
	
	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	//邮箱 
	private String email;
		
	//手机号 
	private String mobile;
	
	//起点 
	private String startLocation;
	
	//终点 
	private String endLocation;
	
	//出发时间
	private Date goTime = new Date();
	
	//回程时间
	private Date backTime = new Date();
	
	//提议
	private String notes;
	
	//距离
	private double distance;
	
	private BigDecimal count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getCreate_man() {
		return create_man;
	}

	public void setCreate_man(String create_man) {
		this.create_man = create_man;
	}

	public String getUpdate_man() {
		return update_man;
	}

	public void setUpdate_man(String update_man) {
		this.update_man = update_man;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public Date getGoTime() {
		return goTime;
	}

	public void setGoTime(Date goTime) {
		this.goTime = goTime;
	}

	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}
}
