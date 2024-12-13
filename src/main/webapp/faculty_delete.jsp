<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.FacultyModel" %>

<% FacultyModel faculty = (FacultyModel) request.getAttribute("faculty"); %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Faculty</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
     <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
    <div class="form-container">
        <h2>Delete Faculty</h2>
        <div class="card">
        	<div class="card-body">
        		<p><strong>Faculty ID:</strong><%= faculty.getFacultyId() %>
        		<p><strong>Faculty First Name:</strong><%= faculty.getFacultyFirstName() %>
        		<p><strong>Faculty Last Name:</strong><%= faculty.getFacultyLastName() %>
        		<p><strong>Mobile:</strong><%= faculty.getMobile() %>
        		<p><strong>Email:</strong><%= faculty.getEmail() %>
        		<p><strong>yearsExperience:</strong><%= faculty.getYearsExperience() %>
        		<p><strong>Certificate:</strong><%= faculty.getCertificate() %>
        		<p><strong>Qualifications:</strong><%= faculty.getQualification() %>
        		<p><strong>Batch ID:</strong><%= faculty.getBatchId() %>
        		<p><strong>Course ID:</strong><%= faculty.getCourseId() %>
        	
        	</div>
        </div>
        
        <form id="deleteFacultyForm" action="deleteFacultyServlet" method="post" class="mt-3">
                <input type="hidden" name="facultyId" value="<%= faculty.getFacultyId() %>">
            <button type="submit" class="btn btn-danger">Delete Faculty</button>
            <br></br>
            <a href="listStudentsServlet" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>
