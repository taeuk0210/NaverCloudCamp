package com.myedu.myapp.service;

import java.util.List;
import java.util.Map;

import com.myedu.myapp.model.CommentVO;
import com.myedu.myapp.model.ContentVO;
import com.myedu.myapp.model.Query;
import com.myedu.myapp.model.ResultContent;

public interface IBoardService {
	
	public int insertContent(ContentVO content);
	public int updateContent(ContentVO content);
	public int deleteContent(int contentId);
	public ResultContent listContent(Query query);
	public ContentVO getContent(int contentId);
	public ContentVO getPrevContent(int contentId);
	public ContentVO getNextContent(int contentId);
	public int insertComment(CommentVO comment);
	public int updateComment(CommentVO comment);
	public int deleteComment(int commentId);
	public CommentVO getComment(int commentId);
	public List<CommentVO> getParentComments(int contentId);
	public int incrementViewCountContent(int contentId);
	Map<Integer, Integer> getCommentNumbers(Query query);
	int insertChildComment(int parentId, CommentVO comment);
	
}
