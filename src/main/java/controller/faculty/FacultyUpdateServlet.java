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
 * Servlet implementation class FacultyUpdateServlet
 */
@WebServlet("/updateFacultyServlet")
public class FacultyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		int facultyId = Integer.parseInt(request.getParameter("id"));
		FacultyDAO facultyDAO = new FacultyDAO();
		FacultyModel faculty = facultyDAO.getFacultyById(facultyId);
		
		if(faculty != null) {
			request.setAttribute("faculty", faculty);
			RequestDispatcher dispatcher = request.getRequestDispatcher("faculty_update.jsp");
			dispatcher.forward(request, response);
		}else {
			response.getWriter().println("Faculty not found");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int facultyId = Integer.parseInt(request.getParameter("facultyId"));
            String facultyFirstName = request.getParameter("facultyFirstName");
            String facultyLastName = request.getParameter("facultyLastName");
            long mobile = Long.parseLong(request.getParameter("mobile"));
            String email = request.getParameter("email");
            int yearsExperience = Integer.parseInt(request.getParameter("yearsExperience"));
            String certificate = request.getParameter("certificate");
            String qualification = request.getParameter("qualification");
            int batchId = Integer.parseInt(request.getParameter("batchId"));
            int courseId = Integer.parseInt(request.getParameter("courseId"));

            FacultyModel faculty = new FacultyModel(facultyId, facultyFirstName, facultyLastName, mobile, email, yearsExperience, certificate, qualification, batchId, courseId);
            FacultyDAO facultyDAO = new FacultyDAO();
            
            boolean isUpadted = facultyDAO.updateFacultyDetails(faculty);

            if (isUpadted) {
               response.sendRedirect("listFacultyServlet");
            } else {
                response.getWriter().println("Failed to update Faculty");
            }
    }

}
