<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="model.CourseModel"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List of Courses</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container my-5">
		<h2 class="text-center mb-4">List of Courses</h2>
		<div class="d-flex justify-content-end mb-3">
			<a href="home_admin.jsp" class="btn btn-secondary">Admin page</a>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Course ID</th>
					<th>Course Name</th>
					<th>Duration (months)</th>
					<th>Fees</th>

				</tr>
			</thead>
			<%
			List<CourseModel> list = (List<CourseModel>) request.getAttribute("courses");
			%>
			<tbody>
				<tr>
					<%
					for (CourseModel s : list) {
					%>
				
				<tr>
					<td><%=s.getCourseId()%></td>
					<td><%=s.getCourseName()%></td>
					<td><%=s.getCourseDuration()%></td>
					<td><%=s.getCourseFees()%></td>

					<td><a href="updateCourseServlet?id=<%=s.getCourseId()%>"
						class="btn btn-primary">Update</a></td>
					<td><a href="deleteCourseServlet?id=<%=s.getCourseId()%>"
						class="btn btn-danger">Delete</a></td>


					<%
					}
					%>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>