<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Compras</h1>
<table border=1>
<tr>
	<th>codigo</th>
	<th>Data</th>
	<th>Valor Compra</th>
	<th>Qtd Livros</th>
</tr>
<c:forEach var="compra" items="${compras}">
<tr>
	<td>${compra.codigo}</td>
	<td>${compra.data}</td>
	<td>${compra.valorTotal}</td>
	<td>${compra.qtdLivros}</td>
	<td><a href=listarItensCompra?codigo=${compra.codigo}>Detalhes da compra</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>