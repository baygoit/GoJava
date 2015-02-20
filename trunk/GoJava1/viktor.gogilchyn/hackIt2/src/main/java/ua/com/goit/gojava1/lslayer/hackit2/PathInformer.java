package ua.com.goit.gojava1.lslayer.hackit2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PathInformer
 */
public class PathInformer extends HttpServlet {
    private static final long serialVersionUID = 1L;
//    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PathInformer.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PathInformer() {
        super();
//        logger.debug("PathInformer created");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/plain");
        writer.println("HelloWorld");
        writer.println(System.getProperty("os.name").toLowerCase());
        writer.println(!this.getServletContext().getServerInfo().equals("Apache Tomcat/7.0.57"));
        writer.println(request.getContextPath());
        writer.println(request.getPathInfo());
        writer.println(request.getRequestURI());
        
	}

}
