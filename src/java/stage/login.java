package stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
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
        HttpSession s = request.getSession();
        int mat = Integer.parseInt(request.getParameter("matr"));
        String req = "select * from Util where Matricule=?";
        Connection con = MyConnection.getMyConnection();
        PreparedStatement prst;
        ResultSet rst;
        try {
            prst = con.prepareStatement(req);
            prst.setInt(1, mat);
            rst = prst.executeQuery();
            if (rst.next()) {
                s.setAttribute("mat", rst.getInt(1));
                s.setAttribute("nom", rst.getString(2));
                s.setAttribute("prenom", rst.getString(3));
                s.setAttribute("email", rst.getString(4));
                s.setAttribute("tel", rst.getString(5));
                s.setAttribute("programme", rst.getString(6));
                s.setAttribute("status", rst.getString(7));
                if (rst.getString("Status").equals("Admin")) {
                   response.sendRedirect("page_admin.jsp");
                } else if (rst.getString("Status").equals("User")) {
                    response.sendRedirect("DemanderProd.jsp");
                }else if (rst.getString("Status").equals("Chef")) {
                   response.sendRedirect("Page_Chef.jsp");
                }
            } else {
                PrintWriter pr = response.getWriter();
                pr.println("Matricule incorrect");
                request.getRequestDispatcher("Login.jsp").include(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
