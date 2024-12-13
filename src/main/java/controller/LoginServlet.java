package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.LoginModel;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

//	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
//		LoginCredentials lc = new LoginCredentials();
//		String vuser = req.getParameter("uname");
//		String vpwd = req.getParameter("pwd");
//		
//		boolean b = lc.auth(vuser, vpwd);
//		if(b==true) {
//			req.getRequestDispatcher("/sus.html").forward(req, res);
//		}
//		else {
//			req.getRequestDispatcher("/fail.html").forward(req, res);
//		}
//		
//	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String username = request.getParameter("uname");
//		String password = request.getParameter("pwd");
//
//		try {
//			LoginCredentials credentials = new LoginCredentials();
//			boolean authenticated = credentials.authenticate(username, password);
//
//			if (authenticated) {
//				response.sendRedirect(request.getContextPath() + "/sus.html");
//			} else {
//				response.sendRedirect(request.getContextPath() + "/fail.html");
//			}
//		} catch (SQLException e) {
//			// Handle database errors gracefully (e.g., log the error and display a generic
//			// error message)
//			response.sendRedirect(request.getContextPath() + "/fail.html");
//		}
//	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	    // Get username and password from request
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    String userType = req.getParameter("userType");

	    // Set the model with received parameters
	    LoginModel loginModel = new LoginModel();
	    loginModel.setUsername(username);
	    loginModel.setPassword(password);
	    loginModel.setUserType(userType);

	    // Authenticate using DAO
	    LoginDAO loginDAO = new LoginDAO();
	    boolean isAuthenticated = loginDAO.auth(loginModel);

	    // Redirect based on authentication result
	    if (isAuthenticated) {
	        HttpSession session = req.getSession();
	        session.setAttribute("username", loginModel.getUsername()); // Optional: Store username
	        session.setAttribute("email", loginModel.getEmail());       // Store email for accurate lookups
	        session.setAttribute("userType", userType);
	        session.setMaxInactiveInterval(30 * 60); // Session timeout set to 30 minutes

	        // Redirect based on userType
	        if ("admin".equalsIgnoreCase(userType)) {
	            req.getRequestDispatcher("/home_admin.jsp").forward(req, res);
	        } else if ("faculty".equalsIgnoreCase(userType)) {
	            req.getRequestDispatcher("/home_faculty.jsp").forward(req, res);
	        } else if ("student".equalsIgnoreCase(userType)) {
	            req.getRequestDispatcher("/home_student.jsp").forward(req, res);
	        } else {
	            req.getRequestDispatcher("/fail1.html").forward(req, res); // Unrecognized userType
	        }
	    } else {
	        // Redirect to fail page if authentication fails
	        req.getRequestDispatcher("/fail1.html").forward(req, res);
	    }
	}
}
