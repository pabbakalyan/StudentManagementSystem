package controller.batch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BatchDAO;
import model.BatchModel;

/**
 * Servlet implementation class BatchServlet
 */
@WebServlet("/batchServlet")
public class BatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int batchid = Integer.parseInt(request.getParameter("batchId"));
			String batchname = request.getParameter("batchName");
			String batchstart = request.getParameter("batchStart");
			String batchend = request.getParameter("batchEnd");
			String batchtiming = request.getParameter("batchTiming");
			int courseid = Integer.parseInt(request.getParameter("courseId"));

			BatchModel batchmodel = new BatchModel();
			batchmodel.setBatchId(batchid);
			batchmodel.setBatchName(batchname);
			batchmodel.setBatchStart(batchstart);
			batchmodel.setBatchEnd(batchend);
			batchmodel.setBatchTiming(batchtiming);
			batchmodel.setCourseId(courseid);

			BatchDAO bd = new BatchDAO();
			String status = bd.insertBatchDetail(batchmodel);
			if (status.equals("success")) {
				 request.setAttribute("toastMessage", "Batch added successfully!");
			} else {
				request.setAttribute("toastMessage", "Failed to add Batch. Please try again.");
			}
			 request.getRequestDispatcher("/add_batch.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.getWriter().println("Invalid input: " + e.getMessage());
		}

	}

}
