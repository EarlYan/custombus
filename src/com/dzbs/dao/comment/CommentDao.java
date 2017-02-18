package com.dzbs.dao.comment;

import java.util.List;

import com.dzbs.bean.common.Comment;
import com.dzbs.bean.common.CommentVO;

public interface CommentDao {
	
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
	 * 查询所有评论
	 * @return List<CommentVO>
	 */
	public List<CommentVO> findAllCommentVOs();
	
	/**
	 * 查询所有评论
	 * @return List<CommentVO>
	 */
	public List<CommentVO> findAllCommentVOs(Integer pageNo,Integer pageSize);
	
	/**
	 * 用member_id进行查询(评论者查询)
	 * @param member_id
	 * @return List<Comment>
	 */
	public List<Comment> findByMemberId(Integer member_id);
	
	/**
	 * 用member_id进行查询(评论者查询)
	 * @param member_id
	 * @return List<CommentVO>
	 */
	public List<CommentVO> findByMemberIdVO(Integer member_id);
	
	/**
	 * 用member_id进行查询分页(评论者查询)
	 * @param member_id
	 * @return List<CommentVO>
	 */
	public List<CommentVO> findByMemberIdVO(Integer pageNo,Integer pageSize,Integer member_id);
	
	/**
	 * 用commented_id进行查询(被评论者查询)
	 * @param commented_id
	 * @return List<Comment>
	 */
	public List<Comment> findByCommentedId(Integer commented_id);
	
	/**
	 * 用commented_id进行查询(被评论者查询)
	 * @param commented_id
	 * @return List<CommentVO>
	 */
	public List<CommentVO> findByCommentedIdVO(Integer commented_id);
	
	/**
	 * 用commented_id进行查询分页(被评论者查询)
	 * @param commented_id
	 * @return List<CommentVO>
	 */
	public List<CommentVO> findByCommentedIdVO(Integer pageNo,Integer pageSize, Integer commented_id);
}
