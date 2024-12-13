<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.BatchModel"%>

<% BatchModel batch = (BatchModel) request.getAttribute("batch"); %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Batch Deletion</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
	<div class="form-container">
		<h2>Confirm Batch Deletion</h2>
		<div class="card">
			<div class="card-body">
				<p>
					<strong>Batch Id:</strong>
					<%=batch.getBatchId() %>
				<p>
					<strong>Batch Name:</strong>
					<%=batch.getBatchName() %>
				<p>
					<strong>Batch Start:</strong>
					<%=batch.getBatchStart() %>
				<p>
					<strong>Batch End:</strong>
					<%=batch.getBatchEnd() %>
				<p>
					<strong>Batch Timing:</strong>
					<%=batch.getBatchTiming() %>
				<p>
					<strong>Course Id:</strong>
					<%=batch.getCourseId() %>
			</div>
		</div>
		<form action="BatchDeleteServlet" method="post" class="mt-3">
			<input type="hidden" name="batchId" value="<%= batch.getBatchId() %>">
			<input type="hidden" name="courseId"value="<%= batch.getCourseId() %>">
			<button type="submit" class="btn btn-danger">Confirm Delete</button>
			<br></br>
			<a href="listBatchServlet?courseId=<%= batch.getCourseId() %>" class="btn btn-secondary">Cancel</a>
		</form>
	</div>
</body>
</html>
