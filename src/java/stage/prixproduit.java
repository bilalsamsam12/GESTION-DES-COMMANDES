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
import javax.servlet.http.HttpSession;

/**
 *
 * @author chagd
 */
@WebServlet(name = "prixproduit", urlPatterns = {"/prixproduit"})
public class prixproduit extends HttpServlet {

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
            out.println("<title>Servlet prixproduit</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet prixproduit at " + request.getContextPath() + "</h1>");
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
        Connection con = MyConnection.getMyConnection();
        PrintWriter p = response.getWriter();
         HttpSession session = request.getSession();
        int matf = Integer.parseInt(request.getParameter("matf"));
        String nomf = request.getParameter("nomf");
        String prenomf = request.getParameter("prenomf");
        String telf = request.getParameter("telf");
        String emailf = request.getParameter("emailf");
        String addrf = request.getParameter("addrf");
        ArrayList<String> ajoutfourni = new ArrayList<String>();
        ajoutfourni.add("" + matf);
        ajoutfourni.add(nomf);
        ajoutfourni.add(prenomf);
        ajoutfourni.add(emailf);
        ajoutfourni.add(telf);
        ajoutfourni.add(addrf);
        session.setAttribute("fourniup", ajoutfourni);

        String[] prod = request.getParameterValues("produit");
        ArrayList<String> listprod = new ArrayList<String>();
        if (prod != null) {
            PreparedStatement prst;
            for (String s : prod) {
                try {
                    prst = con.prepareStatement("select * from produit where IDPROD=?  ");
                    prst.setString(1, s);
                    ResultSet rst = prst.executeQuery();
                    while (rst.next()) {

                        listprod.add(rst.getInt(1) + ":" + rst.getString(4) + ":" + rst.getString(2));
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ajoute_fourni.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.setAttribute("list", listprod);
            request.getRequestDispatcher("modifprix.jsp").forward(request, response);
        } else {

            p.println("<div style='position:absolute;top:70%;color:red;font-size:20px;margin-left:6%'>");
            p.println("veuillez chosir au moins un produit");
           p.println("</div>");
            request.getRequestDispatcher("updatefourni.jsp").include(request, response);
        }
/*
        try {
            PreparedStatement pst = con.prepareStatement("delete from fourprod where matricule_f=?");
            pst.setInt(1, matf);
            pst.executeUpdate();
            PreparedStatement prst = con.prepareStatement("update fourni set nom=?,prenom=?,email=?,tel=?,addresse=? where matricule_f=? ");
            prst.setString(1, nomf);
            prst.setString(2, prenomf);
            prst.setString(3, emailf);
            prst.setString(4, telf);
            prst.setString(5, addrf);
            prst.setInt(6, matf);
            prst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(prixproduit.class.getName()).log(Level.SEVERE, null, ex);
        }*/

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

        ArrayList<String> list = (ArrayList<String>) session.getAttribute("fourni");

        String matf = list.get(0);
        String nomf = list.get(1);
        String prenomf = list.get(2);
        String emailf = list.get(3);
        String telf = list.get(4);
        String addrf = list.get(5);
        try {
            PreparedStatement pst = con.prepareStatement("insert into fourni values(?,?,?,?,?,?)");
            pst.setString(1, matf);
            pst.setString(2, nomf);
            pst.setString(3, prenomf);            
            pst.setString(4, emailf);
            pst.setString(5, telf);
            pst.setString(6, addrf);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(prixproduit.class.getName()).log(Level.SEVERE, null, ex);

        }

        for (int i = 0; i < a.length; i++) {
            String[] id = a[i].split(":");
            try {
                PreparedStatement prst = con.prepareStatement("insert into Fourprod values(?,?,?)");

                prst.setInt(1, Integer.parseInt(id[0]));
                prst.setInt(2, Integer.parseInt(matf));
                prst.setFloat(3, Float.parseFloat(id[3]));
                prst.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(prixproduit.class.getName()).log(Level.SEVERE, null, ex);
            }

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
