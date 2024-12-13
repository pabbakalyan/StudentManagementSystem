package controller.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDAO;
import model.StudentDetailsDTO;

@WebServlet("/studentDashboard")
public class StudentDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("email");

        StudentDAO studentDao = new StudentDAO();
        List<StudentDetailsDTO> courses = studentDao.getEnrolledDetails(username);

        // Group courses by unique keys and aggregate faculty names
        Map<String, StudentDetailsDTO> courseMap = new HashMap<>();

        for (StudentDetailsDTO course : courses) {
            String uniqueKey = course.getCourseName() + course.getBatchName() + course.getBatchStart();
            if (courseMap.containsKey(uniqueKey)) {
                // If the course already exists, append the faculty name
                StudentDetailsDTO existingCourse = courseMap.get(uniqueKey);
                existingCourse.setFacultyName(existingCourse.getFacultyName() + ", " + course.getFacultyName());
            } else {
                // Otherwise, add the course to the map
                courseMap.put(uniqueKey, course);
            }
        }

        // Convert the map values back to a list
        List<StudentDetailsDTO> filteredCourses = new ArrayList<>(courseMap.values());

        request.setAttribute("courses", filteredCourses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home_student1.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Forward POST requests to doGet
    }
}
