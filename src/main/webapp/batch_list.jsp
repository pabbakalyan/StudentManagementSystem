<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="model.BatchModel"%>
<%@ page import="model.CourseModel"%>
<%@ page import="dao.CourseDAO"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List of Batches</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.btn {
	padding: 10px 20px; /* Adjust padding as needed */
	margin: 0 5px; /* Add space between buttons */
}
</style>

</head>
<body>
	<div class="container my-5">
		<h2 class="text-center mb-4">List of Batches</h2>
		<div class="d-flex justify-content-end mb-3">
			<a href="home_admin.jsp" class="btn btn-secondary">Admin page</a>
		</div>

		<!-- Dropdown to Select Course -->
		<form method="GET" action="listBatchServlet">
			<div class="form-group">
				<label for="courseDropdown">Select Course:</label> <select
					id="courseDropdown" name="courseId" class="form-control"
					onchange="this.form.submit()">
					<option value="" selected disabled>-- Select a Course --</option>
					<%
                        // Fetch all courses
                        CourseDAO courseDAO = new CourseDAO();
                        List<CourseModel> courses = courseDAO.getAllCourses();
                        for (CourseModel course : courses) {
                    %>
					<option value="<%= course.getCourseId() %>"
						<%= request.getParameter("courseId") != null && 
                            request.getParameter("courseId").equals(String.valueOf(course.getCourseId())) ? "selected" : "" %>>
						<%= course.getCourseName() %>
					</option>
					<% } %>
				</select>
			</div>
		</form>

		<!-- Display Batches -->
		<% 
            // Retrieve the batch list from the request
            List<BatchModel> list = (List<BatchModel>) request.getAttribute("batches");
        %>
		<%
            if (list == null || list.isEmpty()) {
        %>
		<p class="text-center text-muted">Please select a course to view
			its batches.</p>
		<% 
            } else { 
        %>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Batch ID</th>
					<th>Batch Name</th>
					<th>Batch Start</th>
					<th>Batch End</th>
					<th>Batch Timings</th>
					<th>Course ID</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<% for (BatchModel batch : list) { %>
				<tr>
					<td><%= batch.getBatchId() %></td>
					<td><%= batch.getBatchName() %></td>
					<td><%= batch.getBatchStart() %></td>
					<td><%= batch.getBatchEnd() %></td>
					<td><%= batch.getBatchTiming() %></td>
					<td><%= batch.getCourseId() %></td>
					<td><a
						href="BatchUpdateServlet?id=<%= batch.getBatchId() %>&courseId=<%= batch.getCourseId() %>"
						class="btn btn-primary">Update</a> <a
						href="BatchDeleteServlet?id=<%= batch.getBatchId() %>&courseId=<%= batch.getCourseId() %>"
						class="btn btn-danger">Delete</a></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<% } %>
	</div>
</body>
</html>