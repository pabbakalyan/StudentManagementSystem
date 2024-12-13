package controller.student;

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
import dao.StudentDAO;
import model.BatchModel;
import model.StudentModel;

@WebServlet("/listStudentsServlet")
public class StudentsListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseIdParam = request.getParameter("courseId");
        String batchIdParam = request.getParameter("batchId");

        List<StudentModel> students = new ArrayList<>();
        CourseDAO courseDAO = new CourseDAO();
        BatchDAO batchDAO = new BatchDAO();
        StudentDAO studentDAO = new StudentDAO();

        if (courseIdParam != null && !courseIdParam.isEmpty()) {
            int courseId = Integer.parseInt(courseIdParam);
            List<BatchModel> batches = batchDAO.getBatchesByCourseId(courseId);
            request.setAttribute("batches", batches);

            if (batchIdParam != null && !batchIdParam.isEmpty()) {
                int batchId = Integer.parseInt(batchIdParam);
                students = studentDAO.getStudentsByBatchAndCourse(batchId, courseId);
            }
        }

        request.setAttribute("students", students);
        request.setAttribute("courses", courseDAO.getAllCourses());
        request.getRequestDispatcher("student_list.jsp").forward(request, response);
    }
}

