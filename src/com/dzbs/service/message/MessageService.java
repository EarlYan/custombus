package com.dzbs.service.message;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.Message;
import com.dzbs.dao.message.MessageDao;

@Repository("messageDao")
@Transactional(propagation = Propagation.REQUIRED)
public class  MessageService implements MessageDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveMessage(Message message) {
		sessionFactory.getCurrentSession().saveOrUpdate(message);
	}

	@Override
	public void updateMessage(Message message) {
		sessionFactory.getCurrentSession().update(message);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteMessage(Message message) {
		sessionFactory.getCurrentSession().delete(message);
		sessionFactory.getCurrentSession().flush();	
	}

	@Override
	public List<Message> findById(Integer id) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Message WHERE deleted = false AND id = :id");
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<Message> temp = query.list();
		return temp;
	}

	@Override
	public List<Message> findAllMessages() {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Message WHERE deleted = false");
		@SuppressWarnings("unchecked")
		List<Message> temp = query.list();
		return temp;
	}

	@Override
	public List<Message> findByName(String name) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Message WHERE deleted = false AND name = :name");
		query.setString("name", name);
		@SuppressWarnings("unchecked")
		List<Message> temp = query.list();
		return temp;
	}
}
