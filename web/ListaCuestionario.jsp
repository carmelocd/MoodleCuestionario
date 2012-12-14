<%-- 
    Document   : ListaCuestionario
    Created on : 10-nov-2012, 18:43:54
    Author     : cd
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Pojos.Cuestionario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel=stylesheet href="css/bootstrap.css" type="text/css" media=screen>


    </head>
    <body>
    <center>
        <form class="well" method="get" action="ListaCuestionario">
            <h1>Listado de cuestionario</h1>
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>Descripcion</td>
                    <td>Evaluacion</td>
                    <td>Fecha</td>
                    <td>Activo</td>
                    <td>      </td>
                    <td>      </td>                
                </tr>
                <%
                    List<Cuestionario> lista = (ArrayList) request.getAttribute("arraylist");

                    for (int i = 0; i < lista.size(); i++) {
                        out.println("<tr>");
                        out.println("<td>"+lista.get(i).getId()+"</td>");
                       // out.println("<td> <a href=\"ListaPregunta?id="+lista.get(i).getId()+"&operacion=listar\">" + lista.get(i).getDescripcion()+ "</a></td>");
                        out.println("<td><a href=\"ListaPregunta?id="+lista.get(i).getId()+"&opcion=listar\">"+ lista.get(i).getDescripcion()+"</a></td>");
                        out.println("<td>" +lista.get(i).getEvaluacion() + "</td>");
                        out.println("<td>" +lista.get(i).getFecha()+"</td>");
                        out.println("<td>" + lista.get(i).getActivo() +"</td>");
                        out.println("<td><a href=\"ListaCuestionario?id=" + lista.get(i).getId() + "&opcion=borrar\">Borrar</a></td>");
                        out.println("<td><a href=\"ListaCuestionario?id=" + lista.get(i).getId() + "&opcion=editar\">Editar</a></td>");
                        out.println("</tr>");
                    }
                %>
            </table><br>

            <input type="hidden" name="opcion" value="crear">
            <button type="submit" class="btn">Crear cuestionario</button>

        </form>

    </center>
</body>
</html>

