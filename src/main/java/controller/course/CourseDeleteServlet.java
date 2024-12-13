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

@WebServlet("/deleteCourseServlet")
public class CourseDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        CourseDAO courseDAO = new CourseDAO();
        CourseModel course = courseDAO.getCourseById(courseId);

        if (course != null) {
            request.setAttribute("course", course);
            RequestDispatcher dispatcher = request.getRequestDispatcher("course_delete.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("Course not found.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        CourseDAO courseDAO = new CourseDAO();
        boolean isDeleted = courseDAO.deleteCourseDetails(courseId);

        if (isDeleted) {
        	response.sendRedirect("listCoursesServlet");

        } else {
            response.getWriter().println("Failed to delete the course.");
        }
    }
}

