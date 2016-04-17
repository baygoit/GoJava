package site;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.BaseOfProjects;
import project.Project;
import project.SQLLoader;
import project.SQLQuotes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

 
public class Type extends HttpServlet {


	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
try {
		SQLLoader base = new SQLLoader();
		BaseOfProjects kickstarter;
		
			kickstarter = base.reload();
		
		String type = req.getQueryString();
		List<Project> projects = kickstarter.selectCategory(type);
		
		req.setAttribute("type", type);
		req.setAttribute("projects", projects);
   	 req.getRequestDispatcher("Type.jsp").forward(req, resp);
   	 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/** 
		 * try {
			String type = req.getQueryString();
        PrintWriter out = resp.getWriter();
        List<Project> projects = kickstarter.selectCategory(type);
        
        out.print("<h1>"+FirstPage.DECORATION+"</h1>");
        out.print("<h1>"+type+"</h1>");
        out.print("<h1>"+FirstPage.DECORATION+"</h1>");
        int index=0;
        int nextPage;
        for(Project p:projects){
            index++;
        	nextPage = p.getId();
        	out.println(index +". " +" <a href=\"/kickstart-0.0.1-SNAPSHOT/selected"+"?"+nextPage+"\">"+p.showShortInformation()+"</a>");
        	out.println("<br />"); 
        }
        out.print("<h1>"+FirstPage.DECORATION+"</h1>");
        out.print("<a href=\"/kickstart-0.0.1-SNAPSHOT/categories\">previous</a>");
        
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
      */ 
    }
}