package controller.faculty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BatchDAO;
import dao.CourseDAO;
import dao.FacultyDAO;
import model.BatchModel;
import model.FacultyModel;

@WebServlet("/listFacultyServlet")
public class FacultyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String courseIdParam = request.getParameter("courseId");
	    String batchIdParam = request.getParameter("batchId");

	    List<FacultyModel> facultys = new ArrayList<>();
	    CourseDAO courseDAO = new CourseDAO();
	    BatchDAO batchDAO = new BatchDAO();
	    FacultyDAO facultyDAO = new FacultyDAO();

	    if (courseIdParam != null && !courseIdParam.isEmpty()) { // Ensure courseIdParam is not null or empty
	        int courseId = Integer.parseInt(courseIdParam);
	        List<BatchModel> batches = batchDAO.getBatchesByCourseId(courseId);
	        request.setAttribute("batches", batches);

	        if (batchIdParam != null && !batchIdParam.isEmpty()) { // Check if batchIdParam is not null or empty
	            int batchId = Integer.parseInt(batchIdParam);
	            facultys = facultyDAO.getFacultyByBatchAndCourse(batchId, courseId);
	        }
	    }

	    request.setAttribute("facultys", facultys);
	    request.setAttribute("courses", courseDAO.getAllCourses());
	    request.getRequestDispatcher("faculty_list.jsp").forward(request, response);
	}


}
