package service;

import java.sql.Connection;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import dao.CourseDAO;
import dao.StudentDAO;
import dto.Course2DTO;
import dto.CourseDTO;
import dto.StudentDTO;

public class StudentService {

	public static String checkId(String uId) {
		StudentDAO dao = StudentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnction(con);
		
		String resultMsg;
		String resultcheckId = dao.checkid(uId);
		
		if(resultcheckId == null) {
			resultMsg = "OK";
		}else {
			resultMsg = "NO";
		}
		return resultMsg;
	}
	public int StudentJoin(StudentDTO studentJoin) {
		StudentDAO dao = StudentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnction(con);
		
		int insert = dao.StudentJoin(studentJoin);
		
		if ( insert > 0 ) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return insert;
	}
	public String stuLogin(String id, String pw, String rank) {
		StudentDAO dao = StudentDAO.getInstance();
		Connection con = getConnection();
		dao.setConnction(con);
		
		String loginResult = dao.stuLogin(id,pw);
		
		if(loginResult!=null) {
			commit(con);
		}else {
			rollback(con);
			
		}
		dao.stuRank(id,rank);
		close(con);
		return loginResult;
	}
	public int select(int pnumber) {
		CourseDAO dao = CourseDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		CourseDTO select = dao.select(pnumber);
		
		System.out.println("중간정검:"+select);
		int insert = dao.insert(select);
	
		if (insert>0) {
			commit(con);
	}else {
		rollback(con);
	}
		return insert;
		
	
	
}
	public ArrayList<Course2DTO> course2select() {
		CourseDAO dao = CourseDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		ArrayList<Course2DTO> dto2 = new ArrayList<Course2DTO>();
		dto2 = dao.course2select();
		return dto2;
	}
	public int deletesub(int pnumber2) {
		CourseDAO dao = CourseDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int delsub = dao.deleteSub(pnumber2);
		
		if (delsub > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		return delsub;
	}	
	

	
	


}
