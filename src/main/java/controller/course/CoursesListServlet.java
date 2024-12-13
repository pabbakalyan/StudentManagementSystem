package controller.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import model.CourseModel;

@WebServlet("/listCoursesServlet")
public class CoursesListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	response.setContentType("text/html");
//    	PrintWriter pw = response.getWriter();
//    	
//    	pw.println("<html><body by color ='cyan'>");
//    	pw.println("<a href='add_course.html'> Add new Course</a>");
//    	pw.println("<h1>Course Inforamtion</h1>");
    	
    	CourseDAO courseDAO = new CourseDAO();
        List<CourseModel> courses = courseDAO.getAllCourses();
        
//        pw.println("<table border='1' width='100%'>");
//        pw.println("<tr><th> Course ID </th><th> Course Name </th><th> Course Duration </th><th> Course Fee</th><th> Edit </th><th> Delete</th></tr>");
//        
//        for(CourseModel cm : courses)
//        {
//        	pw.println("<tr>"
//        			+"<td>"+ cm.getCourseId() + "</td>"
//        			+"<td>"+ cm.getCourseName() + "</td>"
//        			+"<td>"+ cm.getCourseDuration() + "</td>"
//        			+"<td>"+ cm.getCourseFees() + "</td>"
//        			+ "</td><td><a href ='course_update.html?courseId=" + cm.getCourseId()+"'>update</a></td>\r\n"
//        			+ "<td><a href ='course_delete.html?courseId=" + cm.getCourseId()+"'>delete</a></td></tr>\r\n"
//        			);
//        			
//        	
//        	
//        }
//        	pw.println("</table>");
//        	pw.println("<body>");
//        	pw.println("</html>");
        
        //System.out.println("Courses list size: " + (courses != null ? courses.size() : "null"));
        request.setAttribute("courses", courses);
        //System.out.println("Courses fetched: " + courses); // For debugging
        RequestDispatcher dispatcher = request.getRequestDispatcher("courses_list.jsp");
        dispatcher.forward(request, response);
    }
}
