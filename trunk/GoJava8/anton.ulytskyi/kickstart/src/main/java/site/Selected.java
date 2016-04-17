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
        
      // если закоментировать код от данного участка, до слудующего комментария - код работает, 
      // но не могу заставить сервлет брать данные из JCP и на основе их делать операции 
      // типо инвестиций и комментариев
        
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
        
       // если закомментировать до сюдого - страница отображается, куда смотреть, что исправлять?
        
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