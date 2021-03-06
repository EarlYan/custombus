package com.dzbs.service.comment;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.Comment;
import com.dzbs.bean.common.CommentVO;
import com.dzbs.dao.comment.CommentDao;

@Repository("commentDao")
@Transactional(propagation = Propagation.REQUIRED)
public class CommentImpl implements CommentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveComment(Comment comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(comment);
	}

	@Override
	public void updateComment(Comment comment) {
		sessionFactory.getCurrentSession().update(comment);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void deleteComment(Comment comment) {
		sessionFactory.getCurrentSession().delete(comment);
		sessionFactory.getCurrentSession().flush();
	}
	

	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Comment>
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
	public List<Comment> findByCommentedId(Integer commented_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Comment WHERE deleted = false AND commented_id = :commented_id");
		query.setInteger("commented_id", commented_id);
		@SuppressWarnings("unchecked")
		List<Comment> temp = query.list();
		return temp;
	}
	/**
	 * 分页查询所有评论
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentVO> findAllCommentVOs(Integer pageNo,Integer pageSize) {
		String sql = "SELECT"+
						" c.content,"+
						" m.realname AS 'commentedPerson',"+
						" m2.realname AS 'commentPerson',"+
						" c.create_date,"+
						" c.id"+
					" FROM"+
						" t_comment c,"+
						" t_member m,"+
						" t_member m2"+
					 " WHERE"+
						" c.commented_id = m.id"+
					 " AND c.member_id = m2.id"+
					 " AND c.deleted = 0";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(CommentVO.class));
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
	
	/**
	 * 用member_id进行查询(评论者查询)
	 * @param member_id
	 * @return List<CommentVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentVO> findByMemberIdVO(Integer pageNo,Integer pageSize,Integer member_id){
		String sql ="SELECT"+
						" c.content,"+
						" m.realname AS 'commentedPerson',"+
						" m2.realname AS 'commentPerson',"+
						" c.create_date,"+
						" c.id"+
					" FROM"+
						" t_comment c,"+
						" t_member m,"+
						" t_member m2"+
					" WHERE"+
						" c.commented_id = m.id"+
					 " AND c.member_id = m2.id"+
					 " AND c.deleted = 0"+
					 " AND c.member_id = :member_id";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(CommentVO.class));
		query.setInteger("member_id", member_id);
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
	
	/**
	 * 用commented_id进行查询(被评论者查询)
	 * @param commented_id
	 * @return List<CommentVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentVO> findByCommentedIdVO(Integer pageNo,Integer pageSize, Integer commented_id){
		String sql ="SELECT"+
						" c.content,"+
						" m.realname AS 'commentedPerson',"+
						" m2.realname AS 'commentPerson',"+
						" c.create_date,"+
						" c.id"+
					" FROM"+
						" t_comment c,"+
						" t_member m,"+
						" t_member m2"+
					" WHERE"+
						" c.commented_id = m.id"+
					 " AND c.member_id = m2.id"+
					 " AND c.deleted = 0"+
					 " AND c.commented_id = :commented_id";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(CommentVO.class));
		query.setInteger("commented_id", commented_id);
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
	
	/**
	 * 查询所有评论
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentVO> findAllCommentVOs() {
		String sql = "SELECT"+
						" c.content,"+
						" m.realname AS 'commentedPerson',"+
						" m2.realname AS 'commentPerson',"+
						" c.create_date,"+
						" c.id"+
					" FROM"+
						" t_comment c,"+
						" t_member m,"+
						" t_member m2"+
					 " WHERE"+
						" c.commented_id = m.id"+
					 " AND c.member_id = m2.id"+
					 " AND c.deleted = 0";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(CommentVO.class));
		return query.list();
	}
	
	/**
	 * 用member_id进行查询(评论者查询)
	 * @param member_id
	 * @return List<CommentVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentVO> findByMemberIdVO(Integer member_id){
		String sql ="SELECT"+
						" c.content,"+
						" m.realname AS 'commentedPerson',"+
						" m2.realname AS 'commentPerson',"+
						" c.create_date,"+
						" c.id"+
					" FROM"+
						" t_comment c,"+
						" t_member m,"+
						" t_member m2"+
					" WHERE"+
						" c.commented_id = m.id"+
					 " AND c.member_id = m2.id"+
					 " AND c.deleted = 0"+
					 " AND c.member_id = :member_id";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(CommentVO.class));
		query.setInteger("member_id", member_id);
		return query.list();
	}
	
	/**
	 * 用commented_id进行查询(被评论者查询)
	 * @param commented_id
	 * @return List<CommentVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CommentVO> findByCommentedIdVO(Integer commented_id){
		String sql ="SELECT"+
						" c.content,"+
						" m.realname AS 'commentedPerson',"+
						" m2.realname AS 'commentPerson',"+
						" c.create_date,"+
						" c.id"+
					" FROM"+
						" t_comment c,"+
						" t_member m,"+
						" t_member m2"+
					" WHERE"+
						" c.commented_id = m.id"+
					 " AND c.member_id = m2.id"+
					 " AND c.deleted = 0"+
					 " AND c.commented_id = :commented_id";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(CommentVO.class));
		query.setInteger("commented_id", commented_id);
		return query.list();
	}
}
