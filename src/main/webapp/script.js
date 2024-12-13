document.addEventListener("DOMContentLoaded", () => {
    // Get the elements
    const container = document.getElementById("container");
    const signUpButton = document.getElementById("register");
    const signInButton = document.getElementById("login");

    // Add event listener for Sign Up button
    signUpButton.addEventListener("click", () => {
        container.classList.add("active"); // Add 'active' class to container
    });

    // Add event listener for Sign In button
    signInButton.addEventListener("click", () => {
        container.classList.remove("active"); // Remove 'active' class from container
    });
});

// Validate Sign-Up Form
function verifySignUp() {
    const username = document.getElementById("signupUsername").value.trim();
    const email = document.getElementById("signupEmail").value.trim();
    const password = document.getElementById("signupPassword").value.trim();
    const userType = document.getElementById("signupUserType").value;

    let valid = true;

    // Validate username
    if (username === "") {
        document.getElementById("signupUsernameError").innerHTML = "*Username is required";
        valid = false;
    } else if (username.length < 3) {
        document.getElementById("signupUsernameError").innerHTML = "*Username must be at least 3 characters long";
        valid = false;
    } else {
        document.getElementById("signupUsernameError").innerHTML = "";
    }

    // Validate email
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (email === "") {
        document.getElementById("signupEmailError").innerHTML = "*Email is required";
        valid = false;
    } else if (!emailRegex.test(email)) {
        document.getElementById("signupEmailError").innerHTML = "*Invalid email format";
        valid = false;
    } else {
        document.getElementById("signupEmailError").innerHTML = "";
    }

    // Validate password
    if (password === "") {
        document.getElementById("signupPasswordError").innerHTML = "*Password is required";
        valid = false;
    } else if (password.length < 6) {
        document.getElementById("signupPasswordError").innerHTML = "*Password must be at least 6 characters long";
        valid = false;
    } else {
        document.getElementById("signupPasswordError").innerHTML = "";
    }

    // Validate user type
    if (!userType) {
        alert("Please select a user type");
        valid = false;
    }

    return valid; // Form submission happens only if valid === true
}

// Validate Sign-In Form
function verifySignIn() {
    const username = document.getElementById("signinUsername").value.trim();
    const password = document.getElementById("signinPassword").value.trim();

    let valid = true;

    // Validate username
    if (username === "") {
        document.getElementById("signinUsernameError").innerHTML = "*Username is required";
        valid = false;
    } else {
        document.getElementById("signinUsernameError").innerHTML = "";
    }

    // Validate password
    if (password === "") {
        document.getElementById("signinPasswordError").innerHTML = "*Password is required";
        valid = false;
    } else {
        document.getElementById("signinPasswordError").innerHTML = "";
    }

    return valid; // Form submission happens only if valid === true
}
