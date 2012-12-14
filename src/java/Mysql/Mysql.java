package Mysql;

import Pojos.Pregunta;
import Pojos.UsuarioPojo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mysql {

    private Connection con = null;
    private String url = "jdbc:mysql://localhost:3307/cuestionarios";
    private String user = "root";
    private String password = "administrador";
    private Statement statement;

    public void getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Imposible encontrar el driver:" + e.getMessage());
        }
        try {
            con = DriverManager.getConnection(url, user, password);

            System.out.println("conexion realizada");
        } catch (SQLException e) {
        }
    }

    public void Desconexion() throws Exception {
        try {
            if (con != null) {
                con.close();
            }

        } catch (SQLException e) {
            throw new Exception(
                    "MySQL.CerrarConexion: Error al cerrar la conexion"
                    + e.getMessage());
        }
    }

    public void InitTrans() {
        try {
            getCon().setAutoCommit(false);
        } catch (Exception ex) {
        }


    }

    public void CommitTrans() throws SQLException {

        getCon().commit();

    }

    public void RollbackTrans() throws SQLException {

        getCon().rollback();

    }

    public List<Integer> getSome(String tabla) throws SQLException {
        List<Integer> oListaCuestionario = new ArrayList<>();
        String sql = "SELECT id FROM " + tabla;
        statement = con.createStatement();
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {

                oListaCuestionario.add(rs.getInt("id"));
            }

        }
        return oListaCuestionario;

    }

    public void DeleteOne(int id, String tabla) throws Exception {

        Statement stm = null;
        try {
            String sql = "DELETE  FROM " + tabla + " WHERE id = " + Integer.toString(id);
            stm = con.createStatement();
            stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException ex) {
        }
    }

    public void insertOne(String descripcion, int evaluacion, String fecha, int activo) throws Exception {
        Statement stm = null;
        try {
            String sql = "INSERT INTO cuestionario  values (null,'" + descripcion + "'," + evaluacion + ",'" + fecha + "'," + activo + ")";
            stm = con.createStatement();
            stm.executeUpdate(sql);
            stm.close();
        } catch (Exception e) {
            throw new Exception(
                    "mysql.insertOne:Error al insertar el registro "
                    + e.getMessage());
        }
    }

    public void inserPrgunta(String descripcion, int idcuestionario) throws Exception {
        Statement stm = null;
        try {
            String sql = "INSERT INTO pregunta  values (null,'" + descripcion + "'," + idcuestionario + ")";
            stm = con.createStatement();
            stm.executeUpdate(sql);
            stm.close();
        } catch (Exception e) {
            throw new Exception(
                    "mysql.insertOne:Error al insertar el registro "
                    + e.getMessage());
        }
    }

    public void updatePregunta(String tabla, String descripcion, int id_cuestionario, int id) throws Exception {

        Statement st = null;
        //update cuestionario set descripcion = 'prueba_final',evaluacion=10,fecha='2012-11-25',activo= 0 where id = 34;
        try {
            // mysql.Conexion();
            st = con.createStatement();
            String sql = "update " + tabla + " set descripcion = '" + descripcion + "', id_cuestionario =" + id_cuestionario + " where id = " + Integer.toString(id);
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            throw new Exception(
                    "mysql.updateOne: Error al modificar el registro: "
                    + e.getMessage());
        }
    }
    public void updateOne(String tabla, String descripcion, int eval, String fecha, int activo, int id) throws Exception {

        Statement st = null;
        //update cuestionario set descripcion = 'prueba_final',evaluacion=10,fecha='2012-11-25',activo= 0 where id = 34;
        try {
            // mysql.Conexion();
            st = con.createStatement();
            String sql = "update " + tabla + " set descripcion = '" + descripcion + "', evaluacion =" + eval + ", fecha ='" + fecha + "',activo = " + activo + " where id = " + Integer.toString(id);
            st.executeUpdate(sql);
            st.close();
        } catch (Exception e) {
            throw new Exception(
                    "mysql.updateOne: Error al modificar el registro: "
                    + e.getMessage());
        }
    }

    public String GetOne(String tabla, int id, String campo) throws SQLException, Exception {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT " + campo + " FROM " + tabla + " where id = " + Integer.toString(id);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            rs.first();
        } catch (Exception ex) {
            throw new Exception(
                    "mysql.getOne: No se ha podido realizar la consulta: "
                    + ex.getMessage());
        }
        return rs.getString(campo);

    }

    public List<Pregunta> GetOnePregunta(int id) throws SQLException, Exception {
        Statement stmt = null;
        ResultSet rs = null;
        List<Pregunta> campos = new ArrayList<>();

        //SELECT * FROM pregunta WHERE id_cuestionario = 1
        try {
            String sql = "SELECT * FROM pregunta where id_cuestionario = " + Integer.toString(id);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pregunta oPregunta = new Pregunta();
                oPregunta.setId(rs.getInt("id"));
                oPregunta.setDescripcion(rs.getString("descripcion"));
                oPregunta.setId_cuestionario(rs.getInt("id_cuestionario"));

                campos.add(oPregunta);
            }


        } catch (Exception ex) {
            throw new Exception(
                    "mysql.getOne: No se ha podido realizar la consulta: "
                    + ex.getMessage());
        }
        return campos;

    }
    
      public List<Pregunta> GetOneEdita(int id) throws SQLException, Exception {
        Statement stmt = null;
        ResultSet rs = null;
        List<Pregunta> campos = new ArrayList<>();

        //SELECT * FROM pregunta WHERE id = 1
        try {
            String sql = "SELECT * FROM pregunta where id = " + Integer.toString(id);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Pregunta oPregunta = new Pregunta();
                oPregunta.setId(rs.getInt("id"));
                oPregunta.setDescripcion(rs.getString("descripcion"));
                oPregunta.setId_cuestionario(rs.getInt("id_cuestionario"));

                campos.add(oPregunta);
            }


        } catch (Exception ex) {
            throw new Exception(
                    "mysql.getOne: No se ha podido realizar la consulta: "
                    + ex.getMessage());
        }
        return campos;

    }

    public String GetSelet(int id, String tabla) {
        Statement stmt = null;
        ResultSet rs = null;
        Mysql mysql = new Mysql();
        try {
            mysql.getConexion();
            String sql = "select * from " + tabla + " where id = " + id;
            stmt = mysql.getCon().createStatement();
            rs = stmt.executeQuery(sql);
            rs.first();
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String GetLogin(String campo, String tabla, String login, String pas) throws SQLException {

        Statement stmt = null;

        ResultSet rs = null;
        Mysql mysql = new Mysql();

        String sql = "select " + campo + " from " + tabla + " where login ='" + login + "' and password ='" + pas + "' ";
        try {
            stmt = mysql.getCon().createStatement();
            rs = stmt.executeQuery(sql);
            rs.first();

        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs.getString(campo);


    }

    public UsuarioPojo getValida(UsuarioPojo user) {
        Statement stm = null;
        ResultSet rs = null;
        //SELECT * FROM usuario WHERE login = 'root' and password = '123';
        String sql = "SELECT * FROM usuario WHERE login ='" + user.getLogin() + "' and password ='" + user.getPassword() + "' ";
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                user.setApe1(rs.getString("ape1"));
                user.setApe2(rs.getString("ape2"));
                user.setEmail(rs.getString("email"));
                user.setId(rs.getInt("id"));
                user.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
                user.setLogin(rs.getString("login"));
                user.setNombre(rs.getString("nombre"));
                user.setPassword(rs.getString("password"));
                user.setTelefono(rs.getString("telefono"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }
}
