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

@WebServlet("/facultyServlet")
public class FacultyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
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

            FacultyModel facultymodel = new FacultyModel();
            facultymodel.setFacultyId(facultyId);
            facultymodel.setFacultyFirstName(facultyFirstName);
            facultymodel.setFacultyLastName(facultyLastName);
            facultymodel.setMobile(mobile);
            facultymodel.setEmail(email);
            facultymodel.setYearsExperience(yearsExperience);
            facultymodel.setCertificate(certificate);
            facultymodel.setQualification(qualification);
            facultymodel.setBatchId(batchId);
            facultymodel.setCourseId(courseId);

            FacultyDAO facultyDao = new FacultyDAO();
            String status = facultyDao.insertFacultyDetail(facultymodel);;

            if (status.equals("success")) {
                request.setAttribute("toastMessage", "Faculty Added Successfully!");
            } else {
            	request.setAttribute("toastMessage", "Failed to add Faulty. please try again later!");
            }
            request.getRequestDispatcher("/add_faculty.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("Invalid input: " + e.getMessage());
        }
    }
}
