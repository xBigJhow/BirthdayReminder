<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registros</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/CSSformRegistraPessoa.css"> 
</head>

<body>
	<form action="<%= request.getContextPath() %>/registro" method="post">
    <h1>Registre uma nova pessoa!</h1>
    <label>Nome:</label>
    <input type="text" name="nome">
    <label>Data de Nascimento:</label>
    <input type="date" name="dataNascimento">
    <label>Observação:</label>
    <input type="text" name="obs">
    <input type="submit" value="Registrar">
    <a href="<%= request.getContextPath() %>/views/listaPessoas.jsp" class="list-link">Lista de Pessoas Registradas</a>

	</form>
	
	<!-- <a href="<%= request.getContextPath()%>/enviar" class="list-link">Enviar Email</a> -->
</body>
</html>