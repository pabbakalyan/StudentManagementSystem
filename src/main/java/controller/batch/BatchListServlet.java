package controller.batch;

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
import model.BatchModel;


/**
 * Servlet implementation class BatchListServlet
 */
@WebServlet("/listBatchServlet")
public class BatchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String courseIdParam = request.getParameter("courseId");
	    BatchDAO batchDAO = new BatchDAO();
	    List<BatchModel> batches;

	    if (courseIdParam != null && !courseIdParam.isEmpty()) {
	        int courseId = Integer.parseInt(courseIdParam);
	        batches = batchDAO.getBatchesByCourseId(courseId); // Create this method in BatchDAO
	    } else {
	        batches = new ArrayList<>(); // Empty list when no course is selected
	    }

	    request.setAttribute("batches", batches);
	    request.getRequestDispatcher("batch_list.jsp").forward(request, response);
	}

}
