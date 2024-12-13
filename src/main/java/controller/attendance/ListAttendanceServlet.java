package controller.attendance;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendanceDAO;
import model.AttendanceModel;

@WebServlet("/listAttendanceServlet")
public class ListAttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String courseIdParam = request.getParameter("courseId");
        String batchIdParam = request.getParameter("batchId");
        String attendanceDate = request.getParameter("attendanceDate");

//        // Debugging statements to log parameters
//        System.out.println("courseIdParam: " + courseIdParam);
//        System.out.println("batchIdParam: " + batchIdParam);
//        System.out.println("attendanceDate: " + attendanceDate);

        List<AttendanceModel> attendanceList = null;

        if (courseIdParam != null && batchIdParam != null && attendanceDate != null) {
            int courseId = Integer.parseInt(courseIdParam);
            int batchId = Integer.parseInt(batchIdParam);

            AttendanceDAO attendanceDAO = new AttendanceDAO();
            attendanceList = attendanceDAO.getAttendanceByCourseBatchAndDate(courseId, batchId, attendanceDate);
        }

        request.setAttribute("attendanceList", attendanceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("attendance_list.jsp");
        dispatcher.forward(request, response);
    }
}
