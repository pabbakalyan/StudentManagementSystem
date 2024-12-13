<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.CourseModel" %>

<% CourseModel course = (CourseModel) request.getAttribute("course"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Course</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
   <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
<div class="form-container">
    <h2>Update Course</h2>
    <form action="updateCourseServlet" method="post">
        <div class="form-group">
            <label for="courseId">Course ID:</label>
            <input type="number" id="courseId" name="courseId" class="form-control" value="<%= course.getCourseId() %>" readonly>
        </div>
        <div class="form-group">
            <label for="courseName">Course Name:</label>
            <input type="text" id="courseName" name="courseName" class="form-control" value="<%= course.getCourseName() %>" required>
        </div>
        <div class="form-group">
            <label for="duration">Duration (months):</label>
            <input type="text" id="duration" name="courseDuration" class="form-control" value="<%= course.getCourseDuration() %>" required>
        </div>
        <div class="form-group">
            <label for="fees">Fees:</label>
            <input type="number" id="fees" name="courseFees" class="form-control" value="<%= course.getCourseFees() %>" required>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>
