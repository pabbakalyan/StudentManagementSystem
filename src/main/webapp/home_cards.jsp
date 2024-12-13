<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cards</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cards.css">
</head>
<body>
    <div class="card-group">
        <!-- Card 1 -->
        <div class="card" data-content="Java Full Stack: A Java full-stack web developer is a developer with extensive knowledge and expertise in full-stack tools and frameworks that work with Java. Duration: 4 Months">
            <img src="${pageContext.request.contextPath}/images/java.jpg" alt="Java Full Stack">
            <div class="layer"></div>
            <div class="info">
                <h1>Java Full Stack</h1>
                <p>A comprehensive course for Java developers to become full-stack experts.</p>
                <button class="explore-btn">Explore</button>
            </div>
        </div>
        <!-- Card 2 -->
        <div class="card" data-content="Python Full Stack: Learn Python and related frameworks to become a full-stack developer. Duration: 3 Months">
            <img src="${pageContext.request.contextPath}/images/python.jpg" alt="Python Full Stack">
            <div class="layer"></div>
            <div class="info">
                <h1>Python Full Stack</h1>
                <p>Master Python, Django, and Flask to create end-to-end applications.</p>
                <button class="explore-btn">Explore</button>
            </div>
        </div>
        <!-- Card 3 -->
        <div class="card" data-content="Testing: Learn manual and automation testing to validate applications effectively. Duration: 2 Months">
            <img src="${pageContext.request.contextPath}/images/testing.jpg" alt="Testing">
            <div class="layer"></div>
            <div class="info">
                <h1>Testing</h1>
                <p>Ensure the quality of software with manual and automated testing skills.</p>
                <button class="explore-btn">Explore</button>
            </div>
        </div>
        <!-- Card 4 -->
        <div class="card" data-content="DevOps: Learn the fundamentals of CI/CD, Docker, Kubernetes, and Cloud. Duration: 4 Months">
            <img src="${pageContext.request.contextPath}/images/devops.jpg" alt="DevOps">
            <div class="layer"></div>
            <div class="info">
                <h1>DevOps</h1>
                <p>Integrate development and operations with modern DevOps practices.</p>
                <button class="explore-btn">Explore</button>
            </div>
        </div>
        <!-- Card 5 -->
        <div class="card" data-content="Data Science: Learn machine learning, AI, and data analysis. Duration: 6 Months">
            <img src="${pageContext.request.contextPath}/images/data.jpg" alt="Data Science">
            <div class="layer"></div>
            <div class="info">
                <h1>Data Science</h1>
                <p>Gain expertise in analyzing and interpreting complex data for insights.</p>
                <button class="explore-btn">Explore</button>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal" id="modal">
        <div class="modal-content">
            <span class="close-btn" id="closeBtn">&times;</span>
            <p id="modalText"></p>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/js/cardsscript.js"></script>

</body>
</html>
