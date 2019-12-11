package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("       \n");
      out.write("      \n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: 'Roboto';font-size: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .aboutus-section {\n");
      out.write("                padding: 90px 0;\n");
      out.write("            }\n");
      out.write("            .aboutus-title {\n");
      out.write("                font-size: 30px;\n");
      out.write("                letter-spacing: 0;\n");
      out.write("                line-height: 32px;\n");
      out.write("                margin: 0 0 39px;\n");
      out.write("                padding: 0 0 11px;\n");
      out.write("                position: relative;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                color: #000;\n");
      out.write("            }\n");
      out.write("            .aboutus-title::after {\n");
      out.write("                background: #fdb801 none repeat scroll 0 0;\n");
      out.write("                bottom: 0;\n");
      out.write("                content: \"\";\n");
      out.write("                height: 2px;\n");
      out.write("                left: 0;\n");
      out.write("                position: absolute;\n");
      out.write("                width: 54px;\n");
      out.write("            }\n");
      out.write("            .aboutus-text {\n");
      out.write("                color: #606060;\n");
      out.write("                font-size: 13px;\n");
      out.write("                line-height: 22px;\n");
      out.write("                margin: 0 0 35px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            a:hover, a:active {\n");
      out.write("                color: #ffb901;\n");
      out.write("                text-decoration: none;\n");
      out.write("                outline: 0;\n");
      out.write("            }\n");
      out.write("            .aboutus-more {\n");
      out.write("                border: 1px solid #fdb801;\n");
      out.write("                border-radius: 25px;\n");
      out.write("                color: #fdb801;\n");
      out.write("                display: inline-block;\n");
      out.write("                font-size: 14px;\n");
      out.write("                font-weight: 700;\n");
      out.write("                letter-spacing: 0;\n");
      out.write("                padding: 7px 20px;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("            }\n");
      out.write("            .feature .feature-box .iconset {\n");
      out.write("                background: #fff none repeat scroll 0 0;\n");
      out.write("                float: left;\n");
      out.write("                position: relative;\n");
      out.write("                width: 18%;\n");
      out.write("            }\n");
      out.write("            .feature .feature-box .iconset::after {\n");
      out.write("                background: #fdb801 none repeat scroll 0 0;\n");
      out.write("                content: \"\";\n");
      out.write("                height: 150%;\n");
      out.write("                left: 43%;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 100%;\n");
      out.write("                width: 1px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .feature .feature-box .feature-content h4 {\n");
      out.write("                color: #0f0f0f;\n");
      out.write("                font-size: 18px;\n");
      out.write("                letter-spacing: 0;\n");
      out.write("                line-height: 22px;\n");
      out.write("                margin: 0 0 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            .feature .feature-box .feature-content {\n");
      out.write("                float: left;\n");
      out.write("                padding-left: 28px;\n");
      out.write("                width: 78%;\n");
      out.write("            }\n");
      out.write("            .feature .feature-box .feature-content h4 {\n");
      out.write("                color: #0f0f0f;\n");
      out.write("                font-size: 18px;\n");
      out.write("                letter-spacing: 0;\n");
      out.write("                line-height: 22px;\n");
      out.write("                margin: 0 0 5px;\n");
      out.write("            }\n");
      out.write("            .feature .feature-box .feature-content p {\n");
      out.write("                color: #606060;\n");
      out.write("                font-size: 13px;\n");
      out.write("                line-height: 22px;\n");
      out.write("            }\n");
      out.write("            .icon {\n");
      out.write("                color : #f4b841;\n");
      out.write("                padding:0px;\n");
      out.write("                font-size:40px;\n");
      out.write("                border: 1px solid #fdb801;\n");
      out.write("                border-radius: 100px;\n");
      out.write("                color: #fdb801;\n");
      out.write("                font-size: 28px;\n");
      out.write("                height: 70px;\n");
      out.write("                line-height: 70px;\n");
      out.write("                text-align: center;\n");
      out.write("                width: 70px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"aboutus-section\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-3 col-sm-6 col-xs-12\">\n");
      out.write("                        <div class=\"aboutus\">\n");
      out.write("                            <h2 class=\"aboutus-title\">About Us</h2>\n");
      out.write("                            <p class=\"aboutus-text\">Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in.</p>\n");
      out.write("                            <p class=\"aboutus-text\">This is Photoshop's version of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem</p>\n");
      out.write("                            <a class=\"aboutus-more\" href=\"#\">read more</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-3 col-sm-6 col-xs-12\">\n");
      out.write("                        <div class=\"aboutus-banner\">\n");
      out.write("                            <img src=\"http://themeinnovation.com/demo2/html/build-up/img/home1/about1.jpg\" alt=\"\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-5 col-sm-6 col-xs-12\">\n");
      out.write("                        <div class=\"feature\">\n");
      out.write("                            <div class=\"feature-box\">\n");
      out.write("                                <div class=\"clearfix\">\n");
      out.write("                                    <div class=\"iconset\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-cog icon\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"feature-content\">\n");
      out.write("                                        <h4>Work with heart</h4>\n");
      out.write("                                        <p>Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in.</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"feature-box\">\n");
      out.write("                                <div class=\"clearfix\">\n");
      out.write("                                    <div class=\"iconset\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-cog icon\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"feature-content\">\n");
      out.write("                                        <h4>Reliable services</h4>\n");
      out.write("                                        <p>Donec vitae sapien ut libero venenatis faucibu. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"feature-box\">\n");
      out.write("                                <div class=\"clearfix\">\n");
      out.write("                                    <div class=\"iconset\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-cog icon\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"feature-content\">\n");
      out.write("                                        <h4>Great support</h4>\n");
      out.write("                                        <p>Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in.</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
