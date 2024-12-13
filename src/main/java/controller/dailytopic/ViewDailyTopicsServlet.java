package controller.dailytopic;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DailyTopicsDAO;
import model.DailyTopicModel;


@WebServlet("/ViewDailyTopicsServlet")
public class ViewDailyTopicsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateParam = request.getParameter("date");
        DailyTopicsDAO topicDAO = new DailyTopicsDAO();
        List<DailyTopicModel> topic = null;

        if (dateParam != null && !dateParam.isEmpty()) {
            topic = topicDAO.getDailyTopicsByDate(Date.valueOf(dateParam));
        }

        request.setAttribute("topic", topic);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_daily_list.jsp");
        dispatcher.forward(request, response);
    }
}
