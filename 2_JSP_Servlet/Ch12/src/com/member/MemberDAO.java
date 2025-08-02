package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	public static final int MEMBER_NONEXISTENT = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO( ) {}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	private Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/oracle");
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public int deleteMember(MemberDTO dto) {
		int ri = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "delete from members where id=?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			ri = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
				if (connection!=null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
	}
	
	public int insertMember(MemberDTO dto) {
		int ri = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "insert into members(id,pw,name,email,address) values(?,?,?,?,?)";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getAddress());
			pstmt.executeUpdate();
			ri = MemberDAO.MEMBER_JOIN_SUCCESS;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
				if (connection!=null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
		return ri;
	}
	
	public int updateMember(MemberDTO dto) {
		int ri = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "update members set pw=?,email=?,address=? where id=?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getId());
			ri = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
				if (connection!=null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
		return ri;
		
	}
	
	
	public int confirmId(String id) {
		int ri = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from members where id=?";
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if (set.next()) {
				ri = MemberDAO.MEMBER_EXISTENT;
			} else {
				ri = MemberDAO.MEMBER_NONEXISTENT;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (set!=null) set.close();
				if (pstmt!=null) pstmt.close();
				if (connection!=null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
		return ri;
	}
	
	public int userCheck(String id, String pw) {
		int ri = 0;
		String dbPw;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select pw from members where id=?";
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if (set.next()) {
				dbPw = set.getString("pw");
				if (dbPw.equals(pw)) {
					ri = MemberDAO.MEMBER_LOGIN_SUCCESS;
				} else {
					ri = MemberDAO.MEMBER_LOGIN_PW_NO_GOOD;
				}
			} else {
				ri = MemberDAO.MEMBER_LOGIN_IS_NOT;
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (set!=null) set.close();
				if (pstmt!=null) pstmt.close();
				if (connection!=null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
		return ri;
	}
	
	public MemberDTO getMember(String id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		MemberDTO dto = null;
		String query = "select * from members where id=?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			if (set.next()) {
				dto = new MemberDTO();
				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.setEmail(set.getString("email"));
				dto.setRdate(set.getTimestamp("rdate"));
				dto.setAddress(set.getString("address"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (set!=null) set.close();
				if (pstmt!=null) pstmt.close();
				if (connection!=null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
		return dto;
	}
	
	public List<MemberDTO> listMember() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		List<MemberDTO> list = new ArrayList<>();
		ResultSet set = null;
		MemberDTO dto = null;
		String query = "select * from members order by rdate desc";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			set = pstmt.executeQuery();
			
			while (set.next()) {
				dto = new MemberDTO();
				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.setEmail(set.getString("email"));
				dto.setRdate(set.getTimestamp("rdate"));
				dto.setAddress(set.getString("address"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (set!=null) set.close();
				if (pstmt!=null) pstmt.close();
				if (connection!=null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}
		return list;
	}


}
