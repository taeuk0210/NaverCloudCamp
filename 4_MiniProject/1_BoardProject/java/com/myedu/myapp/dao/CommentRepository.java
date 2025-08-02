package com.myedu.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myedu.myapp.model.CommentVO;

import java.util.List;

@Repository
public class CommentRepository implements ICommentRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class CommentMapper implements RowMapper<CommentVO> {
		@Override
		public CommentVO mapRow(ResultSet rs, int count) throws SQLException {
			CommentVO comment = new CommentVO();
			comment.setCommentAuthor(rs.getString("comment_author"));
			comment.setCommentId(rs.getInt("comment_id"));
			comment.setCommentMain(rs.getString("comment_main"));
			comment.setContentId(rs.getInt("content_id"));
			comment.setParentId(rs.getInt("parent_id"));
			return comment;
		}
	}
	@Override
	public int getNumberOfComments(int contentId) {
		String sql = "select count(*) from b_comment where content_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, contentId);
	}
	
	@Override
	public int deleteComment(int commentId) {
		String sql = "delete from b_comment where comment_id=?";
		return jdbcTemplate.update(sql, commentId);
	}
	@Override
	public int updateComment(CommentVO comment) {
		String sql = "update b_comment set comment_main=? where comment_id=?";
		return jdbcTemplate.update(sql,
				comment.getCommentMain(),
				comment.getCommentId());
	}
	@Override
	public int insertComment(int parentId, CommentVO comment) {
		String sql = "insert into b_comment(comment_id, content_id, comment_author, comment_main, parent_id)" +
					   "values(seq_ctnt.nextval,?,?,?,?)";
		return jdbcTemplate.update(sql, 
				comment.getContentId(),
				comment.getCommentAuthor(),
				comment.getCommentMain(),
				comment.getParentId());
	}
	@Override
	public int insertComment(CommentVO comment) {
		String sql = "insert into b_comment(comment_id, content_id, comment_author, comment_main)" +
					   "values(seq_ctnt.nextval,?,?,?)";
		return jdbcTemplate.update(sql, 
				comment.getContentId(),
				comment.getCommentAuthor(),
				comment.getCommentMain());
	}
	@Override
	public CommentVO getComment(int commentId) {
		String sql = "select * from b_comment where comment_id=?";
		return jdbcTemplate.queryForObject(sql, new CommentMapper(), commentId);
	}
	@Override
	public List<CommentVO> getChildComments(int commentId) {
		String sql = "select * from b_comment where parent_id=?";
		return jdbcTemplate.query(sql, new CommentMapper(), commentId);
	}
	@Override
	public List<CommentVO> getParentComments(int contentId) {
		String sql = "select * from b_comment where content_id=? and parent_id is null";
		return jdbcTemplate.query(sql, new CommentMapper(), contentId);

	}

}