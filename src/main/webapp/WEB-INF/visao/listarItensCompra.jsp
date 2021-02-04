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
<h1>Detalhe Compra</h1>
<p>Codigo: ${ compra.codigo }</p>
<p>Data Compra: ${ compra.data }</p>
<p>Valor Total: ${ compra.valorTotal }</p>
<p>Quantidade de Livros: ${ compra.qtdLivros }</p>
<h2>Livros comprados</h2>
<table border=1>
<tr>
	<th>Nome</th>
	<th>Autor</th>
	<th>sessao</th>
	<th>Valor</th>
</tr>
<c:forEach var="item" items="${compra.itens}">
<tr>
	<td>${item.livro.nome}</td>
	<td>${item.livro.autor}</td>
	<td>${item.livro.sessao.nome}</td>
	<td>${item.livro.preco}</td>
</tr>
</c:forEach>
</table>

</body>
</html>