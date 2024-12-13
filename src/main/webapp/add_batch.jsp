<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Batch</title>
     <!-- Bootstrap CSS -->
     <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
     <!-- Bootstrap JS and jQuery -->
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
     <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>

	<!-- Toast Notification -->
    <div class="toast-container">
        <div id="toastMessage" class="toast" role="alert" aria-live="assertive" aria-atomic="true" 
            data-message="<%= (String) request.getAttribute("toastMessage") %>">
            <div class="toast-header">
                <strong class="mr-auto">Notification</strong>
                <small class="text-muted">Now</small>
                <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="toast-body"></div>
        </div>
    </div>
    
    <!-- Form Container -->
    <div class="form-container">
        <h2>Add Batches</h2>
        <form id="addBatchForm" name="loginForm" action="batchServlet" method="post">

            <div class="form-group">
                <label for="BatchId">Batch Id:</label>
                <input type="number" id="batchId" class="form-control" name="batchId" required>
            </div>

            <div class="form-group">
                <label for="BatchName">Batch Name:</label>
                <input type="text" id="batchName" class="form-control" name="batchName" required>
            </div>

            <div class="form-group">
                <label for="BatchStart">Batch Start:</label>
                <input type="date" id="batchStart" class="form-control" name="batchStart" required>
            </div>

            <div class="form-group">
                <label for="BatchEnd">Batch End:</label>
                <input type="date" id="batchEnd" class="form-control" name="batchEnd" required>
            </div>

            <div class="form-group">
                <label for="BatchTiming">Batch Timing:</label>
                <input type="text" id="batchTiming" class="form-control" name="batchTiming" placeholder="e.g., 10:00 AM - 1:00 PM" required>
            </div>

            <div class="form-group">
                <label for="courseId">Course Id:</label>
                <input type="number" id="courseId" class="form-control" name="courseId" required>
            </div>

            <button type="submit">Add Batch</button>
        </form>
    </div>

    <!-- Include the toast.js script -->
    <script src="${pageContext.request.contextPath}/js/toast.js"></script>
</body>
</html>
