<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<thead>
			<tr>
				<th>#</th>
				<th>nome</th>
				<th>cpf</th>
				<th>nascimento</th>
				<th>situacao</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<td>${cliente.id}</td> 
					<td>${cliente.nome}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.nascimento}</td> 
					<td>${cliente.situacao}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>