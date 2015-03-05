package ua.com.goit.gojava.andriidnikitin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalogImpl;
import ua.com.goit.gojava.andriidnikitin.service.util.ShopException;

public class GoodServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    public GoodServlet() {    	
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {	
    	HttpSession session = request.getSession();     
    	GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
    	String name = (String)request.getParameter("good"); 
    	String action = (String)request.getParameter("action"); 
    	String destination = (String)request.getParameter("destination");    	
    	if ("create".equals(action)) {
    		String categoryIDString = (String)request.getParameter("categoryid");
    		Integer categoryID; 
    		if (categoryIDString == null) {
    			String categoryName = (String)request.getParameter("categoryName"); 
    			GoodType type = null;
				try {
					type = catalog.getGoodTypeByName(categoryName);
				} catch (ShopException e) {
					Logger.logException(e);
				}
    			categoryID = type.getId();
    		}
    		else {
        		categoryID = Integer.decode(categoryIDString); 
    		}
    		String message = null;
			try {
				message = catalog.createGood(name, categoryID);
			} catch (ShopException e) {
				Logger.logException(e);
			} 
    		Good brandNewGood = catalog.getGoodByName(name); 
    		session.setAttribute("message", message);
    		session.setAttribute("typeOfReport", "good");
    		session.setAttribute("newGood", brandNewGood); 
    		response.sendRedirect("result_page.jsp");
    	}
    	if("retrieve".equals(action)){
    	   	Good good = catalog.getGoodByName(name);    	
    	   	session.setAttribute("name", good.getName());        	
    	   	session.setAttribute("id", good.getId());       	
    	   	session.setAttribute("description", good.getDescription()); 
    	   	session.setAttribute("goods", null);
    		session.setAttribute("allowed", "readonly"); 
    		response.sendRedirect(destination);
    	}
    	if("getall".equals(action)){
        	List<Good> allGoods = catalog.getAllGoods(); 
        	session.setAttribute("goods", allGoods);
        	Good good = catalog.getGoodByName(name);    	
    	    session.setAttribute("name", good.getName());        	
    	    session.setAttribute("id", good.getId());       	
    	    session.setAttribute("description", good.getDescription()); 
    		session.setAttribute("allowed", "readonly"); 
    		response.sendRedirect("good_view.jsp");
    	}
    	if ("update".equals(action)) {
    		String goodCodeString = (String)request.getParameter("good");
    		Integer goodCode = Integer.decode(goodCodeString);
    		Good good = catalog.getGoodById(goodCode) ;
    		String step = (String)request.getParameter("step");
    		if ("pre".equals(step)){
    			
    			session.setAttribute("good", good);
    			response.sendRedirect("good_edit.jsp");
    		}
    		if ("execute".equals(step)){
    			String message = null; 
    			String changeName =  request.getParameter("changeName");
    			String changeType =  request.getParameter("changeType"); 
    			String newName =  (String)request.getParameter("name");
    			String newTypeName =  (String)request.getParameter("type");
    			GoodType type = null;
    			if (changeName == null) {
    				newName = good.getName();
    			}
    			if (changeType == null) {
    				type = good.getType();
    			}
    			else {
    				try {
						type = catalog.getGoodTypeByName(newTypeName);
					} catch (ShopException e) {
						Logger.logException(e);
					}
    				if (type== null) {
    					message = "No such type exists. Changes declined.";
    				}
    			}
    			if (message != null){
    				//message = catalog.updateGood(newName, type, good.getId());	
    			}
        		session.setAttribute("message", message);
    			session.setAttribute("result", good);
    			response.sendRedirect("result_page.jsp");
    		}
    	}
    	
    	if ("delete".equals(action)) {
    		Integer goodCode = Integer.decode((String)request.getParameter("good"));
    		Good good = catalog.getGoodById(goodCode);
    		String message = null;
    		if (good == null){
    			message = "Such good does not exist!";
    		}
    		else {
    			if(catalog.deleteGood(good)) {
    				message = "Succesfully deleted.";
    			}
    			else {
    				message = "Item did not exist or was already deleted.";
    			}
    		}
    		session.setAttribute("message", message);
    		session.setAttribute("redirect", "editor_page");
    		session.setAttribute("result", " ");
			response.sendRedirect("result_page.jsp");
    	}
    	
    } 
}