<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
     <!-- Bootstrap CSS -->
     <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
     <!-- Bootstrap JS and jQuery -->
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
     <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
     <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body class="student-body">

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
	
    <div class="student-container">
        <h2>Add Student</h2>
        <form id="addStudentForm" name="loginForm" action="studentServlet" method="post">
        
            <div class="form-group">
                <label for="studentId">Student Id</label>
                <input type="number" id="studentId" class="form-control" name="studentId" required>
            </div>
            
            <div class="form-group">
                <label for="studentFirstName">First Name:</label>
                <input type="text" id="studentFirstName" class="form-control" name="studentFirstName" required>
            </div>

            <div class="form-group">
                <label for="studentLastName">Last Name:</label>
                <input type="text" id="studentLastName" class="form-control" name="studentLastName" required>
            </div>

             <div class="form-group">
                <label for="mobile">Mobile Number:</label>
                <input type="number" id="mobile" class="form-control" name="mobile" maxlength=10 required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" class="form-control" name="email" required>
            </div>

            <div class="form-group">
                <label for="yrPass">Pased Out Year:</label>
                <input type="number" id="yrPass" class="form-control" name="yrPass" required>
            </div>

            <div class="form-group">
                <label for="branch">Branch:</label>
                <input list="branches" id="branch" class="form-control" name="branch" required>
                <datalist id="branches">
                    <option value="CSE">
                    <option value="EEE">
                    <option value="ECE">
                    <option value="Mechanical">
                    <option value="IT">
                    <option value="Civil">
                </datalist>
            </div>

            <div class="form-group d-flex">
                <label>Gender:</label>
                <span><input type="radio" id="male" name="gender" value="Male" required>
                <label for="male">Male</label></span>

                <span><input type="radio" id="female" name="gender" value="Female" required>
                <label for="female">Female</label></span>

                <span><input type="radio" id="other" name="gender" value="Other" required>
                <label for="other">Other</label></span>
            </div>

            <div class="form-group">
                <label for="batchId">Batch Id:</label>
                <input type="number" id="batchId" class="form-control" name="batchId" required>
            </div>
            
            <div class="form-group">
                <label for="courseId">Course Id:</label>
                <input type="number" id="courseId" class="form-control" name="courseId" required>
            </div>

            <button type="submit" class="btn btn-primary">Add Student</button>
        </form>
    </div>

   <!-- Include the toast.js script -->
    <script src="${pageContext.request.contextPath}/js/toast.js"></script>
</body>
</html>
