<%-- 
    Document   : EditaCuestionario
    Created on : 20-nov-2012, 19:34:02
    Author     : al036215
--%>

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
                var evaluacion = parseInt(dato.evaluacion.value)
                var activo = parseInt(dato.activo.value)               
           
              
                
          
                if( vacio(dato.descripcion.value) == false ) {  
                    alert("!Campo descripcion vacio.¡")  
                    document.validar.descripcion.focus()
                    return false  ;                    
                }
                
                if( vacio(dato.evaluacion.value) == false ) {  
                    alert("!Campo evaluacion vacio.¡")  
                    document.validar.evaluacion.focus()
                    return false  ;                    
                }
                
                if( vacio(dato.fecha.value) == false ) {  
                    alert("!Campo fecha vacio.¡")  
                    document.validar.fecha.focus()
                    return false  ;                    
                }
                
                if( vacio(dato.activo.value) == false ) {  
                    alert("!Campo activo vacio.¡")  
                    document.validar.activo.focus()
                    return false  ;                    
                }   
                //valida el campo evaluacion si es entero
                
                if( isNaN( evaluacion)){
                    alert("El campo evaluacion debe ser numerico.")
                    document.validar.evaluacion.focus()
                    return false
            
                } 
                
                if( isNaN(activo)){
                    alert("El campo activo debe ser numerico.")
                    document.validar.activo.focus()
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
        <form action="ListaCuestionario" name="validar" method="get" class="well" onSubmit="return valida(this)">

            <%
                List<Cuestionario> lista = (LinkedList) request.getAttribute("arraylist");
                for (int i = 0; i < lista.size(); i++) {
            %>
            <pre>
            <input type="hidden" name="id" value=<%out.println(lista.get(i).getId());%> >           
            Descripcion: <input type="text" size="20" name="descripcion" value=<%out.println(lista.get(i).getDescripcion());%> ><br>
            Evaluacion:  <input type="text" size="6" name="evaluacion" value=<%out.println(lista.get(i).getEvaluacion());%>><br>
            Fecha:       <input type="text" name="fecha" class="span2" id="dp1" value=<%out.println(lista.get(i).getFecha());%>>                         
            Activo:      <input type="text" size="4" name="activo" value=<%out.println(lista.get(i).getActivo());%>><br>
                <%}%>
            </pre>
            
 <input type="hidden" name="opcion" value="guardaEditado">
            <button type="submit" class="btn">Editar</button>


        </form>
    </body>
</html>

