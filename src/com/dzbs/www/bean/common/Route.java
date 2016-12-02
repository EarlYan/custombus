package com.dzbs.www.bean.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author EarlYan
 * 路线信息
 */
@Entity
@Table(name="t_route")
public class Route extends BasePO{
	
	//司机id
	private int member_id;
	
	//巴士id
	private int bus_id;
	
	//起点
	private String start_location;
	
	//终点
	private String end_location;
	
	//起始时间
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date start_time = new Date();
	
	//里程数
	private int mileage;
	
	//大约时间(分钟)
	private int about_time;

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getBus_id() {
		return bus_id;
	}

	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
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

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getAbout_time() {
		return about_time;
	}

	public void setAbout_time(int about_time) {
		this.about_time = about_time;
	}

}
