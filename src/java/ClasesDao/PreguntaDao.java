package ClasesDao;

import Mysql.Mysql;
import Pojos.Pregunta;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreguntaDao {

    public List<Pregunta> getPreguntas(int id) throws SQLException, Exception {
        List<Pregunta> oListaPreguntas = new ArrayList<>();
        Mysql mysql = new Mysql();
        mysql.getConexion();
        oListaPreguntas = mysql.GetOnePregunta(id);
        mysql.Desconexion();

        return oListaPreguntas;

    }

    public void CreaPregunta(String descripcion, int idcuestionario) throws Exception {
        Mysql mysql = new Mysql();
        mysql.getConexion();
        mysql.inserPrgunta(descripcion, idcuestionario);
        mysql.Desconexion();

    }

    public List<Pregunta> EditaPregunta(int id) throws SQLException, Exception {
        List<Pregunta> oListaPregunta = new ArrayList<>();       
        oListaPregunta = this.getEdita(id);

        return oListaPregunta;

    }

    public List<Pregunta> getEdita(int id) throws SQLException, Exception {
        List<Pregunta> oListaPreguntas = new ArrayList<>();
        Mysql mysql = new Mysql();
        mysql.getConexion();
        oListaPreguntas = mysql.GetOneEdita(id);
        mysql.Desconexion();

        return oListaPreguntas;

    }

    public void EditadoPregunta(int id, String descripcion, int id_cuestionario) throws Exception {
        Mysql mysql = new Mysql();
        mysql.getConexion();
        mysql.updatePregunta("pregunta", descripcion, id_cuestionario, id);
        mysql.Desconexion();

    }

    public void BorraPregunta(int id) throws SQLException, Exception {
        Mysql mysql = new Mysql();
        mysql.getConexion();
        mysql.DeleteOne(id, "pregunta");
        mysql.Desconexion();
    }

}
