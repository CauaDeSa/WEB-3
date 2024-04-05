<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="pt-BR">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<link href="css/errors.css" rel="stylesheet">
	<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script defer src="js/user-register.js"></script>
    <title>iFitness - Signup Page</title>
  </head>
  <body>
  	<div class="container">
		<div class="col-lg-4 offset-lg-4 col-sm-12">
	    	<form action="userRegister" method="post" id="form1">
				<h1 class="text-center mt-5" >Register</h1>
				
				<div class="mb-3">
					<label for="name">Full Name*</label>
					<input type="text" name="name" id="name" class="form-control" minlength="3" maxlength="50" required="required">
					<span id="0"></span>
				</div>
				
				<div class="mb-3">
					<label for="email">Email*</label>
					<input type="email" name="email" id="email" class="form-control" minlength="3" maxlength="50" required="required">
					<span id="1"></span>
				</div>
				
				<div class="mb-3">
					<label for="password">Password*</label>
					<input type="password" name="password" id="password" class="form-control" minlength="6" maxlength="12" required="required">
					<span id="2"></span>
				</div>
				
				<div class="mb-3">
					<label for="confirmPassword">Confirm Password*</label>
					<input type="password" name="confirmPassword" id="confirmPassword" class="form-control" minlength="6" maxlength="12" required="required">
					<span id="3"></span>
				</div>
				
				<div class="mb-3">
					<label for="dateOfBirth">Birth date*</label>
					<input type="date" name="dateOfBirth" id="dateOfBirth" class="form-control" required="required">
					<span id="4"></span>
				</div>
				
				<div class="mb-3">
					<label for="gender">Gender*</label>
					<select class="form-select" name="gender" id="gender" required="required">
						<option value="" selected>Select</option>
						<option value="MALE">Male</option>
						<option value="FEMALE">Female</option>
						<option value="OTHER">Other</option>
						<option value="IDK">Idk</option>
					</select>
					<span id="5"></span>
				</div>
				
				<div class="mb-3">
					<button type="submit" class="btn btn-primary col-lg-12">Register</button>
				</div>
	    	</form>	
		</div>    	
    </div>
  </body>
</html>