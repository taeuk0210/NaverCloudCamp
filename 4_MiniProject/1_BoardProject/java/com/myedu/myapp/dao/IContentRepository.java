package com.myedu.myapp.dao;

import com.myedu.myapp.model.ContentVO;
import com.myedu.myapp.model.Query;
import com.myedu.myapp.model.ResultContent;

public interface IContentRepository {

	public int insertContent(ContentVO content);
	public int deleteContent(int contentId);
	public int updateContent(ContentVO dto);	
	public ResultContent listContent(Query query);
	public ContentVO getContent(int contentId);
	public ContentVO getNextContent(int contentId);
	public ContentVO getPrevContent(int contentId);
	public int incrementViewCountContent(int contentId);
}