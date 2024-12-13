<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="model.DailyTopicModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List of Details</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<script>
    $(document).ready(function () {
        // Initialize datepicker
        $('#datePicker').datepicker({
            format: 'yyyy-mm-dd',
            autoclose: true,
            todayHighlight: true
        }).on('changeDate', function (e) {
            // Automatically submit the form when a date is selected
            $('#filterForm').submit();
        });
    });
</script>
</head>
<body>

<div class="container my-5">
    <h2 class="text-center mb-4">List of Details</h2>

    <!-- Date Picker Form -->
    <form id="filterForm" action="ViewDailyTopicsServlet" method="get" class="mb-4">
        <div class="row">
            <div class="col-md-6">
                <input type="text" id="datePicker" name="date" class="form-control" placeholder="Select a Date" required>
            </div>
        </div>
    </form>

    <!-- Admin Page Button -->
    <div class="d-flex justify-content-end mb-3">
        <a href="home_admin.jsp" class="btn btn-secondary">Admin page</a>
    </div>

    <!-- Table -->
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Date</th>
                <th>Faculty Name</th>
                <th>Batch Name</th>
                <th>Start Time</th>
                <th>Topic Details</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${not empty topic}">
                    <c:forEach var="s" items="${topic}">
                        <tr>
                            <td>${s.date}</td>
                            <td>${s.facultyName}</td>
                            <td>${s.batchName}</td>
                            <td>${s.startTime}</td>
                            <td>${s.topicDetails}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="5" class="text-center">No details available for the selected date.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
</div>

</body>
</html>
