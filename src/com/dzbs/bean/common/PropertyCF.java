package com.dzbs.bean.common;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author EarlYan
 * 众筹申请信息
 */
@Entity
@Table(name="t_propertycf")
public class PropertyCF extends BasePO{
	
	//申请者id
	private int member_id;
	
	//众筹id
	private int property_id;

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getProperty_id() {
		return property_id;
	}

	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
}
