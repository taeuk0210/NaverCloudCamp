package com.myedu.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myedu.myapp.model.MemberVO;

@Repository
public class MemberRepository implements IMemberRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class MemberMapper implements RowMapper<MemberVO> {
		@Override
		public MemberVO mapRow(ResultSet rs, int count) throws SQLException {
			MemberVO member = new MemberVO();
			member.setName(rs.getString("name"));
			member.setId(rs.getString("id"));
			member.setPw(rs.getString("pw"));
			member.setEmail(rs.getString("email"));
			member.setPhoneNum(rs.getString("phoneNum"));
			member.setAddress(rs.getString("address"));
			return member;
		}
	}
	@Override
	public int deleteMember(MemberVO member) {
		String sql = "delete from proMembers where id=?";
		return jdbcTemplate.update(sql, member.getId());
	}
	
	@Override
	public int insertMember(MemberVO member) {
		String sql = "insert into proMembers  values(?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,
				member.getName(),
				member.getId(),
				member.getPw(),
				member.getEmail(),
				member.getPhoneNum(),
				member.getAddress());
	}
	
	@Override
	public int updateMember(MemberVO member) {
		String sql = "update proMembers set name=?, pw=?,email=?, phoneNum=?,address=? where id=?";
		return jdbcTemplate.update(sql,
				member.getName(),
				member.getPw(),
				member.getEmail(),
				member.getPhoneNum(),
				member.getAddress(),
				member.getId());
	}
	
	@Override
	public int confirmId(String id) {
		String sql = "select count(id) from proMembers where id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, id);
	}
	
	@Override
	public int userCheck(String id, String pw) {
		String cnt = "select count(pw) from proMembers where id=?";
		String sql = "select pw from proMembers where id=?";
		if (jdbcTemplate.queryForObject(cnt, Integer.class, id)!=0) {
			String dbPw = jdbcTemplate.queryForObject(sql, String.class, id);
			if (dbPw.equals(pw)) {
				return 1;
			}
		}
		return 0;
	}
	
	@Override
	public String searchID(String name, String phoneNum) {		
		String cnt = "select count(id) from proMembers where name=? AND phoneNum=?";		
		String sql = "select id from proMembers where name=? AND phoneNum=?";
		if (jdbcTemplate.queryForObject(cnt, Integer.class, name, phoneNum)!=0) {
			return name + "님의 아이디 : " + jdbcTemplate.queryForObject(sql, String.class, name, phoneNum);
		}
		return "검색결과가 없습니다.";
	}
	@Override
	public String searchPW(String id, String name, String phoneNum) {		
		String cnt = "select count(pw) from proMembers where id=? and name=? and phoneNum=?";
		String sql = "select pw from proMembers where id=? and name=? and phoneNum=?";
		if (jdbcTemplate.queryForObject(cnt, Integer.class, id, name, phoneNum)!=0) {
			return name + "님의 비밀번호 : " + jdbcTemplate.queryForObject(sql, String.class, id, name, phoneNum);
		}
		return "검색결과가 없습니다.";
	}
	
	@Override
	public MemberVO getMember(String id) {
		String sql = "select * from proMembers where id=?";
		return jdbcTemplate.queryForObject(sql, new MemberMapper(), id);	
	}


}
