   package stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/ajoute_user"})
public class ajoute_user extends HttpServlet {

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
            out.println("<title>Servlet ajoute_user</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ajoute_user at " + request.getContextPath() + "</h1>");
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
        HttpSession s = request.getSession();
        String value = request.getParameter("value");

        if (value.equals("del")) {
            PreparedStatement prst;
            Connection con;
            con = MyConnection.getMyConnection();
            try {

                prst = con.prepareStatement("delete from Util where Matricule=?  ");
                prst.setInt(1, id);
                prst.executeUpdate();
                request.getRequestDispatcher("Ajoute_users.jsp").forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(ajoute_user.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (value.equals("up") ||value.equals("upad") ) {
            PreparedStatement prst;
            Connection con;
            con = MyConnection.getMyConnection();

            try {
                prst = con.prepareStatement("select * from Util where Matricule=?  ");
                prst.setInt(1, id);
                ResultSet rst = prst.executeQuery();
                while (rst.next()) {
                    HttpSession se=request.getSession();
                    request.setAttribute("matup", rst.getString(1));
                    request.setAttribute("nomup", rst.getString(2));
                    request.setAttribute("prenomup", rst.getString(3));
                    request.setAttribute("emailup", rst.getString(4));
                    request.setAttribute("telup", rst.getString(5));
                    request.setAttribute("programmeup", rst.getString(6));
                  
                    request.setAttribute("statusup", rst.getString(7));
                }
              
                
                request.getRequestDispatcher("updateuser.jsp").forward(request, response);
                
            } catch (SQLException ex) {
                Logger.getLogger(ajoute_user.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (value.equals("delad")) {
            PreparedStatement prst;
            Connection con;
            con = MyConnection.getMyConnection();
            try {

                prst = con.prepareStatement("delete from Util where Matricule=?  ");
                prst.setInt(1, id);
                prst.executeUpdate();
                request.getRequestDispatcher("Ajouter_admins.jsp").forward(request, response);

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
        PrintWriter pr = response.getWriter();
        int mat = Integer.parseInt(request.getParameter("mat"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String programme = request.getParameter("programme");
        String status = "User";
        String msg;
        if (programme.equals("--Choisir--")) {
            msg = "veillez remplire tous les champs";
            request.setAttribute("msg", msg);

            request.getRequestDispatcher("Ajoute_users.jsp?error=1").include(request, response);
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
                pr.println("<div style='position:absolute;top:70%;color:green;font-size:20px;margin-left:6%'>");
                pr.println("user ajouter avec succes");
                pr.println("</div>");
                request.getRequestDispatcher("Ajoute_users.jsp").include(request, response);

            } catch (SQLException ex) {
                pr.println("<div style='position:absolute;top:70%;color:red;font-size:20px;margin-left:6%'>");
                pr.println("user non ajouter , verifier <br>");
                pr.println("Matricule déja existe");
                pr.println("</div>");
                request.getRequestDispatcher("Ajoute_users.jsp").include(request, response);
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
