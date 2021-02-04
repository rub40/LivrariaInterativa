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
        <form method="post" action=alterarLivro>
                <input type="hidden" name=codigo value=${livro.codigo} style="width: 250px;" required></br>
                <label for="nome">Nome</label></br>
                <input type="text" name=nome value=${livro.nome} style="width: 250px;" required></br>
                <label for="preco">Preço</label></br>
                <input type="number" step="0.2" value=${livro.preco} name=preco style="width: 250px;" required></br>
                <label for="autor">Autor</label></br>
                <input type="text" name=autor value=${livro.autor} style="width: 250px;" required></br>
                <label for="quantidade">Quantidade</label></br>
                <input type="number" name=quantidade value=${livro.quantidade} style="width: 250px;" required></br>
                <label name="sessao.codigo">Sessão</label></br>
                <select style="width: 250px;" name="sessao.codigo" required>
				    <c:forEach var="sessao" items="${sessoes}">
				    <c:choose>
				    	<c:when test="${sessao.codigo == livro.sessao.codigo}">
				    		<option selected value="${sessao.codigo}">${sessao.nome}</option>
				    	</c:when>
				    	<c:otherwise>
				    		<option value="${sessao.codigo}">${sessao.nome}</option>
				    	</c:otherwise>
				    </c:choose>
				    </c:forEach>
			    </select></br></br>
                <input type="submit" style="width: 160px;" value="Editar"></br>
        </form>
        <form Action=menuAdmin>
        	<input type="submit" value="Voltar" style="width: 160px;">
        </form>
    </body>
</html>