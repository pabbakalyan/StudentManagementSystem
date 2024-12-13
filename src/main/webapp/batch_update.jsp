<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page import="model.BatchModel" %>
 
 <% BatchModel batch = (BatchModel) request.getAttribute("batch"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Update Batch </title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
     <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
    <div class="form-container">
        <h2>Update Batch</h2>
        <form  action="BatchUpdateServlet" method="post">
            <div class="form-group">
                <label for="batchId">Batch ID</label>
                <input type="number" class="form-control" id="batchId" name="batchId" value="<%= batch.getBatchId() %>" readonly>
            </div>
            <div class="form-group">
                <label for="batchName">Batch Name</label>
                <input type="text" class="form-control" id="batchName" name="batchName" value="<%= batch.getBatchName() %>" required>
            </div>
            <div class="form-group">
                <label for="batchStart">Batch Start Date</label>
                <input type="date" class="form-control" id="batchStart" name="batchStart" value="<%= batch.getBatchStart() %>" required>
            </div>
            <div class="form-group">
                <label for="batchEnd">Batch End Date</label>
                <input type="date" class="form-control" id="batchEnd" name="batchEnd" value="<%= batch.getBatchEnd() %>" required>
            </div>
            <div class="form-group">
                <label for="batchTiming">Batch Timing</label>
                <input type="text" class="form-control" id="batchTiming" name="batchTiming" value="<%= batch.getBatchTiming() %>" required>
            </div>
            <div class="form-group">
                <label for="courseId">Course ID</label>
                <input type="number" class="form-control" id="courseId" name="courseId" value="<%= batch.getCourseId() %>"readonly>
            </div>
            <input type="hidden" name="courseId" value="<%= batch.getCourseId() %>">
            <button type="submit" class="btn btn-primary">Update Batch</button>
        </form>
    </div>
</body>
</html>
