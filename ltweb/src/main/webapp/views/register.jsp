<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
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

	<form action="action_page.php">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
    <hr>

    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
    <button type="submit" class="registerbtn">Register</button>
  </div>

  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>
</form>

</body>
</html>