<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastro</title>
    </head>
    <body>
        <form method="post" action=cadastrar>
           		<label for="nome">Nome</label></br>
                <input type="text" placeholder="Digite seu nome" name=nome style="width: 250px;" required></br>
                <label for="sobrenome">Sobrenome</label></br>
                <input type="text" placeholder="Digite seu Sobrenome" name=sobrenome style="width: 250px;" required></br>
                <label for="email">E-mail</label></br>
                <input type="email" placeholder="Digite seu e-mail" name=email style="width: 250px;" required></br>
                <label for="login">Login</label></br>
                <input type="text" placeholder="Digite seu login" name=login style="width: 250px;" required></br>
                <label for="senha">Senha</label></br>
                <input type="password" placeholder="Digite sua senha" name=senha style="width: 250px;" required></br></br>
                <input type="submit" style="width: 160px;" value="Cadastrar"></br>
        </form>
        <form Action=login>
        	<input type="submit" value="Voltar" style="width: 160px;">
        </form>
    </body>
</html>