<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Faculty</title>
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
    
    <div class="faculty-container">
        <h2>Add Faculty</h2>
        <form id="addFacultyForm" name="loginForm" action="facultyServlet" method="post">
            
            <div class="form-group">
                <label for="facultyId">Faculty Id:</label>
                <input type="number" id="facultyId" class="form-control" name="facultyId" required>
            </div>
            
            <div class="form-group">
                <label for="facultyFirstName">First Name:</label>
                <input type="text" id="facultyFirstName" class="form-control" name="facultyFirstName" required>
            </div>

            <div class="form-group">
                <label for="facultyLastName">Last Name:</label>
                <input type="text" id="facultyLastName" class="form-control" name="facultyLastName" required>
            </div>

            <div class="form-group">
                <label for="mobile">Mobile Number:</label>
                <input type="number" id="mobile" class="form-control" name="mobile" maxlength="10" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" class="form-control" name="email" required>
            </div>

            <div class="form-group">
                <label for="yearsExperience">Years of Experience:</label>
                <input type="number" id="yearsExperience" class="form-control" name="yearsExperience" required>
            </div>

            <div class="form-group">
                <label for="certificate">Certificate:</label>
                <input type="text" id="certificate" class="form-control" name="certificate" required>
            </div>

            <div class="form-group">
                <label for="qualification">Qualification:</label>
                <input type="text" id="qualification" class="form-control" name="qualification" required>
            </div>
            
            <div class="form-group">
                <label for="batchId">Batch Id:</label>
                <input type="number" id="batchId" class="form-control" name="batchId" required>
            </div>

            <div class="form-group">
                <label for="courseId">Course Id:</label>
                <input type="number" id="courseId" class="form-control" name="courseId" required>
            </div>

            <button type="submit">Add Faculty</button>
        </form>
    </div>

    <!-- Include the toast.js script -->
    <script src="${pageContext.request.contextPath}/js/toast.js"></script>
</body>
</html>
