package controller;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.Course2DTO;
import dto.CourseDTO;
import dto.StudentDTO;
import service.StudentService;

/**
 * Servlet implementation class Studentcontroller
 */
@WebServlet({"/Student/StudentJoin","/Student/checkId","/Student/StudentLogin","/Student/StudentLogout","/Student/SCHEDULE","/Student/new","/Student/ForgiveSub"})
public class Studentcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studentcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		StudentService studentservice = new StudentService();
		MultipartRequest multi;
		String savePath = "C:/Users/user/Desktop/FileUpload";
		int size = 10*1024*1024;
		switch(request.getServletPath()) {
		
		case "/Student/checkId":
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			String uId = request.getParameter("uId");
			String resultMsg = StudentService.checkId(uId);
			out.print(resultMsg); //
			break;
		
		case "/Student/StudentJoin":
			StudentDTO studentJoin = new StudentDTO();
			studentJoin.setId(request.getParameter("id"));
			studentJoin.setPw(request.getParameter("pw"));
			studentJoin.setName(request.getParameter("name"));
			studentJoin.setBirth(request.getParameter("birth"));
			studentJoin.setGender(request.getParameter("gender"));
			studentJoin.setRank(request.getParameter("rank"));
			studentJoin.setPh(request.getParameter("ph"));
			studentJoin.setAd(request.getParameter("ad"));
			
			int studentjoin = studentservice.StudentJoin(studentJoin);

			if (studentjoin > 0) {
				response.sendRedirect("LoginForm.jsp");
			}else {
				response.setContentType("text/html; charset=UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원가입에 실패하였습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
			break;
			
		case "/Student/StudentLogin":
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String rank = request.getParameter("rank");
			StudentDTO stuLogin = new StudentDTO();
			stuLogin.setId(id);
			stuLogin.setPw(pw);
			stuLogin.setRank(rank);
			String loginResult = studentservice.stuLogin(id,pw,rank);
			session.setAttribute("loginResult", loginResult);
			System.out.println("loginResult:"+loginResult);
			if(loginResult != null) {
				if(loginResult.equals("admin")) {
					response.sendRedirect("/StudentCourse/Course/CourseMain.jsp");
				}else {
					response.sendRedirect("/StudentCourse/Student/Main2.jsp");
				}
			}else {
				response.setContentType("text/html; charset=UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인에 실패하였습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
			break;
			
		case "/Student/StudentLogout":
			session.invalidate();
			
			response.sendRedirect("Main.jsp");
			break;
			
		case "/Student/SCHEDULE":	
			
			int pnumber = Integer.parseInt(request.getParameter("pnumber"));
			System.out.println("pnumber:" + pnumber);
			
			int selectDto = studentservice.select(pnumber);
			
			System.out.println("selectDto:"+selectDto);
			
			if(selectDto>0) {
				response.sendRedirect("/StudentCourse/Student/new");
			}
			
			
		break;
		
		case "/Student/new":
			
			ArrayList<Course2DTO> dto2 = new ArrayList<Course2DTO>();
			
			
			dto2 = studentservice.course2select();
			
			if(dto2 != null) {
				request.setAttribute("dto2", dto2);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Schedule.jsp");
				dispatcher.forward(request, response);
			}
			
			break;
			
			case "/Student/ForgiveSub":
			int pnumber2 = Integer.parseInt(request.getParameter("pnumber2"));
			
			int forgivesub = studentservice.deletesub(pnumber2);
				
			if (forgivesub > 0) {
				response.sendRedirect("/StudentCourse/Student/new");
			}
			}
			
			
		}
		
	}


