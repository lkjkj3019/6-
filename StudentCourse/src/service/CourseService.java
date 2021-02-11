package service;

import java.sql.*;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import dao.CourseDAO;
import dto.CourseDTO;

public class CourseService {

	public int couWrite(CourseDTO couDTO) {
		CourseDAO dao = CourseDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int pnumber = dao.getCourseNum() + 1;
		couDTO.setPnumber(pnumber);
		
		int couWrite = dao.courseWrite(couDTO);
		
		if ( couWrite > 0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return couWrite;
	}

	public ArrayList<CourseDTO> couList() {
		CourseDAO dao = CourseDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		ArrayList<CourseDTO> coudto = new ArrayList<CourseDTO>();
		coudto = dao.CourseList();
		
		return coudto;
	}

}
