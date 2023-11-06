<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="registraAniversario.model.Pessoa" %>
<% Pessoa pessoa = (Pessoa) request.getAttribute("pessoa"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/CSSatualizaPessoa.css"> 
<meta charset="UTF-8">
<title>Registros</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/confirmarAtualizacao" method="post">
		<h1>Atualize os dados!</h1>
		<input type="hidden" name="id" value="<%= pessoa.getId() %>">
		<label>Nome:</label>
		<input type="text" name="nome" value="<%= pessoa.getNome()%>">
		<label>Data de Nascimento: </label>
		<input type="date" name="dataNascimento" value="<%= pessoa.getDataNascimento()%>">
		<label>Observação: </label>
		<input type="text" name="obs" value="<%= pessoa.getObs()%>">
		<div class="button-container">
		    <input type="submit" value="Atualizar">
		</div>
		
	</form>
	<a href="<%= request.getContextPath()%>/views/listaPessoas.jsp">Voltar</a>
		
</body>
</html>