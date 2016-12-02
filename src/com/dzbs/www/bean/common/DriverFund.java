package com.dzbs.www.bean.common;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author EarlYan
 * 司机资金信息
 */
@Entity
@Table(name="t_driverfund")
public class DriverFund {

	//司机id
	private int driver_id;
	
	//余额
	private double balance;

	public int getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
