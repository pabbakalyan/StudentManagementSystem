package controller.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendanceDAO;
import model.AttendanceModel;

@WebServlet("/studentAttendanceData")
public class StudentAttendanceDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("StudentAttendanceDataServlet invoked");

        String email = (String) request.getSession().getAttribute("email");
        System.out.println("Email in session: " + email);

        try {
            AttendanceDAO dao = new AttendanceDAO();
            List<AttendanceModel> attendanceList = dao.getStudentAttendance(email);

            // Convert attendance list to JSON for the frontend
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < attendanceList.size(); i++) {
                AttendanceModel attendance = attendanceList.get(i);
                json.append("{")
                    .append("\"date\":\"").append(attendance.getDate()).append("\",")
                    .append("\"status\":\"").append(attendance.getStatus()).append("\"")
                    .append("}");

                if (i < attendanceList.size() - 1) {
                    json.append(",");
                }
            }
            json.append("]");

            response.getWriter().write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

