package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.ufpr.tads.web2.beans.ConfigBean;

public final class erro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      com.ufpr.tads.web2.beans.ErroBean erro = null;
      synchronized (request) {
        erro = (com.ufpr.tads.web2.beans.ErroBean) _jspx_page_context.getAttribute("erro", PageContext.REQUEST_SCOPE);
        if (erro == null){
          erro = new com.ufpr.tads.web2.beans.ErroBean();
          _jspx_page_context.setAttribute("erro", erro, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("erro"), request);
      out.write("\n");
      out.write("        <h1>\n");
      out.write("            msg:");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.ufpr.tads.web2.beans.ErroBean)_jspx_page_context.findAttribute("erro")).getMsg())));
      out.write("\n");
      out.write("        </h1>\n");
      out.write("                <a href=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.ufpr.tads.web2.beans.ErroBean)_jspx_page_context.findAttribute("erro")).getPage())));
      out.write("\">Page</a>\n");
      out.write("            \n");
      out.write("        <footer>\n");
      out.write("            ");
      com.ufpr.tads.web2.beans.ConfigBean conf = null;
      synchronized (application) {
        conf = (com.ufpr.tads.web2.beans.ConfigBean) _jspx_page_context.getAttribute("conf", PageContext.APPLICATION_SCOPE);
        if (conf == null){
          conf = new com.ufpr.tads.web2.beans.ConfigBean();
          _jspx_page_context.setAttribute("conf", conf, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\n");
      out.write("            Em caso de problemas contate o adm do server:");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.ufpr.tads.web2.beans.ConfigBean)_jspx_page_context.findAttribute("conf")).getEmail())));
      out.write("\n");
      out.write("        </footer>\n");
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
