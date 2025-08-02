package member3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addMember(MemberVO vo) {
		try {
			con = dataFactory.getConnection();
			String query = "insert into t_member(id,pwd,name,email) values(?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			String query = "delete from t_member where id='"+id+"'";
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers() {
		List<MemberVO>  list = new ArrayList<>();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			pstmt = con.prepareStatement(query);
			System.out.println("Statement generation complete.");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setDate(rs.getString("joinDate"));
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace(); 
		}		
		return list;
	}

	
}
