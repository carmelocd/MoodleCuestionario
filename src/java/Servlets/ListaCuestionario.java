/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import ClasesDao.CuestionarioDao;
import Pojos.Cuestionario;
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

/**
 *
 * @author cd
 */
public class ListaCuestionario extends HttpServlet {

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
            out.println("<title>Servlet ListaCuestionario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListaCuestionario at " + request.getContextPath() + "</h1>");
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
        CuestionarioDao oCuestionarioDao = new CuestionarioDao();
        List<Cuestionario> oListaCuestionario = new ArrayList<>();

        switch (operacion) {
            case "listar":
                try {
                    oListaCuestionario = oCuestionarioDao.getCuestionarios();
                    request.setAttribute("arraylist", oListaCuestionario);
                    getServletContext().getRequestDispatcher("/ListaCuestionario.jsp").forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "crear":
                request.getRequestDispatcher("/CreaCuestionario.jsp").forward(request, response);

                break;

            case "guarda":

                String descripcion = request.getParameter("descripcion");
                String evaluacion = request.getParameter("evaluacion");
                String fecha = request.getParameter("fecha");
                String activar = request.getParameter("activo");

                int eval = Integer.parseInt(evaluacion);
                int activo = Integer.parseInt(activar);

                try {
                    oCuestionarioDao.CreaCuestionario(descripcion, eval, fecha, activo);
                } catch (Exception ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                }

                // request.getRequestDispatcher("/ListaCuestionario").forward(request, response);
                try {

                    oListaCuestionario = oCuestionarioDao.getCuestionarios();

                    request.setAttribute("arraylist", oListaCuestionario);

                    getServletContext().getRequestDispatcher("/ListaCuestionario.jsp").forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;


            case "borrar":

                String idcuestionario = request.getParameter("id");
                int idb = Integer.parseInt(idcuestionario);
                try {
                    oCuestionarioDao.BorraCuestionario(idb);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    oListaCuestionario = oCuestionarioDao.getCuestionarios();
                    request.setAttribute("arraylist", oListaCuestionario);
                    getServletContext().getRequestDispatcher("/ListaCuestionario.jsp").forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "editar":
                String cuestionario = request.getParameter("id");
                int ide = Integer.parseInt(cuestionario);
                try {
                    oListaCuestionario = oCuestionarioDao.EditaCuestionario(ide);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("arraylist", oListaCuestionario);
                getServletContext().getRequestDispatcher("/EditaCuestionario.jsp").forward(request, response);
                break;

            case "guardaEditado":

                String id = request.getParameter("id");
                String descripcione = request.getParameter("descripcion");
                String evaluacione = request.getParameter("evaluacion");
                String fechae = request.getParameter("fecha");
                String activoe = request.getParameter("activo");


                int evalint = Integer.parseInt(evaluacione);
                int actint = Integer.parseInt(activoe);
                int idf = Integer.parseInt(id);
                try {

                    oCuestionarioDao.EditadoCuestionario(idf, descripcione, evalint, fechae, actint);
                } catch (Exception ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                }


                try {

                    oListaCuestionario = oCuestionarioDao.getCuestionarios();
                    request.setAttribute("arraylist", oListaCuestionario);

                    getServletContext().getRequestDispatcher("/ListaCuestionario.jsp").forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListaCuestionario.class.getName()).log(Level.SEVERE, null, ex);
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
