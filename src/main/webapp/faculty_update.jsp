<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.FacultyModel" %>

<% FacultyModel faculty = (FacultyModel) request.getAttribute("faculty"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Faculty</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
  <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
    <div class="form-container">
        <h2>Update Faculty</h2>
        <form id="updateFacultyForm" action="updateFacultyServlet" method="post">
        
            <div class="form-group">
                <label for="facultyId">Faculty ID:</label>
                <input type="number" id="facultyId" name="facultyId" class="form-control" value="<%= faculty.getFacultyId() %>" readonly>
            </div>
            <div class="form-group">
                <label for="facultyFirstName">First Name:</label>
                <input type="text" id="facultyFirstName" name="facultyFirstName" class="form-control" value="<%= faculty.getFacultyFirstName() %>" required>
            </div>
            <div class="form-group">
                <label for="facultyLastName">Last Name:</label>
                <input type="text" id="facultyLastName" name="facultyLastName" class="form-control" value="<%= faculty.getFacultyLastName() %>" required>
            </div>
            <div class="form-group">
                <label for="mobile">Mobile Number:</label>
                <input type="number" id="mobile" name="mobile" class="form-control" value="<%= faculty.getMobile() %>" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control" value="<%= faculty.getEmail() %>" required>
            </div>
            <div class="form-group">
                <label for="yearsExperience">Years of Experience:</label>
                <input type="number" id="yearsExperience" name="yearsExperience" class="form-control" value="<%= faculty.getYearsExperience() %>" required>
            </div>
            <div class="form-group">
                <label for="certificate">Certificate:</label>
                <input type="text" id="certificate" name="certificate" class="form-control" value="<%= faculty.getCertificate() %>" required>
            </div>
            <div class="form-group">
                <label for="qualification">Qualification:</label>
                <input type="text" id="qualification" name="qualification" class="form-control" value="<%= faculty.getQualification() %>" required>
            </div>
            <div class="form-group">
                <label for="batchId">Batch ID</label>
                <input type="number" id="batchId" class="form-control" name="batchId" value="<%= faculty.getBatchId() %>" required>
            </div>
            <div class="form-group">
                <label for="courseId">Course ID:</label>
                <input type="number" id="courseId" name="courseId" class="form-control" value="<%= faculty.getCourseId() %>" required>
            </div>
            <button type="submit" class="btn btn-primary">Update Faculty</button>
        </form>
    </div>
</body>
</html>
