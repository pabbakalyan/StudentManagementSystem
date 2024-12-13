package controller.dailytopic;

import dao.DailyTopicsDAO;
import model.DailyTopicModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet("/addDailyTopics")
public class AddDailyTopicsServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        Date date = Date.valueOf(request.getParameter("date"));
	        String facultyName = request.getParameter("facultyName");
	        String batchName = request.getParameter("batchName");

	        // Handle the time input to ensure it has the required format
	        String startTimeParam = request.getParameter("startTime");
	        if (startTimeParam != null && startTimeParam.length() == 5) { // If format is "HH:mm"
	            startTimeParam += ":00"; // Append ":00" for seconds
	        }
	        Time startTime = Time.valueOf(startTimeParam);

	        String topicDetails = request.getParameter("topicDetails");

	        DailyTopicModel topic = new DailyTopicModel();
	        topic.setDate(date);
	        topic.setBatchName(batchName);
	        topic.setFacultyName(facultyName);
	        topic.setStartTime(startTime);
	        topic.setTopicDetails(topicDetails);

	        DailyTopicsDAO topicDAO = new DailyTopicsDAO();
	        String status = topicDAO.addDailyTopic(topic);

	        if (status.equals("success")) {
	            request.setAttribute("toastMessage", "Topics added successfully!");
	        } else {
	            request.setAttribute("toastMessage", "Failed to add topics. Please try again!");
	        }
	        request.getRequestDispatcher("/add_daily_form.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.getWriter().println("Error: " + e.getMessage());
	    }
	}
}