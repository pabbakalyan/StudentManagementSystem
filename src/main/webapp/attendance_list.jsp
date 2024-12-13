<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="model.AttendanceModel"%>
<%@ page import="model.BatchModel"%>
<%@ page import="dao.BatchDAO"%>
<%@ page import="dao.CourseDAO"%>
<%@ page import="model.CourseModel"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Attendance List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .form-group {
            margin-right: 10px; /* Add margin between elements */
        }
    </style>
</head>
<body>
    <div class="container my-5">
        <h2 class="text-center mb-4">Attendance List</h2>

        <!-- Admin Page Button -->
        <div class="d-flex justify-content-end mb-3">
            <a href="home_admin.jsp" class="btn btn-secondary">Admin page</a>
        </div>

        <!-- Form to Select Course, Batch, and Date (Side by Side) -->
        <form method="GET" action="listAttendanceServlet">
            <div class="row mb-3">
                <!-- Course Dropdown -->
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="courseDropdown">Select Course:</label>
                        <select id="courseDropdown" name="courseId" class="form-control" onchange="this.form.submit()">
                            <option value="" selected disabled>-- Select a Course --</option>
                            <%
                                // Fetch all courses
                                CourseDAO courseDAO = new CourseDAO();
                                List<CourseModel> courses = courseDAO.getAllCourses();
                                for (CourseModel course : courses) {
                            %>
                            <option value="<%= course.getCourseId() %>"
                                <%= request.getParameter("courseId") != null && 
                                    request.getParameter("courseId").equals(String.valueOf(course.getCourseId())) ? "selected" : "" %>>
                                <%= course.getCourseName() %>
                            </option>
                            <% } %>
                        </select>
                    </div>
                </div>

                <!-- Batch Dropdown -->
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="batchDropdown">Select Batch:</label>
                        <select id="batchDropdown" name="batchId" class="form-control" onchange="this.form.submit()">
                            <option value="" selected disabled>-- Select a Batch --</option>
                            <%
                                // Fetch batches based on selected course
                                String courseIdParam = request.getParameter("courseId");
                                if (courseIdParam != null && !courseIdParam.isEmpty()) {
                                    int courseId = Integer.parseInt(courseIdParam);
                                    BatchDAO batchDAO = new BatchDAO();
                                    List<BatchModel> batches = batchDAO.getBatchesByCourseId(courseId);
                                    for (BatchModel batch : batches) {
                            %>
                            <option value="<%= batch.getBatchId() %>"
                                <%= request.getParameter("batchId") != null && 
                                    request.getParameter("batchId").equals(String.valueOf(batch.getBatchId())) ? "selected" : "" %>>
                                <%= batch.getBatchName() %>
                            </option>
                            <% }} %>
                        </select>
                    </div>
                </div>

                <!-- Date Input -->
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="attendanceDate">Select Date:</label>
                        <input type="date" id="attendanceDate" name="attendanceDate" class="form-control"
                               value="<%= request.getParameter("attendanceDate") %>" onchange="this.form.submit()">
                    </div>
                </div>
            </div>
        </form>

        <!-- Display Attendance -->
        <%
            // Retrieve the attendance list from the request
            List<AttendanceModel> attendanceList = (List<AttendanceModel>) request.getAttribute("attendanceList");
        %>
        <%
            if (attendanceList == null || attendanceList.isEmpty()) {
        %>
        <p class="text-center text-muted">Please select a course, batch, and date to view attendance.</p>
        <% 
            } else { 
        %>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Attendance Status</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <% for (AttendanceModel attendance : attendanceList) { %>
                <tr>
                    <td><%= attendance.getStudentId() %></td>
                    <td><%= attendance.getStudentName() %></td>
                    <td><%= attendance.getStatus() %></td>
                    <td><%= attendance.getDate() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% } %>
    </div>
</body>
</html>
