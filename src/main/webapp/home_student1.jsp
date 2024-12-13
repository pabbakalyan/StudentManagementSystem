<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    
    <h2>Your Enrolled Courses</h2>
   <table class="table table-bordered mt-4" >
    <thead>
        <tr>
            <th>Course Name</th>
            <th>Duration</th>
            <th>Fees</th>
            <th>Batch Name</th>
            <th>Batch Start</th>
            <th>Batch End</th>
            <th>Batch Timing</th>
            <th>Faculty Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.courseName}</td>
                <td>${course.courseDuration}</td>
                <td>${course.courseFees}</td>
                <td>${course.batchName}</td>
                <td>${course.batchStart}</td>
                <td>${course.batchEnd}</td>
                <td>${course.batchTiming}</td>
                <td>${course.facultyName}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
