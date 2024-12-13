<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.FacultyModel" %>
<%@ page import="model.BatchModel"%>
<%@ page import="dao.BatchDAO"%>
<%@ page import="model.CourseModel"%>
<%@ page import="dao.CourseDAO"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of faculty</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">   
</head>
<body>

	 <div class="container my-5">
        <h2 class="text-center mb-4">List of Faculty</h2>
        <div class="d-flex justify-content-end mb-3">
        <a href="home_admin.jsp" class="btn btn-secondary">Admin page</a>	
    	</div>
    	
    	<!-- Dropdowns for Filtering -->
    <form method="GET" action="listFacultyServlet">
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
    
    <!-- Faculty Table -->
    <div id="facultyTable">
    	<c:if test="${facultys != null && !facultys.isEmpty()}">
    	 	<table class="table table-bordered mt-4">
            <thead>
                <tr>
                    <th>Faculty ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Mobile</th>
                    <th>Email</th>
                    <th>Year Experience</th>
                    <th>Certifications</th>
                    <th>Qualifications</th>
                    <th>Batch ID</th>
                    <th>course ID</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="faculty" items="${facultys}">
                    <tr>
                        <td>${faculty.facultyId}</td>
                        <td>${faculty.facultyFirstName}</td>
                        <td>${faculty.facultyLastName}</td>
                        <td>${faculty.mobile}</td>
                        <td>${faculty.email}</td>
                        <td>${faculty.yearsExperience}</td>
                        <td>${faculty.certificate}</td>
                        <td>${faculty.qualification}</td>
                        <td>${faculty.batchId}</td>
                        <td>${faculty.courseId}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>
        <c:if test="${facultys == null || facultys.isEmpty()}">
        	<p class="text-center text-muted">Please Select a course and batch to view facultys.</p>
        </c:if>
    </div>
</div>
</body>
</html>