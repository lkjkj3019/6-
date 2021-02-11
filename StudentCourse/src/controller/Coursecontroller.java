package controller;

import java.io.IOException;
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

import dto.CourseDTO;
import service.CourseService;

/**
 * Servlet implementation class Coursecontroller
 */
@WebServlet({"/Course/CourseWrite","/Course/CourseList"})
public class Coursecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Coursecontroller() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		CourseService courseservice = new CourseService();
		int size = 10*1024*1024;
		String savePath = "C:/Users/user/Desktop/FileUpload";
		
		MultipartRequest multi;
		switch(request.getServletPath()) {
		
		case "/Course/CourseWrite" :
		multi = new MultipartRequest(
				request,
				savePath,
				size,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		String pfile = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		
		CourseDTO couDTO = new CourseDTO();
		String teacher = multi.getParameter("teacher");
		String sub = multi.getParameter("sub");
		String time = multi.getParameter("time");
		String classroom = multi.getParameter("classroom");
		
		couDTO.setTeacher(teacher);
		couDTO.setPfile(pfile);
		couDTO.setSub(sub);
		couDTO.setTime(time);
		couDTO.setClassroom(classroom);
		
		courseservice = new CourseService();
		int couWrite = courseservice.couWrite(couDTO);
		System.out.println("couWrite:" + couWrite);
		if(couWrite > 0) {
			response.sendRedirect("CourseList");
		}
		break;
		
		case "/Course/CourseList":
			ArrayList<CourseDTO> coudto = new ArrayList<CourseDTO>();
			coudto = courseservice.couList();
			request.setAttribute("courselist", coudto);
			System.out.println("coutdto:" + coudto);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CourseList.jsp");
			dispatcher.forward(request, response);
			
		break;
		}
	}
}
