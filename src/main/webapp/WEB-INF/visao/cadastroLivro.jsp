<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro</title>
    </head>
    <body>
        <form method="post" action=inserirLivro>
                <label for="nome">Nome</label></br>
                <input type="text" name=nome style="width: 250px;" required></br>
                <label for="preco">Preço</label></br>
                <input type="number" step="0.2" name=preco style="width: 250px;" required></br>
                <label for="autor">Autor</label></br>
                <input type="text" name=autor style="width: 250px;" required></br>
                <label for="quantidade">Quantidade</label></br>
                <input type="number" name=quantidade style="width: 250px;" required></br>
                <label name="sessao.codigo">Sessão</label></br>
                <select style="width: 250px;" name="sessao.codigo" required>
				    <c:forEach var="sessao" items="${sessoes}">
				        <option value="${sessao.codigo}">${sessao.nome}</option>
				    </c:forEach>
			    </select></br></br>
                
                <input type="submit" style="width: 160px;" value="Cadastrar"></br>
        </form>
        <form Action=menuAdmin>
        	<input type="submit" value="Voltar" style="width: 160px;">
        </form>
    </body>
</html>