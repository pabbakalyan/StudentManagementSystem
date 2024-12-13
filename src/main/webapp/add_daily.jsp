<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Daily Topics</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
    <!-- Optional Custom CSS for positioning -->
    <style>
        .admin-home-btn {
            position: fixed;
            top: 10px;
            right: 10px;
            padding: 5px 10px;
            font-size: 14px;
            z-index: 1000;
            white-space: nowrap;
        }
    </style>
</head>
<body>
	 <!-- Admin Home Button (Top Right) 
    <a href="home_admin.jsp" class="btn btn-secondary admin-home-btn">Admin Home</a>-->
	
    <div class="container my-5">
        <h2 class="text-center mb-4">Daily Topics Management</h2>

        <!-- Cards for Add Attendance and List Attendance -->
        <div class="row">
            <!-- Add Attendance Card -->
            <div class="col-md-6 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="add_daily_form.jsp" class="btn btn-primary">Add Topics</a>
                    </div>
                </div>
            </div>

            <!-- List Attendance Card -->
            <div class="col-md-6 mb-4">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="ViewDailyTopicsServlet" class="btn btn-primary">List Topics</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
