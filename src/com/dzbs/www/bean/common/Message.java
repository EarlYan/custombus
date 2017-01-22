package com.dzbs.www.bean.common;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author EarlYan
 * 留言信息
 */
@Entity
@Table(name="t_message")
public class Message extends BasePO{

	//评论者姓名
	private String name;
	
	//被评论者邮箱
	private String email;
	
	//评论内容
	private String message;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
