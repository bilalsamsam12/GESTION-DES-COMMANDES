/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chagd
 */
@WebServlet(name = "Ajouter_admin", urlPatterns = {"/Ajouter_admin"})
public class Ajouter_admin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ajouter_admin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ajouter_admin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pr = response.getWriter();
        int mat = Integer.parseInt(request.getParameter("matad"));
        String nom = request.getParameter("nomad");
        String prenom = request.getParameter("prenomad");
        String email = request.getParameter("emailad");
        String tel = request.getParameter("telad");
        String programme = request.getParameter("programmead");
        String status = "Admin";
        String msg;
        if (programme.equals("--Choisir--")) {
            msg = "veillez sélectioner le programme";
            request.setAttribute("msg", msg);

            request.getRequestDispatcher("Ajouter_admins.jsp?error=1").include(request, response);
        } else {

            Connection con = MyConnection.getMyConnection();

            try {
                PreparedStatement prst = con.prepareStatement("insert into Util values (?,?,?,?,?,?,?)");
                prst.setInt(1, mat);
                prst.setString(2, nom);
                prst.setString(3, prenom);
                prst.setString(4, email);
                prst.setString(5, tel);
                prst.setString(6, programme);
                prst.setString(7, status);
                prst.executeUpdate();
//                pr.println("<div style='position:absolute;top:70%;color:green;font-size:20px;margin-left:6%'>");
//                pr.println("admin ajouter avec succes");
//                pr.println("</div>");
                request.getRequestDispatcher("Ajouter_admins.jsp").include(request, response);

            } catch (SQLException ex) {
                pr.println("<div style='position:absolute;top:70%;color:red;font-size:20px;margin-left:6%'>");
                pr.println("admin non ajouter , verifier <br>");
                pr.println("Matricule déja existe");
                pr.println("</div>");
                request.getRequestDispatcher("Ajouter_admins.jsp").include(request, response);
            }
        }

        
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
