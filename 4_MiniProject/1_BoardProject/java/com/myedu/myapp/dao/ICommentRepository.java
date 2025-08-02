package com.myedu.myapp.dao;

import com.myedu.myapp.model.CommentVO;

import java.util.List;


public interface ICommentRepository {
	
	public int deleteComment(int commentId);
	public int updateComment(CommentVO comment);
	public int insertComment(int parentId, CommentVO comment);
	public int insertComment(CommentVO comment);
	public CommentVO getComment(int commentId);
	public List<CommentVO> getChildComments(int commentId);
	public List<CommentVO> getParentComments(int contentId);
	int getNumberOfComments(int contentId);

}