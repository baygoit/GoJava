package ua.com.goit.gojava1.lslayer.hackit2;

import java.io.File;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PathInformer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter writer = response.getWriter();
	    response.setContentType("text/plain");
	    writer.println("HelloWorld");
	    File f = new File(".");
	    writer.println(f.isDirectory());
        File[] listOfFiles = f.listFiles();
        for (File element : listOfFiles) {
            if (element.getName() != null)
            writer.println(element.getCanonicalPath());
        }
        writer.println(!this.getServletContext().getServerInfo().equals("Apache Tomcat/7.0.57"));
        writer.println(request.getContextPath());
        writer.println(request.getPathInfo());
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
