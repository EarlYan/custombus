package com.dzbs.www.dao.message;

import java.util.List;

import com.dzbs.www.bean.common.Message;

public interface MessageDao{
	
	public void saveMessage(Message message);
	
	public void updateMessage(Message message);
	
	public void deleteMessage(Message message);
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Message>
	 */
	public List<Message> findById(Integer id);
	
	/**
	 * 查询所有评论
	 * @return List<Comment>
	 */
	public List<Message> findAllMessages();
	
	
	/**
	 * 用name进行查询
	 * @param name
	 * @return List<Message>
	 */
	public List<Message> findByName(String name);
}
