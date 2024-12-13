<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.StudentModel" %>

<% StudentModel student = (StudentModel) request.getAttribute("student"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
     <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
     <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
    <div class="form-container">
        <h2>Update Student</h2>
        <form id="updateStudentForm" action="updateStudentServlet" method="post">
        
           <div class="form-group">
                <label for="studentId">Student ID </label>
                <input type="number" id="studentId" class="form-control" name="studentId" value="<%= student.getStudentId() %>" readonly>
            </div>

            <div class="form-group">
                <label for="studentFirstName">First Name</label>
                <input type="text" id="studentFirstName" class="form-control" name="studentFirstName" value="<%= student.getStudentFirstName() %>" required>
            </div>

            <div class="form-group">
                <label for="studentLastName">Last Name</label>
                <input type="text" id="studentLastName" class="form-control" name="studentLastName" value="<%= student.getStudentLastName() %>" required>
            </div>

            <div class="form-group">
                <label for="mobile">Mobile Number</label>
                <input type="number" id="mobile" class="form-control" name="mobile" value="<%= student.getMobile() %>" required>
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" class="form-control" name="email" value="<%= student.getEmail() %>" required>
            </div>

            <div class="form-group">
                <label for="yrPass">Year of Passing</label>
                <input type="number" id="yrPass" class="form-control" name="yrPass" value="<%= student.getYrPass() %>" required>
            </div>

            <div class="form-group">
                <label for="branch">Branch</label>
                <input list="branches" id="branch" class="form-control" name="branch" value="<%= student.getBranch() %>" required>
                <datalist id="branches">
                    <option value="CSE">
                    <option value="EEE">
                    <option value="ECE">
                    <option value="Mechanical">
                    <option value="IT">
                    <option value="Civil">
                </datalist>
            </div>

            <div class="form-group">
                <label>Gender</label><br>
                <input type="radio" id="male" name="gender" value="Male" value="<%= student.getGender() %>" required>
                <label for="male">Male</label>
                
                <input type="radio" id="female" name="gender" value="Female" value="<%= student.getGender() %>" required>
                <label for="female">Female</label>
                
                <input type="radio" id="other" name="gender" value="Other" value="<%= student.getGender() %>" required>
                <label for="other">Other</label>
            </div>

            <div class="form-group">
                <label for="batchId">Batch ID</label>
                <input type="number" id="batchId" class="form-control" name="batchId" value="<%= student.getBatchId() %>" required>
            </div>
            
            <div class="form-group">
                <label for="courseId">Course ID</label>
                <input type="number" id="courseId" class="form-control" name="courseId" value="<%= student.getCourseId() %>" required>
            </div>

            <button type="submit" class="btn btn-primary">Update Student</button>
        </form>
    </div>
    
</body>
</html>
