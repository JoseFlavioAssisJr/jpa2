<%-- 
    Document   : novo-livro
    Created on : 02/06/2017, 21:55:02
    Author     : José Flávio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Livro</title>
    </head>
    <body>
        <center>
        <h1>Novo Livro</h1>
        <form method="post">
            <label>Título: <input type="text" name="titulo" value="" /></label>
            <label>Ano: <input type="text" name="ano" value="" /></label>
            <label>Autor: <input type="text" name="autor" value="" /></label>
            <br><br>
            <input type="submit" value="Cadastrar" />
        </form>
        </center>
    </body>
</html>
