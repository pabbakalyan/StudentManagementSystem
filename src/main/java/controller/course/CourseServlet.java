package controller.course;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import model.CourseModel;


@WebServlet("/courseServlet")
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int courseid = Integer.parseInt(request.getParameter("courseId"));
            String coursename = request.getParameter("courseName");
            String courseduration = request.getParameter("courseDuration");
            int coursefees = Integer.parseInt(request.getParameter("courseFees"));

            CourseModel coursemodel = new CourseModel();
            coursemodel.setCourseId(courseid);
            coursemodel.setCourseName(coursename);
            coursemodel.setCourseDuration(courseduration);
            coursemodel.setCourseFees(coursefees);

            CourseDAO cd = new CourseDAO();
            String status = cd.insertCourseDetails(coursemodel);

            if (status.equals("success")) {
                request.setAttribute("toastMessage", "Course added successfully!");
            } else {
                request.setAttribute("toastMessage", "Failed to add course. Please try again.");
            }
            request.getRequestDispatcher("/add_course.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("Invalid input: " + e.getMessage());
        }
    }
}
