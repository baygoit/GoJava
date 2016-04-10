package site;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.BaseOfProjects;
import project.Project;
import project.SQLLoader;
import project.SQLManager;
import project.SQLQuotes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

 
public class Selected extends HttpServlet {

	//public static BaseOfProjects projects = new BaseOfProjects();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

		try {
			String id = req.getQueryString();
        PrintWriter out = resp.getWriter();
       
        SQLLoader base = new SQLLoader();
        BaseOfProjects kickstarter;
		
			kickstarter = base.reload();
		
        String profile = kickstarter.findProfile(Integer.parseInt(id));
        
        out.print("<h1>"+FirstPage.DECORATION+"</h1>");
       
        	out.println(profile);
        
        out.print("<h1>"+FirstPage.DECORATION+"</h1>");
        out.print("<a href=\"/kickstart-0.0.1-SNAPSHOT/categories\">previous</a>");
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}