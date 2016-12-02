package com.dzbs.www.bean.common;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author EarlYan
 * 巴士信息
 */
@Entity
@Table(name="t_bus")
public class Bus extends BasePO{
	
	//司机id
	private int member_id;
	
	//车牌号
	private String plate_number;
	
	//巴士座位数
	private int seat_number;
	
	//巴士车型(1:小型客车,2:中型客车,3:大型客车)
	private int bus_type;

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}

	public int getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}

	public int getBus_type() {
		return bus_type;
	}

	public void setBus_type(int bus_type) {
		this.bus_type = bus_type;
	}
	
	
}
