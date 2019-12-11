/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SAMSAM BILAL
 */
@WebServlet(name = "SendEmail", urlPatterns = {"/SendEmail"})
public class SendEmail extends HttpServlet {

    String email, subject, mess;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SendEmail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendEmail at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        HttpSession s = request.getSession();
        response.setContentType("text/html");
        String msg = "email de reclamation :  " +s.getAttribute("email");
//        email = request.getParameter("email");
        subject = request.getParameter("sujet");
        mess = request.getParameter("message");
        final String username = "aminechagdani99@gmail.com"; //ur email
        final String password = "Matis2019**";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(email));//ur email
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("aminechagdani99@gmail.com"));//u will send to
            message.setSubject(subject);
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            MimeBodyPart messageBodyPart1 = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();

            messageBodyPart1.setText(msg + "\n\n\n\n" + mess);
            multipart.addBodyPart(messageBodyPart1);

            message.setContent(multipart);

            out.println("sending...");
            Transport.send(message);
            out.println("Done");
            if (s.getAttribute("status").equals("Admin")) {
                response.sendRedirect("page_admin.jsp");
            }else   if (s.getAttribute("status").equals("User")) {
                response.sendRedirect("DemanderProd.jsp");
            }
        } catch (MessagingException e) {
            e.printStackTrace();
            response.sendRedirect("nous_contacter.jsp");
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
