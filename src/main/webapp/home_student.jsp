<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/studentstyle.css">

    
 </head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="home_cards.jsp">Courses</a></li>
                 <li><a href="logout" class="signout-link">Sign Out</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <aside>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="studentDashboard">Classes</a></li>
                <li><a href="home_attendance.jsp">Attendance</a></li>
                <li><a href="#">Marks</a></li>
                <li><a href="#">My Resume</a></li>
                <li><a href="#">My Jobs</a></li>
                </ul>
        </aside>

        <section>
            <div class="content">
                <h1>Welcome, ${sessionScope.username}!</h1>
                <p>This is your personalized dashboard to track your academic progress.</p>
                </div>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 Your School/Institution Name</p>
    </footer>
</body>
</html>