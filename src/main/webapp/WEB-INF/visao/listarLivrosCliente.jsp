<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos</title>
</head>
<body>
<p>Seja bem vindo, ${usuario.login} | <a href=logout>Sair</a></p>
<h1>Livros</h1>
<table border=1>
<tr>
	<th>codigo</th>
	<th>Nome</th>
	<th>Autor</th>
	<th>Sessão</th>
	<th>Preço</th>
	<th>Qtd em Estoque</th>
</tr>
<c:forEach var="livro" items="${livros}">
<tr>
	<td>${livro.codigo}</td>
	<td>${livro.nome}</td>
	<td>${livro.autor}</td>
	<td>${livro.sessao.nome}</td>
	<td>${livro.preco}</td>
	<td>${livro.quantidade}</td>
	<td><a href=adicionarLivroCarrinho?codigo=${livro.codigo}>Adicionar</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>