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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author chagd
 */
@WebServlet(name = "commandertest", urlPatterns = {"/commandertest"})
public class commandertest extends HttpServlet {

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
            out.println("<title>Servlet commandertest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet commandertest at " + request.getContextPath() + "</h1>");
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
        PrintWriter p = response.getWriter();
        Connection con = MyConnection.getMyConnection();

        PreparedStatement prst;
        HttpSession s = request.getSession();
        String mat = s.getAttribute("mat").toString();
        ArrayList<String> tofourni = new ArrayList<String>();
        ArrayList<String> listcmd = (ArrayList<String>) s.getAttribute("panel");
        try {
            prst = con.prepareStatement("insert into s_commande values(numcom.nextval,?,sysdate)");
            prst.setString(1, mat);
            prst.executeUpdate();
            System.out.println("insert s_commande");
            for (int i = 0; i < listcmd.size(); i++) {
                String[] inf = listcmd.get(i).split(":");
                prst = con.prepareStatement("insert into s_detailcom values(numcom.currval,?,?,?)");
                prst.setInt(1, Integer.parseInt(inf[0]));
                prst.setInt(2, Integer.parseInt(inf[4]));
                prst.setInt(3, Integer.parseInt(inf[1]));
                prst.executeUpdate();

            }
            System.out.println("inseert s_detailcom");
            int num = 1000201;
            PreparedStatement pe = con.prepareStatement("select numcom.currval from dual");
            ResultSet rts = pe.executeQuery();
            if (rts.next()) {
                num = rts.getInt(1);
            }
            System.out.println("select numcom");
            System.out.println(num);

            prst = con.prepareStatement("select matricule_f from s_detailcom where numcom=? group by matricule_f");
            prst.setInt(1, num);
            ResultSet rst = prst.executeQuery();
            System.out.println("select matricule");

            while (rst.next()) {
                System.out.println(rst.getInt(1));
                System.out.println(num);
                PreparedStatement pst = con.prepareStatement("select * from s_detailcom sd inner join fourprod fp on(fp.matricule_f=sd.matricule_f and fp.idprod=sd.idprod) inner join produit p on(p.idprod=fp.idprod) inner join fourni f on(f.matricule_f=fp.matricule_f) where sd.numcom=? and f.matricule_f=?");
                pst.setInt(1, num);
                pst.setInt(2, rst.getInt(1));
                ResultSet st = pst.executeQuery();
                while (st.next()) {
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
                        String msg = "commande numero " + st.getString("numcom") + " de" + s.getAttribute("nom") + "programme" + s.getAttribute("programme");
                        String mess = "     nom produit  : " + st.getString("nom_p") + "  marque  produit :  " + st.getString("marque") + "   quantiter demander :" + st.getInt("qte");

                        Message message = new MimeMessage(session);
                        message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse("aminechagdani99@gmail.com"));//u will send to
                        message.setSubject("Commande ");
                        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                        Multipart multipart = new MimeMultipart();

                        messageBodyPart1.setText(msg + "\n\n\n\n" + mess);
                        multipart.addBodyPart(messageBodyPart1);

                        message.setContent(multipart);

                        Transport.send(message);

                    } catch (MessagingException e) {
                        e.printStackTrace();

                    }

                }

            }

            ServletContext context = getServletContext();
            String path = context.getRealPath("/");
                       
            String desktopPath = System.getProperty("user.home") + "\\Desktop\\";

            JasperCompileManager.compileReportToFile(path + "..\\..\\report1.jrxml");
          
            Map<String, Object> par = new HashMap<String, Object>();
            par.put("numcom", num);
            JasperPrint pr = JasperFillManager.fillReport(path + "..\\..\\report1.jasper", par, con);
            JasperExportManager.exportReportToPdfFile(pr, desktopPath + "commande"+num+".pdf");

            s.setAttribute("panel", null);
        } 
    catch (SQLException ex) {
            Logger.getLogger(commandertest.class.getName()).log(Level.SEVERE, null, ex);
        }
    catch (JRException ex) {
            Logger.getLogger(commandertest.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("DemanderProd.jsp");

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
