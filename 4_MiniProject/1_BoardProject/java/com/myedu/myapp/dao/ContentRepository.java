package com.myedu.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myedu.myapp.model.ContentVO;
import com.myedu.myapp.model.Query;
import com.myedu.myapp.model.ResultContent;

@Repository
public class ContentRepository implements IContentRepository {
	private static final int PAGE_PER_LIST = 10;
	private static final int PAGE_BLOCK_SIZE = 5;
	@Autowired
	JdbcTemplate jdbcTemplate;

	private class ContentMapper implements RowMapper<ContentVO> {
		@Override
		public ContentVO mapRow(ResultSet rs, int count) throws SQLException {
			ContentVO content = new ContentVO();
			content.setContentId(rs.getInt("content_id"));
			content.setContentAuthor(rs.getString("content_author"));
			content.setContentTitle(rs.getString("content_title"));
			content.setAddDate(rs.getTimestamp("add_date"));
			content.setEditDate(rs.getTimestamp("edit_date"));
			content.setContentView(rs.getInt("content_view"));
			content.setContentMain(rs.getString("content_main"));
			return content;
		}
	}
	@Override
	public int insertContent(ContentVO content) {
		String sql = "insert into b_content(content_id, content_title, content_author, content_main)" +
					   "values(seq_ctnt.nextval,?,?,?)";
		return jdbcTemplate.update(sql,
				content.getContentTitle(),
				content.getContentAuthor(),
				content.getContentMain());
	}
	@Override
	public int deleteContent(int contentId) {
		String sql = "delete from b_content where content_id=?";
		return jdbcTemplate.update(sql, contentId);
	}
	@Override
	public int updateContent(ContentVO content) {
		String sql = "update b_content set content_title=?,content_main=?,edit_date=SYSDATE where content_id=?";
		return jdbcTemplate.update(sql,
				content.getContentTitle(),
				content.getContentMain(),
				content.getContentId());	
	}
	@Override
	public ResultContent listContent(Query query) {
		String sql = null;
		String condition = null;
		ResultContent resultContent = new ResultContent();
		int totalRows = 0;		
		int startRow = (query.getPage()-1)*PAGE_PER_LIST+1;
		int endRow = query.getPage()*PAGE_PER_LIST;
		
		if (query.getQueryWord()==null) {
			condition = " ";
		} else if (query.getQueryWord()!=null && query.getQuerySelect().equals("all")) {
			condition = " where content_title like '%"+query.getQueryWord()+
						"%' or content_author like '%"+query.getQueryWord()+
						"%' or content_main like '%"+query.getQueryWord()+"%' ";
		} else {
			condition = " where "+query.getQuerySelect()+" like '%"+query.getQueryWord()+"%' ";
		}
		sql = "select count(*) from b_content " + condition;
		totalRows = jdbcTemplate.queryForObject(sql, Integer.class);
		sql = "SELECT * "+
				"FROM (" + 
				"    SELECT rownum AS rnum, b.* " + 
				"    FROM (" + 
				"        SELECT * " + 
				"        FROM b_content " + 
				"        " + condition + 
				"        ORDER BY "+ query.getOrderSelect()+ 
				"    ) b " + 
				") " + 
				"WHERE rnum BETWEEN ? AND ?";
		try {
			resultContent.setContents(
					jdbcTemplate.query(sql, new ContentMapper(), startRow, endRow));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int totalPage = totalRows / PAGE_PER_LIST;
		if (totalRows % PAGE_PER_LIST > 0) totalPage++;
		resultContent.setTotalPage(totalPage);
		
		int startPage = ((query.getPage() - 1) / PAGE_BLOCK_SIZE) * PAGE_BLOCK_SIZE + 1;
	    int endPage = Math.min(startPage + PAGE_BLOCK_SIZE - 1, totalPage);
	    resultContent.setStartPage(startPage);
	    resultContent.setEndPage(endPage);
	    
		return resultContent;
		
	}
	@Override
	public ContentVO getContent(int contentId) {
		String sql = "select * from b_content where content_id=?";
		return jdbcTemplate.queryForObject(sql, new ContentMapper(), contentId);

	}
	@Override
	public ContentVO getNextContent(int contentId) {
		String sql = "select * from b_content where content_id = (" + 
						"select min(content_id) from b_content where content_id>?)";
		String cnt = "select count(*) from b_content where content_id = (" + 
						"select min(content_id) from b_content where content_id>?)";
		if (jdbcTemplate.queryForObject(cnt, Integer.class, contentId)!=0) {
			return jdbcTemplate.queryForObject(sql, new ContentMapper(), contentId);
		}
		return null;
	}
	@Override
	public ContentVO getPrevContent(int contentId) {
		String sql = "select * from b_content where content_id = (" + 
						"select max(content_id) from b_content where content_id<?)";
		String cnt = "select count(*) from b_content where content_id = (" + 
						"select max(content_id) from b_content where content_id<?)";
		if (jdbcTemplate.queryForObject(cnt, Integer.class, contentId)!=0) {
			return jdbcTemplate.queryForObject(sql, new ContentMapper(), contentId);
		}
		return null;

	}
	@Override
	public int incrementViewCountContent(int contentId) {
		String sql = "UPDATE b_content SET content_view = content_view + 1 WHERE content_id = ?";
		return jdbcTemplate.update(sql, contentId);
	}
}