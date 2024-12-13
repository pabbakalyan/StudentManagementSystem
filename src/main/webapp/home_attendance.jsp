<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Full Calendar with Attendance</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/studentstyle.css"> 
</head>
<body>
    <div class="container">
        <div class="calendar-header">
            <button id="prev-month">Previous</button>
            <h2 id="current-month">November 2024</h2>
            <button id="next-month">Next</button>
        </div>

        <div class="calendar">
            <!-- Days of the week -->
            <div class="day">Sun</div>
            <div class="day">Mon</div>
            <div class="day">Tue</div>
            <div class="day">Wed</div>
            <div class="day">Thu</div>
            <div class="day">Fri</div>
            <div class="day">Sat</div>
            <!-- Dates will be generated dynamically -->
        </div>

        <div class="attendance">
            <h3>Attendance Details</h3>
            <p id="attendance-message">Click a date to view attendance.</p>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/attendance.js"></script>

</body>
</html>