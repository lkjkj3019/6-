package dao;

import java.sql.*;
import static db.JdbcUtil.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Course2DTO;
import dto.CourseDTO;

public class CourseDAO {
	
	private static CourseDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	

	public static CourseDAO getInstance() {
		if ( dao == null) {
			dao = new CourseDAO();
		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;
		
	}

	public int getCourseNum() {
		String sql = "SELECT MAX(PNUMBER) FROM COURSE";
		
		int pnumber = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pnumber = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pnumber;
	}

	public int courseWrite(CourseDTO couDTO) {
		String sql = "INSERT INTO COURSE(PNUMBER, PFILE, TEACHER, SUB, TIME, CLASSROOM) VALUES(?, ?, ?, ?, ?, ?)";
		
		int WriteResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, couDTO.getPnumber());
			pstmt.setString(2, couDTO.getPfile());
			pstmt.setString(3, couDTO.getTeacher());
			pstmt.setString(4, couDTO.getSub());
			pstmt.setString(5, couDTO.getTime());
			pstmt.setString(6, couDTO.getClassroom());
			
			WriteResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return WriteResult;
	}

	public ArrayList<CourseDTO> CourseList() {
		String sql = "SELECT * FROM COURSE ORDER BY PNUMBER ASC";
		ArrayList<CourseDTO> coudto = new ArrayList<CourseDTO>();
		CourseDTO couDTO = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				couDTO = new CourseDTO();
				couDTO.setPnumber(rs.getInt(1));
				couDTO.setPfile(rs.getString(2));
				couDTO.setTeacher(rs.getString(3));
				couDTO.setSub(rs.getString(4));
				couDTO.setTime(rs.getString(5));
				couDTO.setClassroom(rs.getString(6));
				coudto.add(couDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(con);
		}
		return coudto;
	}

	public CourseDTO select(int pnumber) {
		String sql = "SELECT * FROM COURSE WHERE PNUMBER = ?";
		CourseDTO select = new CourseDTO();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pnumber);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				select.setPnumber(rs.getInt(1));
				select.setPfile(rs.getString(2));
				select.setTeacher(rs.getString(3));
				select.setSub(rs.getString(4));
				select.setTime(rs.getString(5));
				select.setClassroom(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return select;
	}

	public int insert(CourseDTO select) {
String sql = "INSERT INTO COURSE2(PNUMBER2, PFILE2, TEACHER2, SUB2, TIME2, CLASSROOM2) VALUES(?, ?, ?, ?, ?, ?)";
		
		int insertResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, select.getPnumber());
			pstmt.setString(2, select.getPfile());
			pstmt.setString(3, select.getTeacher());
			pstmt.setString(4, select.getSub());
			pstmt.setString(5, select.getTime());
			pstmt.setString(6, select.getClassroom());
			
			insertResult = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		System.out.println("DAOinsert:"+insertResult);
		return insertResult;
	}

	public ArrayList<Course2DTO> course2select() {
		String sql = "SELECT * FROM COURSE2 ORDER BY PNUMBER2 ASC ";
		ArrayList<Course2DTO> dto2 = new ArrayList<Course2DTO>();
		Course2DTO dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto = new Course2DTO();
				dto.setPnumber2(rs.getInt(1));
				dto.setPfile2(rs.getString(2));
				dto.setTeacher2(rs.getString(3));
				dto.setSub2(rs.getString(4));
				dto.setTime2(rs.getString(5));
				dto.setClassroom2(rs.getString(6));
				dto2.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			commit(con);
			close(pstmt);
			close(con);
		}
		System.out.println("course2dto:" + dto);
		return dto2;
	}

	public int deleteSub(int pnumber2) {
		String sql = "DELETE FROM COURSE2 WHERE PNUMBER2 = ?";
		int del = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pnumber2);
			
			del = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return del;
	}
}
