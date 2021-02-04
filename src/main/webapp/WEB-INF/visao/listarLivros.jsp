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
	<td><a href=editarLivro?codigo=${livro.codigo}>Editar</a></td>
<!-- 	<td><a href=removerLivro?codigo=${livro.codigo}>Remover</a></td> -->
</tr>
</c:forEach>
</table>
</br>
<form Action=menuAdmin>
        	<input type="submit" value="Voltar" style="width: 160px;">
</form>
</body>
</html>