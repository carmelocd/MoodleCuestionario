<%-- 
    Document   : ListaPregunta
    Created on : 04-dic-2012, 20:12:20
    Author     : al036215
--%>

<%@page import="Pojos.Pregunta"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=stylesheet href="css/bootstrap.css" type="text/css" media=screen>
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <form class="well" method="get" action="ListaPregunta">
            <h1>Listado de preguntas</h1>
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Descripcion</td>
                    <td>Id_cuestionario</td>                   
                    <td>      </td>
                    <td>      </td>                
                </tr>
                <%
                    List<Pregunta> lista = (ArrayList) request.getAttribute("arraylist");
                    for (int i = 0; i < lista.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>" + lista.get(i).getId() + "</td>");
                        // out.println("<td> <a href=\"ListaPregunta?id="+lista.get(i).getId()+"&operacion=listar\">" + lista.get(i).getDescripcion()+ "</a></td>");
                        out.println("<td>" + lista.get(i).getDescripcion() + "</td>");
                        out.println("<td>" + lista.get(i).getId_cuestionario() + "</td>");
                        out.println("<td><a href=\"ListaPregunta?id_cuestionario=" + lista.get(i).getId_cuestionario() + "&id=" + lista.get(i).getId() + "&opcion=borrar\">Borrar</a></td>");
                        out.println("<td><a href=\"ListaPregunta?id=" + lista.get(i).getId() + "&opcion=editar\">Editar</a></td>");
                        out.println("</tr>");
                    }
                %>          

            </table><br>
            <input type="hidden" name="opcion" value="crear">            
            <button type="submit" class="btn">Crear pregunta</button>
        </form>
        <form action="ListaCuestionario" method="get">
            <input type="hidden" name="opcion" value="listar">
            <button type="submit" value="Lista cuestionario" class="btn">Lista cuestionario</button>


        </form>
    </center>
</body>
</html>
