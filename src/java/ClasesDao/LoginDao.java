package ClasesDao;

import Mysql.Mysql;
import Pojos.UsuarioPojo;
import java.sql.*;

public class LoginDao {

    public UsuarioPojo getDatos(UsuarioPojo usuario) throws SQLException, Exception {

        Mysql mysql = new Mysql();
        UsuarioPojo oUsuario = new UsuarioPojo();
        mysql.getConexion();
        oUsuario = mysql.getValida(usuario);
        mysql.Desconexion();
       
        return oUsuario;


    }
}
