package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-image: url(\"images/2.jpg\")  ;\n");
      out.write("            background-position: center;\n");
      out.write("            background-size: cover;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        #mat {\n");
      out.write("            background-color: #4b320377;\n");
      out.write("            padding-top: 10px;\n");
      out.write("            margin-top: 7%;\n");
      out.write("            width: 330px;\n");
      out.write("            height: 350px;\n");
      out.write("            /* border: 5px double black; */\n");
      out.write("            border-radius: 10px;\n");
      out.write("            -webkit-box-shadow: 10px 10px 10px 10px #212121;\n");
      out.write("            filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);\n");
      out.write("            box-shadow: 10px 10px 10px  #212121;\n");
      out.write("\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        input{\n");
      out.write("            -webkit-box-shadow: 7px 7px 7px #212121;\n");
      out.write("            filter: progid:DXImageTransform.Microsoft.Shadow(color=#333333, direction=120, strength=5);\n");
      out.write("            box-shadow: 5px 5px 5px #212121;\n");
      out.write("            background-color: transparent;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("        #form {\n");
      out.write("            align-content: center;\n");
      out.write("        }\n");
      out.write("        #matre {\n");
      out.write("            width: 220px;\n");
      out.write("            height: 30px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            padding-left: 10px;\n");
      out.write("            color: white; \n");
      out.write("            border: solid 1px black;\n");
      out.write("            border: solid 1px rgb(209, 167, 167);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #connexion {\n");
      out.write("            width: 220px;\n");
      out.write("            height: 30px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            padding-left: 10px;\n");
      out.write("            border: solid 2px rgb(84, 87, 226);\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: rgb(84, 87, 226);\n");
      out.write("            text-align: center;\n");
      out.write("            background-color: transparent;\n");
      out.write("        }\n");
      out.write("        #lab2 {\n");
      out.write("            color: rgb(219, 159, 159);\n");
      out.write("            size: 30px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            text-shadow: 3px;\n");
      out.write("            font-weight: 30px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <center>\n");
      out.write("        \n");
      out.write("            <div id=\"mat\">\n");
      out.write("                <form action=\"login\" method=\"post\" id=\"form\">\n");
      out.write("                    <label id=\"lab1\">\n");
      out.write("                        <h2 style=\"color:rgb(84, 87, 226)\"> Bienvenue sur Votre Application de Gestion de Stock</h2>\n");
      out.write("                    </label> <br><br>\n");
      out.write("                    <label id=\"lab2\"> Matriculation :</label> <br><br>\n");
      out.write("                    <input type=\"text\" name=\"matr\" id=\"matre\" class=\"matr\" pattern=\"^\\d{6}$\"\n");
      out.write("                           placeholder=\"Entrez Votre Matricule...\"  required><br><br>\n");
      out.write("                     \n");
      out.write("\n");
      out.write("                    <input type=\"submit\" value=\"Connexion\" id=\"connexion\">\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        <br><br><br><br>\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
