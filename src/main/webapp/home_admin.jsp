
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/Style.css">
    <!-- Bootstrap JS (optional for Bootstrap components) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container my-5">

        <h2 class="text-center mb-4">Welcome, <%= session.getAttribute("username") %>! (Role: <%= session.getAttribute("userType") %>)</h2>
         

        <!-- Logout Button -->
        <div class="text-end mb-4">
            <form action="logout" method="get">
                <button type="submit" class="btn btn-danger">Logout</button>
            </form>
        </div>

        <!-- First Row -->
        <div class="row mb-4">
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="add_course.jsp" class="btn btn-primary">Add Course</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="listCoursesServlet" class="btn btn-primary">List of Courses</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="add_batch.jsp" class="btn btn-primary">Add Batch</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="listBatchServlet" class="btn btn-primary">List of Batches</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Second Row -->
        <div class="row">
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="add_student.jsp" class="btn btn-success">Add Student</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="listStudentsServlet" class="btn btn-success">List of Students</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="add_faculty.jsp" class="btn btn-success">Add Faculty</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="listFacultyServlet" class="btn btn-success">List of Faculty</a>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Third Row -->
        <div class="row">
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="attendance.jsp" class="btn btn-secondary">Attendance</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="add_daily.jsp" class="btn btn-secondary">Daily Topics</a>
                    </div>
                </div>
            </div>
            
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="test_home.jsp" class="btn btn-secondary">Test</a>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center">
                    <div class="card-body">
                        <a href="#" class="btn btn-secondary">marks</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
