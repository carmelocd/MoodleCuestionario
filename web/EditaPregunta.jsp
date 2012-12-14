<%-- 
    Document   : EditaCuestionario
    Created on : 20-nov-2012, 19:34:02
    Author     : al036215
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Pojos.Pregunta"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Pojos.Cuestionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel=stylesheet href="css/bootstrap.css" type="text/css" media=screen>

        <script type="text/javascript">
            
            function vacio(q) {  
                for ( i = 0; i < q.length; i++ ) {  
                    if ( q.charAt(i) != " ") {
                        
                        return true  ;
                    }  
                }  
                return false  ;
            }    
            
            function valida(dato) {  
                var id_cuestionario = parseInt(dato.id_cuestionario.value)
                        
     
                if( vacio(dato.descripcion.value) == false ) {  
                    alert("!Campo descripcion vacio.¡")  
                    document.validar.descripcion.focus()
                    return false  ;                    
                }
                
                if( vacio(dato.id_cuestionario.value) == false ) {  
                    alert("!Campo id_cuestionario vacio.¡")  
                    document.validar.id_cuestionario.focus()
                    return false  ;                    
                }          
                //valida el campo evaluacion si es entero                
                if( isNaN( id_cuestionario)){
                    alert("El campo id_cuestionario debe ser numerico.")
                    document.validar.id_cuestionario.focus()
                    return false
            
                } 
      
                else {  
                    alert("OK, los valores introducidos son correctos.")                 
                    return true;
                }  
             
            }
     
        </script>
    </head>
    <body>
        <form action="ListaPregunta" name="validar" method="get" class="well" onSubmit="return valida(this)">
            <%
                List<Pregunta> lista = (ArrayList) request.getAttribute("arraylist");
                for (int i = 0; i < lista.size(); i++) {
            %>
            <pre>
            <input type="hidden" name="id" value=<%out.println(lista.get(i).getId());%> >           
            Descripcion: <input type="text" size="255" name="descripcion" value=<%out.println(lista.get(i).getDescripcion());%> ><br>
            Evaluacion:  <input type="text" size="6" name="id_cuestionario" value=<%out.println(lista.get(i).getId_cuestionario());%>><br>
                                  
                <%}%>
            </pre>
            <input type="hidden" name="opcion" value="guardaEditado">
            <button type="submit" class="btn">Editar</button>
        </form>
    </body>
</html>

