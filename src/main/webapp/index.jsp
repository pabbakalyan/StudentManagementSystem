<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginstyle.css">
    <title>Modern Login Page</title>
    <script src="script.js" defer></script> 
</head>
<body>
    <div class="container" id="container">
        <!-- Sign-Up Form -->
        <div class="form-container sign-up">
           <form name="registration" action="signup" method="post" onsubmit="return verifySignUp()">
                <h1>Create Account</h1>
                <div class="social-icons">
                    <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                </div>
                <span>or use your email for registration</span>
                <input type="text" name="username" id="signupUsername" placeholder="Username">
                <div id="signupUsernameError" class="error-message"></div>

                <input type="email" name="email" id="signupEmail" placeholder="Email">
                <div id="signupEmailError" class="error-message"></div>

                <input type="password" name="password" id="signupPassword" placeholder="Password">
                <div id="signupPasswordError" class="error-message"></div>

                <label for="signupUserType">User Type:</label>
                <select id="signupUserType" name="userType" class="form-control">
                    <option value="" disabled selected>Select User Type</option>
                    <option value="admin">Admin</option>
                    <option value="faculty">Faculty</option>
                    <option value="student">Student</option>
                </select>
                <button type="submit">Sign Up</button>
            </form>
        </div>

        <!-- Sign-In Form -->
        <div class="form-container sign-in">
           <form name="loginForm" action="loginServlet" method="post" onsubmit="return verifySignIn()">
                <h1>Sign In</h1>
                <div class="social-icons">
                    <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                </div>
                <span>or use your username for login</span>
                <input type="text" id="signinUsername" name="username" placeholder="Username">
                <div id="signinUsernameError" class="error-message"></div>

                <input type="password" id="signinPassword" name="password" placeholder="Password">
                <div id="signinPasswordError" class="error-message"></div>

                <label for="signinUserType">User Type:</label>
                <select id="signinUserType" name="userType" class="form-control">
                    <option value="" disabled selected>Select User Type</option>
                    <option value="admin">Admin</option>
                    <option value="faculty">Faculty</option>
                    <option value="student">Student</option>
                </select>
                <button type="submit">Sign In</button>
            </form>
        </div>

        <!-- Toggle Panels -->
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Welcome Back!</h1>
                    <p>Enter your personal details to use all site features</p>
                    <button class="hidden" id="login">Sign In</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Hello, Friend!</h1>
                    <p>Register with your personal details to use all site features</p>
                    <button class="hidden" id="register">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
