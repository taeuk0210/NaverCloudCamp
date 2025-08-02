package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Connection con;
	private Statement stmt;
	
	public List<MemberVO> listMembers() {
		List<MemberVO>  list = new ArrayList<>();
		try {
			connDB();
			String query = "select * from t_member";
			ResultSet rs = stmt.executeQuery(query);
			
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
			stmt.close();
			con.close();			
		} catch (SQLException e) {
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public void connDB() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("OracleDriver loading complete.");
		
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.0.29:1521:xe", "scott", "tiger");
		System.out.println("Database connection complete.");
		
		stmt = con.createStatement();
		System.out.println("Statement generation complete.");
	}
	
}
