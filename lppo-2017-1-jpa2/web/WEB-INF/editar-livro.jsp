<%-- 
    Document   : editar-livro
    Created on : 05/06/2017, 21:13:10
    Author     : José Flávio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Livro</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf" %>
        <form method="post">
    <center>
        <h1>Editar Livro</h1>
        
        <th>ID: <input type="hidden" name="id" value="${livro.id}" /></th>
        <th>Título:<input type="text" name="titulo" value="" />${livro.titulo}</th>
        <th>Ano: <input type="text" name="ano" value="" />${livro.ano}</th>
        <th>Autor: <input type="text" name="autor" value="" />${livro.autor}</th>
            <br><br>
        <input type="submit" value="Editar" />
        <input type="reset" value="Cancelar" />
    </center>
        </form>
    </body>
</html>

