package com.dzbs.www.service.comment;

import java.util.List;

import com.dzbs.www.bean.common.Comment;

public interface CommentService {

	public void saveComment(Comment comment);
	
	public void updateComment(Comment comment);
	
	public void deleteComment(Comment comment);
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Comment>
	 */
	public List<Comment> findById(Integer id);
	
	/**
	 * 查询所有评论
	 * @return List<Comment>
	 */
	public List<Comment> findAllComments();
	
	/**
	 * 用member_id进行查询(评论者查询)
	 * @param member_id
	 * @return List<Comment>
	 */
	public List<Comment> findByMemberId(Integer member_id);
	
	/**
	 * 用commented_id进行查询(被评论者查询)
	 * @param commented_id
	 * @return List<Comment>
	 */
	public List<Comment> findByCommentedId(Integer commented_id);
}
