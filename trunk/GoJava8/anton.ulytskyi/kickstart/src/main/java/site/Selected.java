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

	private static final int MAX_INVEST = 100000;
	
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

		try {
		String id = req.getQueryString();
        
       
        SQLLoader base = new SQLLoader();
        BaseOfProjects kickstarter;
		kickstarter = base.reload();
		
        List<String> project = kickstarter.findProfile(Integer.parseInt(id));
        
      // if make a comment from here to other comment - my Servlet work but can`t invest or 
      // leave a questions, how to fix it?
        
        String amount = req.getParameter("invest");
        String author = req.getParameter("author");
        String text = req.getParameter("text");
        
        SQLManager broker = new SQLManager();
        
        if(isWriteNumber(amount)){
        	int cash = Integer.parseInt(amount);
        	broker.invest(cash, Integer.parseInt(id));
        }
        
        if((!author.equals("author") && !author.equals(null) && !author.equals(""))&&
        		(!text.equals("text") || !text.equals(null) || !text.equals(""))){
        	broker.say(Integer.parseInt(amount), author, text);
        }
        //!!!
       // if I comment till that it`s work, but now i get 505 - what can I do?
        
        req.setAttribute("project", project);
      	req.getRequestDispatcher("Project.jsp").forward(req, resp);
      	 
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    	
    
		doGet(req, resp);
	}

	private boolean isWriteNumber(String amount) {
		int test;
		try {
		  test = Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			return false; 
		}
		if(test>0 && test<MAX_INVEST){
		return true;
		}else{
			return false;
		}
	}

}