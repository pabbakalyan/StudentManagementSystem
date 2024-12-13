package controller.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.StudentModel;


@WebServlet("/updateStudentServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("id"));
		StudentDAO studentDAO = new StudentDAO();
		StudentModel student = studentDAO.getStudentById(studentId);
		
		if(student != null) {
			request.setAttribute("student", student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("student_update.jsp");
			dispatcher.forward(request, response);
		}else {
			response.getWriter().println("Student not found");
		}
	}
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int studentId = Integer.parseInt(request.getParameter("studentId"));
	      String studentFirstName = request.getParameter("studentFirstName");
	      String studentLastName = request.getParameter("studentLastName");
	      long mobile = Long.parseLong(request.getParameter("mobile"));
	      String email = request.getParameter("email");
	      int yrPass = Integer.parseInt(request.getParameter("yrPass"));
	      String branch = request.getParameter("branch");
	      String gender = request.getParameter("gender");
	      int batchId = Integer.parseInt(request.getParameter("batchId"));
	      int courseId = Integer.parseInt(request.getParameter("courseId"));

	      StudentModel student = new StudentModel(studentId, studentFirstName, studentLastName, mobile, email, yrPass, branch, gender, batchId,courseId);
	      StudentDAO studentDAO = new StudentDAO();
	      
	      boolean isUpdated = studentDAO.updateStudentDetails(student);

	        if (isUpdated) {
	        	 response.sendRedirect("listStudentsServlet");
	         } else {
	             response.getWriter().println("Failed to Update Student");
	         }
	    }
	}
