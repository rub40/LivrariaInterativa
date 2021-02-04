<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro</title>
    </head>
    <body>
        <form method="post" action=novaSessao>
           		<label for="nome">Nome</label></br>
                <input type="text" placeholder="Digite seu nome" name=nome style="width: 250px;" required></br></br>
                <input type="submit" style="width: 160px;" value="Cadastrar"></br>
        </form>
        <form Action=menuAdmin>
        	<input type="submit" value="Voltar" style="width: 160px;">
        </form>
    </body>
</html>