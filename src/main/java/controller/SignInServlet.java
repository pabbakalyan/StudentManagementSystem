package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SignInDAO;
import model.SignInModel;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/signup")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		
		SignInModel signinmodel = new SignInModel();
		signinmodel.setUsername(username);
		signinmodel.setEmail(email);
		signinmodel.setPassword(password);
		signinmodel.setUserType(userType);
		
		SignInDAO sd = new SignInDAO();
		String status = sd.insertDetail(signinmodel);
		if(status.equals("success")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.include(request, response);
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/fail.html");
			requestDispatcher.include(request, response);
		}
	}

}
