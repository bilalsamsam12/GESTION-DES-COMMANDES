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
@WebServlet(name = "test_ajax", urlPatterns = {"/test_ajax"})
public class test_ajax extends HttpServlet {

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
            out.println("<title>Servlet test_ajax</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet test_ajax at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html");
        HttpSession s=request.getSession();
        String prod=request.getParameter("id");
        ArrayList<String> listcmd = (ArrayList<String>) s.getAttribute("panel");
        for(int i=0;i<listcmd.size();i++){
            if(listcmd.get(i).equals(prod)){
                listcmd.remove(i);
            }
        }
        request.getRequestDispatcher("DemanderProd.jsp").forward(request, response);
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
        PrintWriter out=response.getWriter();
        String p=request.getParameter("text");
        String n=request.getParameter("marq");
        
        String nom=p.toUpperCase();
        String mar=n.toUpperCase();
       
    out.println("    <table>");
                
                    int i = 0, j = 1;
                    Connection con = MyConnection.getMyConnection();
                    PreparedStatement prst;
        try {
            prst = con.prepareStatement("select * from fourprod f inner join produit p on(p.idprod=f.idprod) where nom_p like ? and marque like ?");
            prst.setString(1,"%"+ nom+"%");
            prst.setString(2,"%"+ mar+"%");
        
                    ResultSet rst = prst.executeQuery();
                    out.println("<tr>");
                    while (rst.next()) {

                        if (i % 3 == 0) {
                            out.println("</tr><tr>");
                        }

               
              
              out.println("<td id='x"+j+"'>"   

                    +"<form action='Commander' method='post'>"
                       +"<div id='divimg' ><img src='imgproduit/"+rst.getString("image") +"' id='imagepr' /></div>"
                    +"<center><strong>"+rst.getString("nom_p") +"    " + rst.getString("marque")+"</strong> </center>"
                    +"<center><mark style='background-color:  #33333333'>"+rst.getFloat("prix")+" DH </mark></center>"
                    +"<center> <label>Quantite: </label>"
                      + " <input type='number' pattern='^[0-9]+$'  required name='qte' style=\"width: 90px; margin-left: 30px;\n" +
"                margin-top: 10px;\n" +
"                border-radius: 5px;\n" +
"                border: solid #333 1px;\n" +
"                height: 30px;\n" +
"                padding-left: 15px;\n" +
"\"/>"
                       + "<input type='hidden' name='idpro' value="+rst.getInt("idprod")+":"+rst.getInt("matricule_f")+":"+rst.getFloat("prix")+":"+rst.getString("nom_p")+"  "+rst.getString("marque")+" />"
                        +"<input type='submit' value='add' class='addTcad' style=\"background-color: #333;\n" +
"                                   width: 70px;\n" +
"                                   height: 30px;\n" +
"                                   border: solid #333 1px;\n" +
"                                   border-radius: 5px;\n" +
"                                   color: white;\n" +
"                                   margin-left: 30px\" /> </center>"


              +"  </form>"
                   +" </td>");
                
                        j++;
                        i++;
                    }
            
                        
          out.println("  </table>");
        } catch (SQLException ex) {
            Logger.getLogger(test_ajax.class.getName()).log(Level.SEVERE, null, ex);
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
