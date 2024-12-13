<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="model.StudentModel"%>
<%@ page import="model.BatchModel"%>
<%@ page import="dao.BatchDAO"%>
<%@ page import="model.CourseModel"%>
<%@ page import="dao.CourseDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List of Students</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container my-5">
		<h2 class="text-center mb-4">List of Students</h2>
		<div class="d-flex justify-content-end mb-3">
			<a href="home_admin.jsp" class="btn btn-secondary">Admin page</a>
		</div>

    <!-- Dropdowns for Filtering -->
    <form method="GET" action="listStudentsServlet">
        <div class="form-group">
            <label for="courseDropdown">Select Course:</label>
            <select id="courseDropdown" name="courseId" class="form-control" onchange="this.form.submit()">
                <option value="" selected disabled>-- Select a Course --</option>
                <c:forEach var="course" items="${courses}">
                    <option value="${course.courseId}" 
                        ${param.courseId == course.courseId ? "selected" : ""}>
                        ${course.courseName}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group mt-3">
            <label for="batchDropdown">Select Batch:</label>
            <select id="batchDropdown" name="batchId" class="form-control" onchange="this.form.submit()">
                <option value="" selected disabled>-- Select a Batch --</option>
                <c:forEach var="batch" items="${batches}">
                    <option value="${batch.batchId}" 
                        ${param.batchId == batch.batchId ? "selected" : ""}>
                        ${batch.batchName}
                    </option>
                </c:forEach>
            </select>
        </div>
    </form>

    <!-- Student Table -->
    <div id="studentTable">
        <c:if test="${students != null && !students.isEmpty()}">
            <table class="table table-bordered mt-4">
                <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Mobile</th>
                        <th>Email</th>
                        <th>Year of Passing</th>
                        <th>Branch</th>
                        <th>Gender</th>
                        <th>Batch ID</th>
                        <th>Course ID</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.studentId}</td>
                            <td>${student.studentFirstName}</td>
                            <td>${student.studentLastName}</td>
                            <td>${student.mobile}</td>
                            <td>${student.email}</td>
                            <td>${student.yrPass}</td>
                            <td>${student.branch}</td>
                            <td>${student.gender}</td>
                            <td>${student.batchId}</td>
                            <td>${student.courseId}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${students == null || students.isEmpty()}">
            <p class="text-center text-muted">Please select a course and batch to view students.</p>
        </c:if>
    </div>
</div>
</body>
</html>
