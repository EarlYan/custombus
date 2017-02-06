package com.dzbs.bean.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author EarlYan
 * 众筹信息
 */
@Entity
@Table(name="t_property")
public class Property extends BasePO{
	
	//姓名 
	private String name;
	
	//邮箱 
	private String email;
		
	//手机号 
	private String mobile;
	
	//起点 
	private String startLoaction;
	
	//终点 
	private String endLocation;
	
	//出发时间
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date goTime = new Date();
	
	//回程时间
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "HH:mm:ss")
	private Date backTime = new Date();
	
	//提议
	private String notes;

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

	public String getStartLoaction() {
		return startLoaction;
	}

	public void setStartLoaction(String startLoaction) {
		this.startLoaction = startLoaction;
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
}
