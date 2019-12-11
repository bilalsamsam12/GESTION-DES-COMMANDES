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
import java.util.ArrayList;
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
@WebServlet(name = "modiffour", urlPatterns = {"/modiffour"})
public class modiffour extends HttpServlet {

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
            out.println("<title>Servlet modiffour</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet modiffour at " + request.getContextPath() + "</h1>");
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
        Connection con = MyConnection.getMyConnection();
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();
        String[] a = (String[]) session.getAttribute("pri");
        for (int i = 0; i < a.length; i++) {
            String[] id = a[i].split(":");
            String id1 = request.getParameter(id[0]);
            a[i] += ":" + id1;
        }

        ArrayList<String> lf = (ArrayList<String>) session.getAttribute("fourniup");
        int matf = Integer.parseInt(lf.get(0));
        String nomf = lf.get(1);
        String prenomf = lf.get(2);
        String emailf = lf.get(3);
        String telf = lf.get(4);
        String addrf = lf.get(5);
        PreparedStatement prst;

        try {
            PreparedStatement psta = con.prepareStatement("delete from fourprod where matricule_f=?");
            psta.setInt(1, matf);
            psta.executeUpdate();

            prst = con.prepareStatement("update fourni set nom=?,prenom=?,email=?,tel=?,addresse=? where matricule_f=? ");
            prst.setString(1, nomf);
            prst.setString(2, prenomf);
            prst.setString(3, emailf);
            prst.setString(4, telf);
            prst.setString(5, addrf);
            prst.setInt(6, matf);
            prst.executeUpdate();

            for (int i = 0; i < a.length; i++) {
                String[] id = a[i].split(":");

                PreparedStatement pst = con.prepareStatement("insert into fourprod values(?,?,?)");

                pst.setInt(1, Integer.parseInt(id[0]));
                pst.setInt(2, matf);
                pst.setFloat(3, Float.parseFloat(id[3]));
                pst.executeUpdate();

            }
        } catch (SQLException ex) {
            Logger.getLogger(modiffour.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("Ajouter_fournisseur.jsp").forward(request, response);
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
