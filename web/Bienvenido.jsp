<%-- 
    Document   : Bienvenido
    Created on : 04-dic-2012, 1:01:36
    Author     : cd
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="Pojos.UsuarioPojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();

    UsuarioPojo oUsuario = (UsuarioPojo) sesion.getAttribute("usuario");

    if (oUsuario == null) {

        response.sendRedirect("index.jsp");
    } else {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet href="css/bootstrap.css" type="text/css" media=screen>
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Bienvenido</h1>
        <p>Ver Lista de cuestionario <%oUsuario.getNombre(); %></p>
        <form action="ListaCuestionario" method="get">
            <input type="hidden" name="opcion" value="listar">
           <button type="submit" class="btn">Lista cuestionario</button>


        </form>
    </center>
    </body>
</html>
<% }%> 