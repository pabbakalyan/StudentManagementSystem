package controller.batch;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BatchDAO;
import model.BatchModel;

@WebServlet("/BatchDeleteServlet")
public class BatchDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int batchId = Integer.parseInt(request.getParameter("id"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        // Debugging logs
//        System.out.println("BatchDeleteServlet - doGet:");
//        System.out.println("Batch ID: " + batchId);
//        System.out.println("Course ID: " + courseId);

        BatchDAO batchDAO = new BatchDAO();
        BatchModel batch = batchDAO.getBatchById(batchId, courseId); // Use updated method

        if (batch != null) {
            request.setAttribute("batch", batch);
            request.setAttribute("courseId", courseId);
            RequestDispatcher dispatcher = request.getRequestDispatcher("batch_delete.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("Batch not found or mismatched course ID.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int batchId = Integer.parseInt(request.getParameter("batchId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        // Debugging logs
        System.out.println("BatchDeleteServlet - doPost:");
        System.out.println("Batch ID: " + batchId);
        System.out.println("Course ID: " + courseId);

        BatchDAO batchDAO = new BatchDAO();
        boolean isDeleted = batchDAO.deleteBatchDetails(batchId, courseId);

        if (isDeleted) {
            response.sendRedirect("listBatchServlet?courseId=" + courseId);
        } else {
            response.getWriter().println("Failed to delete the batch.");
        }
    }
}

