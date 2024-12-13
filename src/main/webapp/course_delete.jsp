<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="model.CourseModel" %>

<% CourseModel course = (CourseModel) request.getAttribute("course"); %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Course Confirmation</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
     <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
<div class="form-container">
    <h2>Confirm Course Deletion</h2>
    <div class="card">
        <div class="card-body">
            <p><strong>Course ID:</strong> <%= course.getCourseId() %></p>
            <p><strong>Course Name:</strong> <%= course.getCourseName() %></p>
            <p><strong>Duration:</strong> <%= course.getCourseDuration() %></p>
            <p><strong>Fees:</strong> <%= course.getCourseFees() %></p>
        </div>
    </div>
    <form action="deleteCourseServlet" method="post" class="mt-3">
        <input type="hidden" name="courseId" value="<%= course.getCourseId() %>">
        <button type="submit" class="btn btn-danger">Confirm Delete</button>
        <br> </br>
        <a href="listCoursesServlet" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
