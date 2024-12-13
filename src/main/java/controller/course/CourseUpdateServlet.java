package controller.course;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CourseDAO;
import model.CourseModel;

@WebServlet("/updateCourseServlet")
public class CourseUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        CourseDAO courseDAO = new CourseDAO();
        CourseModel course = courseDAO.getCourseById(courseId);

        if (course != null) {
            request.setAttribute("course", course);
            RequestDispatcher dispatcher = request.getRequestDispatcher("course_update.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("Course not found.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String courseName = request.getParameter("courseName");
        String courseDuration = request.getParameter("courseDuration");
        int courseFees = Integer.parseInt(request.getParameter("courseFees"));

        // Update the course in the database
        CourseModel course = new CourseModel(courseId, courseName, courseDuration, courseFees);
        CourseDAO courseDAO = new CourseDAO();

        boolean isUpdated = courseDAO.updateCourseDetails(course);

        // Redirect or display a success/error message
        if (isUpdated) {
            response.sendRedirect("listCoursesServlet"); 
        } else {
            response.getWriter().println("Failed to update course.");
        }
    }
}