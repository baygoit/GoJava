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

public class GoodTypeServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    public GoodTypeServlet() {    	
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {	
    	HttpSession session = request.getSession();     
    	GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
    	String name = (String)request.getParameter("type"); 
    	String action = (String)request.getParameter("action"); 
    	String destination = (String)request.getParameter("destination");    
    	if ("create".equals(action)) {
    		String parentIDString = (String)request.getParameter("parentid");
    		Integer parentID; 
    		if (parentIDString == null) {
    			String parentName = (String)request.getParameter("parent"); 
    			GoodType type = null;
				try {
					type = catalog.getGoodTypeByName(parentName);
				} catch (ShopException e) {
					Logger.logException(e);
				}
    			parentID = type.getId();
    		}
    		else {
        		parentID = Integer.decode(parentIDString); 
    		}
    		System.out.println("not so bad");
    		String msg = null;
			try {
				msg = catalog.createType(name, parentID);
			} catch (ShopException e) {
				Logger.logException(e);
			} 
    		GoodType brandNewType = null;
			try {
				brandNewType = catalog.getGoodTypeByName(name);
			} catch (ShopException e) {
				Logger.logException(e);
			} 
    		session.setAttribute("message", msg);
    		session.setAttribute("newType", brandNewType); 
    		session.setAttribute("typeOfReport", "goodType");
    		response.sendRedirect("result_page.jsp");
    	}/*
    	if("retrieveone".equals(action)){
    	   	Good good = catalog.getGoodByName(name);    	
    	   	session.setAttribute("name", good.getName());        	
    	   	session.setAttribute("id", good.getId());       	
    	   	session.setAttribute("description", good.getDescription()); 
    	   	session.setAttribute("goods", null);
    		session.setAttribute("allowed", "readonly"); 
    		response.sendRedirect(destination);
    	}
    	if("retrieve".equals(action)){
        	List<Good> allGoods = catalog.getAllGoods(); 
        	session.setAttribute("goods", allGoods);
        	Good good = catalog.getGoodByName(name);    	
    	    session.setAttribute("name", good.getName());        	
    	    session.setAttribute("id", good.getId());       	
    	    session.setAttribute("description", good.getDescription()); 
    		session.setAttribute("allowed", "readonly"); 
    		response.sendRedirect("good_view.jsp");
    	}*/
    	if ("update".equals(action)) {
    		/*
    		String goodTypeCodeString = (String)request.getParameter("type");
    		Integer goodTypeCode = null;
    		if (goodTypeCodeString == null){
    		}
    		else {
    			goodTypeCode = Integer.decode(goodTypeCodeString);
    		}
    		GoodType goodType = catalog.getGoodTypeById(goodTypeCode) ;
			session.setAttribute("type", goodType);
			response.sendRedirect("good_type_edit.jsp");*/
    	}
    	
    	if ("delete".equals(action)) {
    		Integer goodTypeCode = Integer.decode((String)request.getParameter("type"));
    		GoodType goodType = null;
			try {
				goodType = catalog.getGoodTypeById(goodTypeCode);
			} catch (ShopException e) {
				Logger.logException(e);
			}
    		String msg = null;
    		if (goodType == null){
    			msg = "Such good does not exist!";
    		}
    		else {
    			if(catalog.deleteGoodType(goodType)) {
    				msg = "Succesfully deleted.";
    			}
    			else {
    				msg = "Item did not exist or was already deleted.";
    			}
    		}
    		session.setAttribute("message", msg);
    		session.setAttribute("redirect", "editor_page");
    		session.setAttribute("typeOfReport", "goodType");
			response.sendRedirect("result_page.jsp");
    	}
    	
    } 

}