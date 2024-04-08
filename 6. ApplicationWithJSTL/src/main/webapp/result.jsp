<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,br.edu.ifsp.arq.arqweb1.ApplicationWithJSTL.model.Person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Listagem de pessoas</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<c:choose>
		<c:when test="${fn:length(list) > 0}">
			<table> 
			
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>E-mail</th>
				</tr>
				
				<c:forEach var="person" items="${list}" varStatus="count">
					<tr>
						<td>${count.count}</td>
						<td>${person.getName()}</td>
						<td>${person.getCPF()}</td>
						<td>${person.getEmail()}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		
		<c:otherwise>
					<c:out value="Nenhuma pessoa registrada."></c:out>
		</c:otherwise>
	</c:choose>
		
</body> 
</html>