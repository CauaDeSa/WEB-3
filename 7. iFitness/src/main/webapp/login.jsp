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
    <link href="css/login.css" rel="stylesheet">
	<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <title>iFitness - Login Page</title>
  </head>
  <body>
  	<div class="container">
  	
  				<c:choose>
					<c:when test="${result == 'notFound'}">
						<div class="alert alert-danger alert-dismissible fade show"
							role="alert">
							Usuário não encontrado! Verifique os dados e tente novamente.
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
					</c:when>
					<c:when test="${result == 'registered'}">
		
						<div class="alert alert-success alert-dismissible fade show"
							role="alert">
							Cadrasto realizado com sucesso! Faça login para continuar.
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
		
					</c:when>
				</c:choose>
    	<form action="login" method="post">
			<div class="col-lg-4 offset-lg-4 col-sm-12">
				<h1 class="text-center mt-5">Login</h1>
				
				<div class="input-group mb-3">
					<span class="input-group-text">
						<img alt="Label for email" src="img/envelope.svg" width="32" height="32">
					</span>
					<input type="email" name="email" id="email" placeholder="E-mail" required="required" class="form-control">
				</div>
				
				<div class="input-group mb-3">
					<span class="input-group-text">
						<img alt="Label for password" src="img/lock.svg" width="32" height="32">
					</span>
					<input type="password" name="password" id="password" placeholder="Password" required="required" class="form-control">
				</div>
				
				<div class="mb-3 ">
					<button type="submit" class="btn btn-primary col-lg-12">Login</button>
				</div>
				
				<div class="mb-3">
					<a href="user-register.jsp" class="btn btn-secondary col-lg-12">Register</a>
				</div>
			</div>    	
    	</form>
    </div>
  </body>
</html>