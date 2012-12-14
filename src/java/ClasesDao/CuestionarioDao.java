package ClasesDao;

import Mysql.Mysql;

import Pojos.Cuestionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CuestionarioDao {

    public List<Cuestionario> getCuestionarios() throws SQLException, Exception {

        List<Integer> oListaId = new ArrayList<>();
        List<Cuestionario> oListaCuestionario = new ArrayList<>();
        Mysql mysql = new Mysql();
        mysql.getConexion();
        oListaId = mysql.getSome("cuestionario");
        mysql.Desconexion();
        Iterator itr = oListaId.iterator();
        while (itr.hasNext()) {
            int id = (int) itr.next();
            Cuestionario oCuestionario = new Cuestionario();
            oCuestionario.setId(id);
            oCuestionario = this.getCuestionario(oCuestionario);
            oListaCuestionario.add(oCuestionario);
           
        }
        return oListaCuestionario;
    }

    public Cuestionario getCuestionario(Cuestionario c) throws SQLException, Exception {
        Mysql mysql = new Mysql();
        mysql.getConexion();
        c.setDescripcion(mysql.GetOne("cuestionario", c.getId(), "descripcion"));
        c.setActivo(Integer.parseInt(mysql.GetOne("cuestionario", c.getId(), "activo")));
        c.setEvaluacion(Integer.parseInt(mysql.GetOne("cuestionario", c.getId(), "evaluacion")));
        c.setFecha(mysql.GetOne("cuestionario", c.getId(), "fecha"));
        c.setId(Integer.parseInt(mysql.GetOne("cuestionario", c.getId(), "id")));
        mysql.Desconexion();
        return c;
    }

    public void BorraCuestionario(int id) throws SQLException, Exception {
        Mysql mysql = new Mysql();
        mysql.getConexion();
        mysql.DeleteOne(id, "cuestionario");
        mysql.Desconexion();
    }
    

   public void CreaCuestionario(String descripcion, int evaluacion, String fecha, int activo) throws Exception {
        Mysql mysql = new Mysql();
        mysql.getConexion();
        mysql.insertOne(descripcion, evaluacion, fecha, activo);
        mysql.Desconexion();

    }    
    

    public List<Cuestionario> EditaCuestionario(int id) throws SQLException, Exception {
        List<Cuestionario> oListaCuestionario = new LinkedList<>();
        Cuestionario oCuestionario = new Cuestionario();
        oCuestionario.setId(id);
        oCuestionario = this.getCuestionario(oCuestionario);
        oListaCuestionario.add(oCuestionario);
        return oListaCuestionario;


    }

    public void EditadoCuestionario(int id, String descripcion, int evaluacion, String fecha, int activo) throws Exception {
        Mysql mysql = new Mysql();
        mysql.getConexion();       
        mysql.updateOne("cuestionario", descripcion, evaluacion, fecha, activo, id);
        mysql.Desconexion();

    }
}
