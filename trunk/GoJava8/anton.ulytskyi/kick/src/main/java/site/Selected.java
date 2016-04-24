package site;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOProject;
import dao.DAOManager;
import domain.BaseOfProjects;

import java.io.IOException;
import java.util.List;

 
public class Selected extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int MAX_INVEST = 100000;
	
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

		try {
		String id = req.getQueryString();
        
		DAOProject base = new DAOProject();
        BaseOfProjects kickstarter;
		kickstarter = base.reload();
		
        List<String> project = kickstarter.findProfile(Integer.parseInt(id));
       
        req.setAttribute("project", project);
        req.setAttribute("projectId", id);
      	req.getRequestDispatcher("Project.jsp").forward(req, resp);
      	 
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    	
    	DAOManager broker = new DAOManager();
    	String id = req.getParameter("projectId");
    	String amount = req.getParameter("invest");
        String author = req.getParameter("author");
        String text = req.getParameter("text");
        
        if(isWriteNumber(amount)){
        	int cash = Integer.parseInt(amount);
        	try {
				broker.invest(cash, Integer.parseInt(id));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
        
        if((!author.equals("author") && !author.equals(null) && !author.equals(""))&&
        		(!text.equals("text") || !text.equals(null) || !text.equals(""))){
        	try {
				broker.say(Integer.parseInt(id), author, text);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }
    	
        resp.sendRedirect("selected?" + id);
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