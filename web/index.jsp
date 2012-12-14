<%-- 
    Document   : index
    Created on : 04-dic-2012, 0:35:42
    Author     : cd
--%>

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
        <h1>Conectarse</h1>
        <form class="well" method="get" action="Login">
            
            Usuario: <input type="text" name="usu" value=""/> <br />
            Password: <input type="password" name="pass" value=""/><br />

            <button type="submit" class="btn">Entrar</button>

        </form>
    </center>
        
    </body>
</html>
