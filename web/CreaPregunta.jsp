<%-- 
    Document   : CreaCuestionario
    Created on : 16-nov-2012, 19:19:23
    Author     : al036215
--%>

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
                var idcuestionario = parseInt(dato.idcuestionario.value)
                            
           
                if( vacio(dato.descripcion.value) == false ) {  
                    alert("!Campo descripcion vacio.¡")  
                    document.validar.descripcion.focus()
                    return false  ;                    
                }
                
                if( vacio(dato.idcuestionario.value) == false ) {  
                    alert("!Campo idcuestionario vacio.¡")  
                    document.validar.idcuestionario.focus()
                    return false  ;                    
                }
           
                //valida el campo evaluacion si es entero
                
                if( isNaN( idcuestionario)){
                    alert("El campo evaluacion debe ser numerico.")
                    document.validar.idcuestionario.focus()
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
            <pre>
            Descripcion: <input type="text" size="45" width="45" name="descripcion"><br>
            Id_cuestionario:  <input type="text" size="6" name="idcuestionario"><br>            
            </pre>
            <input type="hidden" name="opcion" value="guardapregunta">
            <button type="submit" class="btn">Crear</button>

        </form>


    </body>
</html>

