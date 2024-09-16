<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
/* CSS styles for the registration form container */
.registration-container {
	width: 600px; /* Set the width of the container */
	margin: 0 auto; /* Center the container horizontally */
	padding: 20px; /* Add some padding inside the container */
	border: 2px solid #ccc; /* Add a border */
	border-radius: 10px; /* Add some border radius */
	background-color: #f9f9f9; /* Background color */
}

/* CSS styles for the heading */
.registration-heading {
	text-align: center; /* Center the heading text */
}

/* CSS styles for input fields */
.input-field {
	width: 100%;
	padding: 8px;
	margin: 5px 0;
	box-sizing: border-box;
}
</style>
</head>
<body>

<div class="registration-container">
    <h2 class="registration-heading">Register</h2>
    
    <form action="/ltweb/register" method="post">
        <label for="fullname"><b>Full Name</b></label>
        <input type="text" placeholder="Enter Full Name" name="fullname" id="fullname" class="input-field" required>
        
        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" id="username" class="input-field" required>
        
        <label for="email"><b>Email</b></label>
        <input type="email" placeholder="Enter Email" name="email" id="email" class="input-field" required>

        <label for="phone"><b>Phone</b></label>
        <input type="text" placeholder="Enter Phone Number" name="phone" id="phone" class="input-field" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" class="input-field" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" class="input-field" required>

        <label for="images"><b>Image URL</b></label>
        <input type="text" placeholder="Enter Image URL" name="images" id="images" class="input-field">
        
        <hr>
        
        <button type="submit" class="registerbtn btn btn-primary">Register</button>
    </form>

    <div class="container signin">
        <p>Already have an account? <a href="/ltweb/login">Sign in</a>.</p>
    </div>
</div>

</body>
</html>
