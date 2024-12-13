<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mark Attendance</title>
<!-- Bootstrap CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>

	<!-- Admin Page Button 
    <div class="container-fluid">
        <div class="d-flex justify-content-end mt-3">
            <a href="home_admin.jsp" class="btn btn-primary">Admin Page</a>
        </div>
    </div>-->

	<!-- Toast Notification -->
	<div class="toast-container">
		<div id="toastMessage" class="toast" role="alert"
			aria-live="assertive" aria-atomic="true"
			data-message="<%=(String) request.getAttribute("toastMessage")%>">
			<div class="toast-header">
				<strong class="mr-auto">Notification</strong> <small
					class="text-muted">Now</small>
				<button type="button" class="ml-2 mb-1 close" data-dismiss="toast"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body"></div>
		</div>
	</div>

	<div class="form-container">
		<h2>Mark Attendance</h2>
		<form action="attendanceServlet" method="post">
			<div class="form-group">
				<label for="studentId">Student ID:</label> <input type="number"
					class="form-control" id="studentId" name="studentId" required>
			</div>

			<div class="form-group">
				<label for="batchId">Batch ID:</label> <input type="number"
					class="form-control" id="batchId" name="batchId" required>
			</div>

			<div class="form-group">
				<label for="courseId">course ID:</label> <input type="number"
					class="form-control" id="courseId" name="courseId" required>
			</div>

			<div class="form-group">
				<label for="status">Attendance Status:</label> <select
					class="form-control" id="status" name="status" required>
					<option value="Present">Present</option>
					<option value="Absent">Absent</option>
					<option value="Late">Late</option>
					<option value="Excused">Excused</option>
				</select>
			</div>

			<div class="form-group">
				<label for="date">Date:</label> <input type="date"
					class="form-control" id="date" name="date" required>
			</div>


			<button type="submit" class="btn btn-primary mt-3">Submit</button>
		</form>
	</div>

	<!-- Include the toast.js script -->
	<script src="${pageContext.request.contextPath}/js/toast.js"></script>
</body>
</html>
