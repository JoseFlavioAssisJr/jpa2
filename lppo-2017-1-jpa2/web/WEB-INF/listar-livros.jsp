<%-- 
    Document   : listar-livros
    Created on : 02/06/2017, 22:10:36
    Author     : José Flávio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Livros</title>
    </head>
    <body>
    <center>
        <h1>Listar Livros</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Ano</th>
                <th>Autor</th>
            </tr>
            <c:forEach var="livro" items="${livros}">
            <tr>
                <td>${livro.id}</td>
                <td>${livro.titulo}</td>
                <td>${livro.ano}</td>
                <td>${livro.autor}</td>
            </tr>
            </c:forEach>
        </table>
    </center>
    </body>
</html>
