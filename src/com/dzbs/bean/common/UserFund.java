package com.dzbs.bean.common;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author EarlYan
 * 用户资金信息
 */
@Entity
@Table(name="t_userfund")
public class UserFund {
	
	//乘客id
	private int user_id;
	
	//会员开始时间
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date level_start_time = new Date();
	
	//会员结束时间
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date level_end_time = new Date();
	
	//余额
	private double balance;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getLevel_start_time() {
		return level_start_time;
	}

	public void setLevel_start_time(Date level_start_time) {
		this.level_start_time = level_start_time;
	}

	public Date getLevel_end_time() {
		return level_end_time;
	}

	public void setLevel_end_time(Date level_end_time) {
		this.level_end_time = level_end_time;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
