<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
   <head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Login</title>
	</head>
	<body>
	    <form method="post" action=autenticar>
	            <label for=""login"">Nome de usuário</label></br>
	            <input type="text" placeholder="Digite seu usuário" name="login" required style="width: 160px;"></br>
	            <label for="senha">Senha</label></br>
	            <input type="password" placeholder="Digite sua senha" required name="senha" style="width: 160px;"></br></br>
	            <input type="submit" style="width: 160px;" value="Entrar"></br>
	    </form>
	    <form action=cadastroUsuario>
	   	 <input type="submit" style="width: 160px;" value="Novo Usuário">
	    </form>
	</body>
</html>