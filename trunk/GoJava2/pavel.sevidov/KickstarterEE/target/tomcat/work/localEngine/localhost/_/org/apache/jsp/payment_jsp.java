package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class payment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <title>Kickstarter payment</title>\r\n");
      out.write("  <meta name=\"generator\" content=\"Bootply\" />\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("  <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <!--[if lt IE 9]>\r\n");
      out.write("  <script src=\"//html5shim.googlecode.com/svn/trunk/html5.js\"></script>\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("  <link href=\"css/styleforaddnew.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header class=\"navbar navbar-bright navbar-fixed-top\" role=\"banner\">\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <div class=\"navbar-header\">\r\n");
      out.write("      <button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("        <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("      </button>\r\n");
      out.write("    </div>\r\n");
      out.write("    <nav class=\"collapse navbar-collapse\" role=\"navigation\">\r\n");
      out.write("      <ul class=\"nav navbar-nav\">\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"http://localhost:8080/categories\" class=\"navbar-brand\">Home</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">Category</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">Category</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">Category</a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li>\r\n");
      out.write("          <a href=\"#\">About</a>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("      <ul class=\"nav navbar-right navbar-nav\">\r\n");
      out.write("        <li class=\"dropdown\">\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"><i class=\"glyphicon glyphicon-search\"></i></a>\r\n");
      out.write("          <ul class=\"dropdown-menu\" style=\"padding:12px;\">\r\n");
      out.write("            <form class=\"form-inline\">\r\n");
      out.write("              <button type=\"submit\" class=\"btn btn-default pull-right\"><i class=\"glyphicon glyphicon-search\"></i></button><input type=\"text\" class=\"form-control pull-left\" placeholder=\"Search\">\r\n");
      out.write("            </form>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("  </div>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("<div id=\"masthead\">  \r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("      <div class=\"col-md-7\">\r\n");
      out.write("        <h1>Kickstarter\r\n");
      out.write("          <p class=\"lead\"></p>\r\n");
      out.write("        </h1>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div> \r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("      <div class=\"col-md-12\">\r\n");
      out.write("      </div>\r\n");
      out.write("    </div> \r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("  <div class=\"row\">\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"col-md-12\"> \r\n");
      out.write("      \r\n");
      out.write("      <div class=\"panel\">\r\n");
      out.write("        <div class=\"panel-body\">\r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("          \r\n");
      out.write("          <!--/stories-->\r\n");
      out.write("          <div class=\"row\">    \r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"col-md-2 col-sm-3 text-center\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-10 col-sm-9\">\r\n");
      out.write("              <div class=\"col-xs-9\">\r\n");
      out.write("                <h3>Donate</h3>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"name\" placeholder=\"Name\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"card\" placeholder=\"Card number\">\r\n");
      out.write("                <input type=\"text\" class=\"form-control\" name=\"amount\" placeholder=\"Amount\">\r\n");
      out.write("                <hr>              \r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-xs-9\">\r\n");
      out.write("        \r\n");
      out.write("          \r\n");
      out.write("            <a href=\"/servlets/categories?money=?\" class=\"btn btn-success pull-right btnNext\">Donate<i class=\"glyphicon glyphicon-plus\"></i></a></div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("                                                                                       \r\n");
      out.write("\t                                                \r\n");
      out.write("                                                      \r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\" id=\"footer\">\r\n");
      out.write("  <div class=\"row\">\r\n");
      out.write("    <div class=\"col col-sm-12\">\r\n");
      out.write("      \r\n");
      out.write("      <h1>Follow Us</h1>\r\n");
      out.write("      <div class=\"btn-group\">\r\n");
      out.write("        <a class=\"btn btn-twitter btn-lg\" href=\"#\"><i class=\"icon-twitter icon-large\"></i> Twitter</a>\r\n");
      out.write("        <a class=\"btn btn-facebook btn-lg\" href=\"#\"><i class=\"icon-facebook icon-large\"></i> Facebook</a>\r\n");
      out.write("        <a class=\"btn btn-google-plus btn-lg\" href=\"#\"><i class=\"icon-google-plus icon-large\"></i> Google+</a>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<footer>\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("      <div class=\"col-sm-6\">\r\n");
      out.write("        <h3 class=\"pull-center foot\">&copy; Deuces Inc. 2014. All Rights Reserved.</a></p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</footer>\r\n");
      out.write("<!-- script references -->\r\n");
      out.write("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
