package controller.faculty;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FacultyDAO;
import model.FacultyModel;

/**
 * Servlet implementation class FacultyDeleteServlet
 */
@WebServlet("/deleteFacultyServlet")
public class FacultyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int FacultyId = Integer.parseInt(request.getParameter("id"));
		FacultyDAO facultyDAO = new FacultyDAO();
		FacultyModel faculty = facultyDAO.getFacultyById(FacultyId);
		
		if(faculty !=null) {
			request.setAttribute("faculty", faculty);
			RequestDispatcher dispatcher = request.getRequestDispatcher("faculty_delete.jsp");
			dispatcher.forward(request, response);
		}else {
			response.getWriter().println("Faculty not found");
		}
	}
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
            int facultyId = Integer.parseInt(request.getParameter("facultyId"));
            FacultyDAO facultyDAO = new FacultyDAO();
            boolean isDeleted = facultyDAO.deleteFacultyDetails(facultyId);

            if (isDeleted) {
               response.sendRedirect("listFacultyServlet");
            } else {
                response.getWriter().println("Failed to Delete the Faculty");
            }
	}
}
