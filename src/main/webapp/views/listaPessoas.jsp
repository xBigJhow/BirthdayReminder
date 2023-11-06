<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="registraAniversario.dao.PessoaDAO" %>
<%@ page import="registraAniversario.model.Pessoa" %>
<%
PessoaDAO pessoaDAO= new PessoaDAO();
List<Pessoa> pessoas = pessoaDAO.listaPessoas();
%>
<!DOCTYPE html>
<html>
<head>
<title>Lista de Pessoas Cadastradas</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/CSSlistaPessoa.css">  
</head>
<body>
    <h1>Lista de Pessoas Cadastradas</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Data de Nascimento</th>
            <th>Observação</th>
            <th>Ação</th>
        </tr>
        <%
        for (Pessoa pessoa : pessoas) {
        %>
        <tr>
            <td><%= pessoa.getId() %></td>
            <td><%= pessoa.getNome() %></td>
            <td><%= pessoa.getDataNascimento() %></td>
            <td><%= pessoa.getObs() %></td>
            <td><a href="<%= request.getContextPath() %>/atualizar?id=<%= pessoa.getId() %>">Atualizar</a></td>
            <td><a href="<%= request.getContextPath() %>/deletar?id=<%= pessoa.getId() %>">Deletar</a></td>
        </tr>
        <%
        }
        %>
    </table>
    
    <a href="<%= request.getContextPath()%>/registro">Voltar</a>
</body>
</html>