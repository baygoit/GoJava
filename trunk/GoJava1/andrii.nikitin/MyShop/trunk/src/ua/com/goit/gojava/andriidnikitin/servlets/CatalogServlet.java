package ua.com.goit.gojava.andriidnikitin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

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

public class CatalogServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    public CatalogServlet() {    	
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException { 	    	       	
    	String name = (String)request.getParameter("parent");   	
    	String destination = (String)request.getParameter("destination");
    	GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
    	List<GoodType> types = null;
    	List<Good> goods = null;
    	HttpSession session = request.getSession(); 
    	if (name.equals("root")){
    		try {
				types = catalog.getGoodTypesFromRoot();
			} catch (ShopException e) {
				Logger.logException(e);
			} 
    	}
    	else {    		
    		GoodType type = null;
			try {
				type = catalog.getGoodTypeByName(name);
			} catch (ShopException e) {
				Logger.logException(e);
			} 
    		List<GoodType> children = null;
			try {
				children = catalog.getChildren(type);
			} catch (ShopException e) {
				Logger.logException(e);
			} 
    		if (children.isEmpty()){
    			goods = catalog.getGoodsInType(type); 
    		}
    		else {
    			types = children; 
    		}    		
    	}    	  
    	session.setAttribute("types", types);    
    	session.setAttribute("goods", goods);
		response.sendRedirect(destination);
    } 
}