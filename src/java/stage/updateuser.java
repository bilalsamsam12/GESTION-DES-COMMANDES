/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chagd
 */
@WebServlet(name = "updateuser", urlPatterns = {"/updateuser"})
public class updateuser extends HttpServlet {

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
            out.println("<title>Servlet updateuser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateuser at " + request.getContextPath() + "</h1>");
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
        PrintWriter pr = response.getWriter();
        HttpSession se = request.getSession();
        response.setContentType("text/html");
        Connection con = MyConnection.getMyConnection();
        if (request.getParameter("programmeu").equals("--Choisir--")) {
            pr.println("<div style='position:absolute;top:70%;color:red;font-size:20px;margin-left:6%'>");
            String msg = "veillez choisir le programme";
            pr.println(msg);
            pr.println("</div>");

            request.getRequestDispatcher("updateuser.jsp").include(request, response);
        } else {
            try {
                if (request.getParameter("statusu").equals("User")) {
                    
                    System.out.println( request.getParameter("matu"));
                    System.out.println( request.getParameter("prenomu"));
                    System.out.println( request.getParameter("emailu"));
                    System.out.println( request.getParameter("telu"));
                    System.out.println( request.getParameter("programmeu"));
                    System.out.println( request.getParameter("statusu"));
                    PreparedStatement prst = con.prepareStatement("update Util set  nom=? , prenom=?,email=? ,tel=?,programe=?,status=?  where matricule=? ");
                    prst.setString(1, request.getParameter("nomu"));
                    prst.setString(2, request.getParameter("prenomu"));
                    prst.setString(3, request.getParameter("emailu"));
                    prst.setString(4, request.getParameter("telu"));
                    prst.setString(5, request.getParameter("programmeu"));
                    prst.setString(6, request.getParameter("statusu"));
                    prst.setString(7, request.getParameter("matu"));
                    prst.executeUpdate();
                    

                    request.getRequestDispatcher("Ajoute_users.jsp").include(request, response);
                } else if (request.getParameter("statusu").equals("Admin")) {
                    PreparedStatement prst = con.prepareStatement("update Util set  nom=? , prenom=?,email=? ,tel=?,programe=?,status=?  where matricule=? ");
                    prst.setString(1, request.getParameter("nomu"));
                    prst.setString(2, request.getParameter("prenomu"));
                    prst.setString(3, request.getParameter("emailu"));
                    prst.setString(4, request.getParameter("telu"));
                    prst.setString(5, request.getParameter("programmeu"));
                    prst.setString(6, request.getParameter("statusu"));
                    prst.setString(7, request.getParameter("matu"));
                    prst.executeUpdate();
                    request.getRequestDispatcher("Ajouter_admins.jsp").forward(request, response);
                }

            } catch (SQLException ex) {
                Logger.getLogger(updateuser.class.getName()).log(Level.SEVERE, null, ex);
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
