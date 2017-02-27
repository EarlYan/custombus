package com.dzbs.bean.common;

import java.util.Date;

public class OrderVO {
	
	private int id;
	
	//乘客用户名
	private String p_username;
	
	//乘客手机号
	private String p_mobile;
	
	//起点
	private String start_location;
	
	//终点
	private String end_location;
	
	//出发时间
	private Date start_time = new Date();
	
	//价格
	private float price; 
	
	//车牌号
	private String plate_number; 
	
	//司机用户名
	private String d_username;
	
	//司机手机号
	private String d_mobile;
	
	//所选座位号
	private int seat_id;
	
	//支付时间
	private Date pay_time = new Date();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getP_username() {
		return p_username;
	}

	public void setP_username(String p_username) {
		this.p_username = p_username;
	}

	public String getP_mobile() {
		return p_mobile;
	}

	public void setP_mobile(String p_mobile) {
		this.p_mobile = p_mobile;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
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

	public int getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	public Date getPay_time() {
		return pay_time;
	}

	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}
}
