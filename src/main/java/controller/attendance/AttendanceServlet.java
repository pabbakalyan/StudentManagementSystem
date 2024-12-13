package controller.attendance;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendanceDAO;
import model.AttendanceModel;

@WebServlet("/attendanceServlet")
public class AttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            int batchId = Integer.parseInt(request.getParameter("batchId"));
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            String status = request.getParameter("status");
            String dateString = request.getParameter("date");

            // Parse the date string to a java.util.Date
            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = format.parse(dateString);
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            // Create AttendanceModel object
            AttendanceModel attendance = new AttendanceModel();
            attendance.setStudentId(studentId);
            attendance.setBatchId(batchId);
            attendance.setCourseId(courseId);
            attendance.setStatus(status);
            attendance.setDate(sqlDate);
            
            AttendanceDAO attendanceDao = new AttendanceDAO();
            String status1 = attendanceDao.markAttendance(attendance);

            if (status1.equals("success")) {
               request.setAttribute("toastMessage", "Attendance added successfully!");
            } else {
               request.setAttribute("toastMessage", "Failed to add Attendance. Please try again!");
            }
            request.getRequestDispatcher("/attendance_form.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
