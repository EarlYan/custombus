package com.dzbs.bean.common;

import java.util.Date;

public class RouteVO {

	private int id;
	
	//司机用户名
	private String d_username;
	
	//司机手机号
	private String d_mobile;
	
	//车牌号
	private String plate_number; 
	
	//巴士车型(1:小型客车,2:中型客车,3:大型客车)
	private int bus_type;
	
	//起点
	private String start_location;
	
	//终点
	private String end_location;
	
	//起始时间
	private Date start_time = new Date();
	
	//里程数
	private float mileage;
	
	//大约时间(分钟)
	private int about_time;
	
	//是否满人
	private boolean isFull;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getD_username() {
		return d_username;
	}

	public void setD_username(String d_username) {
		this.d_username = d_username;
	}

	public String getD_mobile() {
		return d_mobile;
	}

	public void setD_mobile(String d_mobile) {
		this.d_mobile = d_mobile;
	}

	public String getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}

	public int getBus_type() {
		return bus_type;
	}

	public void setBus_type(int bus_type) {
		this.bus_type = bus_type;
	}

	public String getStart_location() {
		return start_location;
	}

	public void setStart_location(String start_location) {
		this.start_location = start_location;
	}

	public String getEnd_location() {
		return end_location;
	}

	public void setEnd_location(String end_location) {
		this.end_location = end_location;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public float getMileage() {
		return mileage;
	}

	public void setMileage(float mileage) {
		this.mileage = mileage;
	}

	public int getAbout_time() {
		return about_time;
	}

	public void setAbout_time(int about_time) {
		this.about_time = about_time;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
}
