package com.dzbs.dao.message;

import java.util.List;

import com.dzbs.bean.common.Message;

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
	 * 查询所有留言
	 * @return List<Message>
	 */
	public List<Message> findAllMessages();
	
	/**
	 * 查询所有留言
	 * @return List<Message>
	 */
	public List<Message> findAllMessages(Integer pageNo,Integer pageSize);
	
	/**
	 * 用name进行查询
	 * @param name
	 * @return List<Message>
	 */
	public List<Message> findByName(String name);
}
