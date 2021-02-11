package dao;

import java.sql.*;
import java.util.ArrayList;

	import static db.JdbcUtil.*;

import dto.CourseDTO;
import dto.StudentDTO;

public class StudentDAO {
	
	private static StudentDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static StudentDAO getInstance() {
		if (dao == null) {
			dao = new StudentDAO();
		}
		return dao;
	}

	public void setConnction(Connection con) {
		this.con = con;
		
	}
	public String checkid(String uId) {
		String sql = "SELECT ID FROM STUDENT WHERE ID=?";
		String result = null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(con);
			close(pstmt);
		}
		return result;
	}

	public int StudentJoin(StudentDTO studentJoin) {
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,TO_DATE(?,'yyyy-mm-dd'),?,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, studentJoin.getId());
			pstmt.setString(2, studentJoin.getPw());
			pstmt.setString(3, studentJoin.getName());
			pstmt.setString(4, studentJoin.getBirth());
			pstmt.setString(5, studentJoin.getGender());
			pstmt.setString(6, studentJoin.getRank());
			pstmt.setString(7, studentJoin.getPh());
			pstmt.setString(8, studentJoin.getAd());
			
			result = pstmt.executeUpdate();
			System.out.println("DAO:"+result);
			System.out.println("Rank:"+studentJoin.getRank());
			System.out.println("Ad:"+ studentJoin.getAd());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			commit(con);
			close(pstmt);
			
		}
		return result;
	}

	public String stuLogin(String id, String pw) {
		String sql ="SELECT ID FROM STUDENT WHERE ID = ? AND PW =?";
		String loginResult = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginResult = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		return loginResult;
	}

	public void stuRank(String id, String rank) {
		String sql = "UPDATE STUDENT SET RANK=? WHERE ID=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, rank);
			pstmt.setNString(2, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
	}


		


}
