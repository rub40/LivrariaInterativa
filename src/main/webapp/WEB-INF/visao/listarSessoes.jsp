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
<h1>Sessões</h1>
<table border=1>
<tr>
	<th>codigo</th>
	<th>Nome</th>
</tr>
<c:forEach var="sessao" items="${sessoes}">
<tr>
	<td>${sessao.codigo}</td>
	<td>${sessao.nome}</td>
<!-- 	<td><a href=removerSessao?codigo=${sessao.codigo}>Remover</a></td> -->
</tr>
</c:forEach>
</table>
</br>
<form Action=menuAdmin>
        	<input type="submit" value="Voltar" style="width: 160px;">
</form>
</body>
</html>