<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "model.StudentModel" %>   
 <% StudentModel student = (StudentModel) request.getAttribute("student"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Student</title>
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
     <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
    <div class="form-container">
        <h2>Delete Student</h2>
        <div class="card">
        	<div class="card-body">
        		<p><strong>Student ID:</strong><%= student.getStudentId() %>
        		<p><strong>Student First Name:</strong><%= student.getStudentFirstName() %>
        		<p><strong>Student Last Name:</strong><%= student.getStudentLastName() %>
        		<p><strong>Mobile:</strong><%= student.getMobile() %>
        		<p><strong>Email:</strong><%= student.getEmail() %>
        		<p><strong>Year of Passing:</strong><%= student.getYrPass() %>
        		<p><strong>Branch:</strong><%= student.getBranch() %>
        		<p><strong>Gender:</strong><%= student.getGender() %>
        		<p><strong>Batch ID:</strong><%= student.getBatchId() %>
        		<p><strong>Course ID:</strong><%= student.getCourseId() %>
        		
        	
        	</div>
        </div>
        <form id="deleteStudentForm" action="deleteStudentServlet" method="post" class="mt-3">
                <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
            <button type="submit" class="btn btn-danger">Delete Student</button>
            <br></br>
            <a href="listStudentsServlet" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>