<%-- 
    Document   : CreaCuestionario
    Created on : 16-nov-2012, 19:19:23
    Author     : al036215
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel=stylesheet href="css/bootstrap.css" type="text/css" media=screen>
        <link href="css/datepicker.css" rel="stylesheet" type="text/css" media=screen>

        <link href="js/google-code-prettify/prettify.css" rel="stylesheet">

        <script type="text/javascript">
            
            function vacio(q) {  
                for ( i = 0; i < q.length; i++ ) {  
                    if ( q.charAt(i) != " ") {                        
                        return true  ;                    }  
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

        <%
        
        
      Calendar calendar = Calendar.getInstance();
      
      String fecha  = calendar.get(calendar.DAY_OF_MONTH)+"-" +calendar.get(calendar.MONTH)+"-"+calendar.get(calendar.YEAR);
             
        %>
        
        <form action="ListaCuestionario" name="validar" method="get" class="well" onSubmit="return valida(this)">
            <pre>
            Descripcion: <input type="text" size="20" name="descripcion"><br>
            Evaluacion:  <input type="text" size="6" name="evaluacion"><br>
            Fecha:       <input type="text" name="fecha" class="span2" value="<%=fecha %>" id="dp1" >                         
            Activo:      <input type="text" size="4" name="activo"><br>
            </pre>
            <input type="hidden" name="opcion" value="guarda">
            <button type="submit" class="btn">Crear</button>

        </form>


    </body>
</html>
