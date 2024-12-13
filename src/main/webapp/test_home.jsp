<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container my-5">
        <h2 class="text-center mb-4">Test Management</h2>
        <p class="text-center">Manage all test-related tasks, including creating, assigning, and viewing results.</p>
        <hr>
        <div class="text-center">
            <a href="create_test.jsp" class="btn btn-primary m-2">Create a New Test</a>
            <a href="assign_test.jsp" class="btn btn-warning m-2">Assign a Test</a>
            <a href="view_test_results.jsp" class="btn btn-success m-2">View Test Results</a>
            <a href="manage_questions.jsp" class="btn btn-secondary m-2">Manage Questions</a>
        </div>
    </div>
</body>
</html>
