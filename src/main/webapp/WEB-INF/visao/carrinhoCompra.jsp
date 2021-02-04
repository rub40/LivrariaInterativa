<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrinho</title>
</head>
<body>
<p>Seja bem vindo, ${usuario.login} | <a href=logout>Sair</a></p>
<h1>Carrinho</h1>
<table border=1>
<tr>
	<th>Codigo</th>
	<th>Nome</th>
	<th>Preço</th>
</tr>
<c:forEach var="livro" items="${carrinho}">
<tr>
	<td>${livro.codigo}</td>
	<td>${livro.nome}</td>
	<td>${livro.preco}</td>
	<td><a href=removerLivroCarrinho?codigo=${livro.codigo}>Remover</a></td>
</tr>
</c:forEach>
<tr><td colspan=4><a href=listarLivrosCliente>Continuar comprando</a></td></tr>
</table>
<a href=finalizarCompra>Finalizar</a>
</body>
</html>