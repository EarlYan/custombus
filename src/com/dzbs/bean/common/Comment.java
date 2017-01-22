package com.dzbs.bean.common;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author EarlYan
 * 评论信息
 */
@Entity
@Table(name="t_comment")
public class Comment extends BasePO{

	//评论者id
	private int member_id;
	
	//被评论者id
	private int commented_id;
	
	//评论内容
	private String content;

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getCommented_id() {
		return commented_id;
	}

	public void setCommented_id(int commented_id) {
		this.commented_id = commented_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
