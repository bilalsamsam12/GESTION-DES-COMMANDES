/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Commander", urlPatterns = {"/Commander"})
public class Commander extends HttpServlet {

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
            out.println("<title>Servlet Commander</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Commander at " + request.getContextPath() + "</h1>");
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
        int qte = Integer.parseInt(request.getParameter("qte"));
        String id = (request.getParameter("idpro"));
        ArrayList<String> lis = (s.getAttribute("panel") == null) ? new ArrayList<String>() : (ArrayList<String>) s.getAttribute("panel");
        boolean found = false;
        if (qte == 0 || qte < 0) {

        } else {
            for (int i = 0; i < lis.size(); i++) {
                String [] ids=id.split(":");
                String[] ligncomd = lis.get(i).split(":");
                if (ids[0].equals(ligncomd[0]) && ids[1].equals(ligncomd[1])) {
                    ligncomd[4] = String.valueOf(Integer.parseInt(ligncomd[4]) + qte);
                    lis.set(i, ligncomd[0] + ":" + ligncomd[1]+":" + ligncomd[2]+":" + ligncomd[3]+":" + ligncomd[4]);
                    found = true;
                }

            }
            if (!found) {
                lis.add(id + ":" + qte);
                s.setAttribute("panel", lis);
            }
        }
        PrintWriter p = response.getWriter();
        request.getRequestDispatcher("DemanderProd.jsp").include(request, response);

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
