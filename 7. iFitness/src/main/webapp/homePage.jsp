<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="pt-BR">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="css/homePage.css" rel="stylesheet">
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
    <title>iFitness - Home Page</title>
  </head>
  <body>
  
  <nav class="navbar navbar-expand-lg bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">IFitness</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link" href="activity-register.jsp">New Activity</a>
		        </li>
		        
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="#">Statistics</a>
		        </li>
		        
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            ${name}
		          </a>
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="#">Minha Conta</a></li>
		            <li><hr class="dropdown-divider"></li>
		            <li><a class="dropdown-item" href="#">Loggout</a></li>
		          </ul>
		        </li>
		      </ul>
		      <form class="d-flex" role="search">
		        <input class="form-control me-2" type="search" placeholder="Search by name" aria-label="Search">
		        <button class="btn btn-outline-success" type="submit">Search</button>
		      </form>
		    </div>
		  </div>
		</nav>
		
  	<div class="container">
  		<div class="center col-lg-10 col-sm-12">
  			<h1 class="text-center">Listagem de atividades</h1>
  			
  			<c:choose>
  				<c:when test="${fn:length(userActivities) > 0}">
  					<table class="table table-striped table-hover table-responsive">
 						<tr>
 							<th>#</th>
 							<th>Type</th>
 							<th>Date</th>
 							<th>Distance (Km/h)</th>
 							<th>Duration (Minutes)</th>
 						</tr> 		
 						<c:forEach var="activity" items="${userActivities}" varStatus="index">
 							<tr>
 								<td>${index.count}</td>
 								<td>
									<c:choose>
										<c:when test="${activity.type == 'RACE'}">
											<img src="img/running_icon.png" alt="Race">
										</c:when>
										<c:when test="${activity.type == 'HIKE'}">
											<img src="img/walking_icon.png" alt="Hike">
										</c:when>
										<c:when test="${activity.type == 'CYCLING'}">
											<img src="img/cycling_icon.png" alt="Ciclyng">
										</c:when>
										<c:when test="${activity.type == 'SWIM'}">
											<img src="img/swimming_icon.png" alt="Swim">
										</c:when>
									</c:choose>
								
								</td>
								<td>
									<fmt:parseDate value="${activity.date}" 
										pattern="yyyy-MM-dd" var="parsedDate"
										type="date" />
									<fmt:formatDate value="${parsedDate}" 
										var="formattedDate" type="date"
										pattern="dd/MM/yyyy"/>
									${formattedDate}
								</td>
 								<td>${activity.distance}</td>
 								<td>${activity.duration}</td>
 							</tr>
 						</c:forEach>			
  					</table>
   				</c:when>
  				<c:otherwise>
  					<c:out value="There hasn't any activity"></c:out>
  				</c:otherwise>
  			</c:choose>
  		</div>
    </div>
  </body>
</html>