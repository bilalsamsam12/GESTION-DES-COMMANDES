/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chagd
 */
@WebServlet(name = "ajouteproduit", urlPatterns = {"/ajouteproduit"})
public class ajouteproduit extends HttpServlet {

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
            out.println("<title>Servlet ajouteproduit</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ajouteproduit at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("id"));
        String value = request.getParameter("value");
        Connection con = MyConnection.getMyConnection();
        ArrayList<String>lp=new ArrayList<String>();

        try {
            if (value.equals("delp")) {

                PreparedStatement prst = con.prepareStatement("delete from produit where idprod=?");
                prst.setInt(1, id);
                prst.executeUpdate();

            } else if (value.equals("upp")) {
                PreparedStatement pst = con.prepareStatement("select * from produit where idprod=?");
                pst.setInt(1, id);
                ResultSet rst=pst.executeQuery();
                while(rst.next()){
                    int idp=rst.getInt(1);
                    String nomp=rst.getString(4);
                    String marquep=rst.getString(2);
                    String imagep=rst.getString(3);
                    
                    request.setAttribute("idp",idp );
                    request.setAttribute("nomp",nomp );
                    request.setAttribute("marquep",marquep );
                    request.setAttribute("imagep",imagep );
                }
                
                request.getRequestDispatcher("updateProduit.jsp").forward(request, response);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ajouteproduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("Ajouter_produits.jsp").forward(request, response);
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
        String nom = request.getParameter("nomp");
        String marque = request.getParameter("marquep");
        String img = request.getParameter("imagep");
        String nomp=nom.toUpperCase();
         String marquep=marque.toUpperCase();
        
        Connection con = MyConnection.getMyConnection();
        try {
            PreparedStatement prst = con.prepareStatement("insert into produit values(IDPR.nextval ,?,?,?)");
            prst.setString(3, nomp);
            prst.setString(1, marquep);
            prst.setString(2, img);
            prst.executeUpdate();
            

        } catch (SQLException ex) {
            Logger.getLogger(ajouteproduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("Ajouter_produits.jsp").forward(request, response);
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
