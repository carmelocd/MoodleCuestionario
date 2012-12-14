package Servlets;

import ClasesDao.PreguntaDao;
import Pojos.Pregunta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaPregunta extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaPregunta</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListaPregunta at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("opcion");
        PreguntaDao oPreguntaDao = new PreguntaDao();
        List<Pregunta> oListaPregunta = new ArrayList<>();
        Pregunta oPreguntapojo = new Pregunta();

        switch (operacion) {
            case "listar":
                String id = request.getParameter("id");
                int idl = Integer.parseInt(id);

                try {
                    oListaPregunta = oPreguntaDao.getPreguntas(idl);
                    request.setAttribute("arraylist", oListaPregunta);
                    getServletContext().getRequestDispatcher("/ListaPregunta.jsp").forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case "crear":
                request.getRequestDispatcher("/CreaPregunta.jsp").forward(request, response);

                break;

            case "guardapregunta":
                String descripcion = request.getParameter("descripcion");
                String IdPregunta = request.getParameter("idcuestionario");

                int inid = Integer.parseInt(IdPregunta);
                try {
                    oPreguntaDao.CreaPregunta(descripcion, inid);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    oListaPregunta = oPreguntaDao.getPreguntas(inid);
                    request.setAttribute("arraylist", oListaPregunta);
                    getServletContext().getRequestDispatcher("/ListaPregunta.jsp").forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "editar":
                String pregunta = request.getParameter("id");
                int ide = Integer.parseInt(pregunta);
                try {
                    oListaPregunta = oPreguntaDao.EditaPregunta(ide);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("arraylist", oListaPregunta);
                getServletContext().getRequestDispatcher("/EditaPregunta.jsp").forward(request, response);

                break;

            case "guardaEditado":

                String idpregunta = request.getParameter("id");
                String descripcionpre = request.getParameter("descripcion");
                String id_cuestionario = request.getParameter("id_cuestionario");

                int idpre = Integer.parseInt(idpregunta);
                int idcu = Integer.parseInt(id_cuestionario);
                try {
                    oPreguntaDao.EditadoPregunta(idpre, descripcionpre, idcu);
                } catch (Exception ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    oListaPregunta = oPreguntaDao.getPreguntas(idcu);
                    request.setAttribute("arraylist", oListaPregunta);
                    getServletContext().getRequestDispatcher("/ListaPregunta.jsp").forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case "borrar":

                String idb = request.getParameter("id");
                String idcue = request.getParameter("id_cuestionario");

                int id_cu = Integer.parseInt(idcue);
                int idbp = Integer.parseInt(idb);
                try {
                    oPreguntaDao.BorraPregunta(idbp);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    oListaPregunta = oPreguntaDao.getPreguntas(id_cu);
                    request.setAttribute("arraylist", oListaPregunta);
                    getServletContext().getRequestDispatcher("/ListaPregunta.jsp").forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaPregunta.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
