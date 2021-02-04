<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Page</title>
    </head>
    <body>
    	<form action=cadastrarLivro>
			<input type="submit" value="Cadastrar Livro" style="width: 160px;">
    	</form>
    	<form action=cadastrarSessao>
    		<input type="submit" value="Cadastrar Sessão" style="width: 160px;">
    	</form>
    	<form action=listarSessao>
    		<input type="submit" value="Listar Sessão" style="width: 160px;">
    	</form>
    	<form action=listarLivros>
    		<input type="submit" value="Listar Livros" style="width: 160px;">
    	</form>	
    	<form action=logout>
    		<input type="submit" value="Logout" style="width: 160px;">
    	</form>
    </body>
</html>