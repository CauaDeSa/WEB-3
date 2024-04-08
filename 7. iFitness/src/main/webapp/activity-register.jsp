<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!doctype html>
<html lang="pt-BR">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<link href="css/errors.css" rel="stylesheet">
	<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <title>iFitness - Activity Registration Page</title>
  </head>
  <body>
  	<div class="container">
  	
  			<c:if test="${result == 'notRegistered'}">

				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					Activity not registered.
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>

			</c:if>
			<c:if test="${result == 'registered'}">

				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					Activity successfully registered.
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>

			</c:if>
			
		<div class="col-lg-4 offset-lg-4 col-sm-12">
	    	<form action="activityRegister" method="post" id="form2">
	    	
	    		<h1 class="text-center mt-5" >New activity</h1>
	    		
	    		<div class="mb-3">
					<label for="activityType">Activity tpe*</label>
					<select class="form-select" name="activityType" id="activityType" required="required">
						<option value="" selected>Select</option>
						<option value="HIKE">hike</option>
						<option value="CYCLING">Cycling</option>
						<option value="HIKE">hike</option>
						<option value="SWIM">Swim</option>
					</select>
				</div>
	    	
	    		<div class="mb-3">
					<label for="date">Date*</label>
					<input type="date" name="date" id="date" class="form-control" required="required">
				</div>
				
				<div class="mb-3">
					<label for="distance">Distance) (KM)*</label>
					<input type="number" name="distance" id="distance" class="form-control" step="0.1" min="0.1" required="required">
				</div>
				
				<div class="mb-3">
					<label for="duration">Duration (Minutes)*</label>
					<input type="number" name="duration" id="duration" class="form-control" step="1" min="1" required="required">
				</div>
				
				<div class="mb-3">
					<label for="confirmPassword">Confirm Password*</label>
					<input type="password" name="confirmPassword" id="confirmPassword" class="form-control" minlength="6" maxlength="12" required="required">
				</div>
				
				<div class="mb-3">
					<button type="submit" class="btn btn-primary col-lg-12">Register</button>
				</div>
	    	</form>	
		</div>    	
    </div>
  </body>
</html>