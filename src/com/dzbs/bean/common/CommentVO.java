package com.dzbs.bean.common;

import java.util.Date;

public class CommentVO{
	
	private Integer id;
	
	private String commentPerson;
	
	private String commentedPerson;
	
	private String content;
	
	private Date create_date = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommentPerson() {
		return commentPerson;
	}

	public void setCommentPerson(String commentPerson) {
		this.commentPerson = commentPerson;
	}

	public String getCommentedPerson() {
		return commentedPerson;
	}

	public void setCommentedPerson(String commentedPerson) {
		this.commentedPerson = commentedPerson;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
}
