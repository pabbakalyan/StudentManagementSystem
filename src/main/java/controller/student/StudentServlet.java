package controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.StudentModel;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
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

            StudentModel studentmodel = new StudentModel();
            studentmodel.setStudentId(studentId);
            studentmodel.setStudentFirstName(studentFirstName);
            studentmodel.setStudentLastName(studentLastName);
            studentmodel.setMobile(mobile);
            studentmodel.setEmail(email);
            studentmodel.setYrPass(yrPass);
            studentmodel.setBranch(branch);
            studentmodel.setGender(gender);
            studentmodel.setBatchId(batchId);
            studentmodel.setCourseId(courseId);
            

            StudentDAO studentDao = new StudentDAO();
            String status = studentDao.insertStudentDetail(studentmodel);

            if (status.equals("success")) {
               request.setAttribute("toastMessage", "Students Added Successfully!");
            } else {
                request.setAttribute("toastMessage", "Failed to add Student. please try again");
            }
            request.getRequestDispatcher("/add_student.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("Invalid input: " + e.getMessage());
        }
    }
}