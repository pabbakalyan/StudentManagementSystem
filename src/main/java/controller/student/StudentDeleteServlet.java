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


@WebServlet("/deleteStudentServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("id"));
		StudentDAO studentDAO = new StudentDAO();
		StudentModel student = studentDAO.getStudentById(studentId);
		
		if(student !=null) {
			request.setAttribute("student", student);
			RequestDispatcher dispatcher = request.getRequestDispatcher("student_delete.jsp");
			dispatcher.forward(request, response);
		}else {
			response.getWriter().println("Student not found");
		}
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int studentId = Integer.parseInt(request.getParameter("studentId"));
	        StudentDAO studentDAO = new StudentDAO();
	        boolean isDeleted = studentDAO.deleteStudentDeatils(studentId);

	        if (isDeleted) {
	        	response.sendRedirect("listStudentsServlet");
	        } else {
	            response.getWriter().println("Failed to Delete the Student");
	        }
	}

}
