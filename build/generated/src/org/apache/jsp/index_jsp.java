package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.ufpr.tads.web2.beans.ErroBean;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			"/erro.jsp", true, 8192, true);
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

            //ErroBean erro = new ErroBean();
            //erro = (ErroBean) request.getAttribute("erro");
            //if (erro != null) {
        
      out.write("\n");
      out.write("        ");
      com.ufpr.tads.web2.beans.ErroBean erro = null;
      synchronized (session) {
        erro = (com.ufpr.tads.web2.beans.ErroBean) _jspx_page_context.getAttribute("erro", PageContext.SESSION_SCOPE);
        if (erro == null){
          erro = new com.ufpr.tads.web2.beans.ErroBean();
          _jspx_page_context.setAttribute("erro", erro, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("       <font color=\"red\">\n");
      out.write("             ");
//out.print(erro.getMsg());
      out.write("\n");
      out.write("             ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${erro.msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("             </font>\n");
      out.write("            ");

               //}
            
      out.write("\n");
      out.write("            \n");
      out.write("        ");

            
            //String error = request.getParameter("erro");
            //if (error != null) {
        
      out.write("\n");
      out.write("       <font color=\"red\">\n");
      out.write("             ");
//out.print(erro);
      out.write("\n");
      out.write("             ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${erro}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("       </font>\n");
      out.write("            ");

                //}
            
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <form action=\"LoginServlet\" method=\"POST\">\n");
      out.write("                Login <input type=\"text\" name=\"login\" value=\"\"><br>\n");
      out.write("                Senha <input type=\"password\" name=\"senha\" value=\"\"><br>\n");
      out.write("                <input type=\"submit\" value=\"Login\">\n");
      out.write("            </form> \n");
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
