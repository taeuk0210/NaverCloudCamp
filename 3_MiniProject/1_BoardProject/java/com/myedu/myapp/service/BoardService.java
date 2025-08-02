package com.myedu.myapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myedu.myapp.dao.ICommentRepository;
import com.myedu.myapp.dao.IContentRepository;
import com.myedu.myapp.model.CommentVO;
import com.myedu.myapp.model.ContentVO;
import com.myedu.myapp.model.Query;
import com.myedu.myapp.model.ResultContent;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	IContentRepository contentRepository;
	@Autowired
	ICommentRepository commentRepository;
	@Override
	public Map<Integer, Integer> getCommentNumbers(Query query) {
		Map<Integer, Integer> numbers = new HashMap<>();
		contentRepository.listContent(query).getContents().stream().forEach(
				c->{numbers.put(c.getContentId(), commentRepository.getNumberOfComments(c.getContentId()));});
		return numbers;
	}
	@Override
	public int insertChildComment(int parentId, CommentVO comment) {
		return commentRepository.insertComment(parentId, comment);
	}
	
	@Override
	public int insertContent(ContentVO content) {
		return contentRepository.insertContent(content);
	}

	@Override
	public int updateContent(ContentVO content) {
		return contentRepository.updateContent(content);
	}

	@Override
	public int deleteContent(int contentId) {
		return contentRepository.deleteContent(contentId);
	}

	@Override
	public ResultContent listContent(Query query) {
		return contentRepository.listContent(query);
	}

	@Override
	public ContentVO getContent(int contentId) {
		return contentRepository.getContent(contentId);
	}

	@Override
	public ContentVO getPrevContent(int contentId) { 
		return contentRepository.getPrevContent(contentId);
	}

	@Override
	public ContentVO getNextContent(int contentId) { 
		return contentRepository.getNextContent(contentId);
	}

	@Override
	public int insertComment(CommentVO comment) {
		return commentRepository.insertComment(comment);
	}

	@Override
	public int updateComment(CommentVO comment) {
		return commentRepository.updateComment(comment);
	}

	@Override
	public int deleteComment(int commentId) {
		return commentRepository.deleteComment(commentId);
	}
	
	@Override
	public CommentVO getComment(int commentId) {
		return commentRepository.getComment(commentId);
	}
	
	@Override
	public List<CommentVO> getParentComments(int contentId) {
		return commentRepository.getParentComments(contentId);
	}
	@Override
	public int incrementViewCountContent(int contentId) {
		return contentRepository.incrementViewCountContent(contentId);
	}
	
	
}
