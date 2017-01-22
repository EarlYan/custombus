package com.dzbs.service.comment;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.Comment;
import com.dzbs.dao.comment.CommentDao;

@Repository("commentDao")
@Transactional(propagation = Propagation.REQUIRED)
public class CommentService implements CommentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveComment(Comment comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}

	public void updateComment(Comment comment) {
		sessionFactory.getCurrentSession().update(comment);
		sessionFactory.getCurrentSession().flush();
	}
	
	public void deleteComment(Comment comment) {
		sessionFactory.getCurrentSession().delete(comment);
		sessionFactory.getCurrentSession().flush();
	}
	

	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Comment>
	 */
	public List<Comment> findById(Integer id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE deleted = false AND id = :id");
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<Comment> temp = query.list();
		return temp;
	}
	
	/**
	 * 查询所有评论
	 * @return List<Comment>
	 */
	public List<Comment> findAllComments(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE deleted = false");
		@SuppressWarnings("unchecked")
		List<Comment> temp = query.list();
		return temp;
	}
	
	/**
	 * 用member_id进行查询(评论者查询)
	 * @param member_id
	 * @return List<Comment>
	 */
	public List<Comment> findByMemberId(Integer member_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE deleted = false AND member_id = :member_id");
		query.setInteger("member_id", member_id);
		@SuppressWarnings("unchecked")
		List<Comment> temp = query.list();
		return temp;
	}
	
	/**
	 * 用commented_id进行查询(被评论者查询)
	 * @param commented_id
	 * @return List<Comment>
	 */
	public List<Comment> findByCommentedId(Integer commented_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE deleted = false AND commented_id = :commented_id");
		query.setInteger("commented_id", commented_id);
		@SuppressWarnings("unchecked")
		List<Comment> temp = query.list();
		return temp;
	}
}
