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
import java.sql.ResultSet;
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
@WebServlet(name = "ajoute_fourni", urlPatterns = {"/ajoute_fourni"})
public class ajoute_fourni extends HttpServlet {

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
            out.println("<title>Servlet ajoute_fourni</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ajoute_fourni at " + request.getContextPath() + "</h1>");
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
        String value = request.getParameter("value");
        int id = Integer.parseInt(request.getParameter("id"));
        if(value.equals("delf")){
            PreparedStatement prst;
            Connection con;
            con = MyConnection.getMyConnection();
            try {
                prst = con.prepareStatement("delete from s_detailcom  where Matricule_f=?  ");
                prst.setInt(1,id );
                prst.executeUpdate();

                prst = con.prepareStatement("delete from fourprod  where Matricule_f=?  ");
                prst.setInt(1,id );
                prst.executeUpdate();
                
                prst = con.prepareStatement("delete from fourni  where Matricule_f=?  ");
                prst.setInt(1,id );
                prst.executeUpdate();
                request.getRequestDispatcher("Ajouter_fournisseur.jsp").forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(ajoute_user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(value.equals("upf")){
            PreparedStatement prst;
            Connection con;
            con = MyConnection.getMyConnection();
             try {
                prst = con.prepareStatement("select * from fourni where Matricule_f=?  ");
                prst.setInt(1, id);
                ResultSet rst = prst.executeQuery();
                while (rst.next()) {
                    
                    request.setAttribute("matf", rst.getString(1));
                    request.setAttribute("nomf", rst.getString(2));
                    request.setAttribute("prenomf", rst.getString(3));
                    request.setAttribute("telf", rst.getString(5));
                    request.setAttribute("emailf", rst.getString(4));                    
                    request.setAttribute("addrf", rst.getString(6));
                  
                    
                }
              
                
                request.getRequestDispatcher("updatefourni.jsp").forward(request, response);
                
            } catch (SQLException ex) {
                Logger.getLogger(ajoute_user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        PreparedStatement prst;
        Connection con;
        con = MyConnection.getMyConnection();
        PrintWriter p = response.getWriter();
        int matf = Integer.parseInt(request.getParameter("matfo"));
        String nomf = request.getParameter("nomfo");
        String prenomf = request.getParameter("prenomfo");
        String telf = request.getParameter("telfo");
        String emailf = request.getParameter("emailfo");
        String addrf = request.getParameter("addresfo");

        String[] prod = request.getParameterValues("produit");

        ArrayList<String> ajoutfourni = new ArrayList<String>();
        ajoutfourni.add("" + matf);
        ajoutfourni.add(nomf);
        ajoutfourni.add(prenomf);
        ajoutfourni.add(emailf);
        ajoutfourni.add(telf);
        ajoutfourni.add(addrf);
        HttpSession se = request.getSession();
        se.setAttribute("fourni", ajoutfourni);

        ArrayList<String> listprod = new ArrayList<String>();
        if (prod != null) {

            for (String s : prod) {
                try {
                    prst = con.prepareStatement("select * from produit where IDPROD=?  ");
                    prst.setString(1, s);
                    ResultSet rst = prst.executeQuery();
                    while (rst.next()) {

                        listprod.add(rst.getInt(1) + ":" + rst.getString(2) + ":" + rst.getString(3));
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ajoute_fourni.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.setAttribute("list", listprod);
            request.getRequestDispatcher("prixprod.jsp").forward(request, response);
        } else {

            p.println("<div style='position:absolute;top:70%;color:red;font-size:20px;margin-left:6%'>");
            p.println("veuillez chosir au moins un produit");
            p.println("</div>");
            request.getRequestDispatcher("Ajouter_fournisseur.jsp").include(request, response);
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
