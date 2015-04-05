package ua.com.goit.gojava.andriidnikitin.MyShop.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.MyShop.commons.ErrorLogger;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalogImpl;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;


public class GoodServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    public GoodServlet() {    	
        super();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {	
    	HttpSession session = request.getSession();   
    	GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
    	String action = (String)request.getParameter("action"); 
    	String message = null;
    	if ("create".equals(action)){
    		String name = (String)request.getParameter("name"); 
    		Integer typeId = Integer.parseInt((String)request.getParameter("type")); 
    		Good result;
    		try {
				result = catalog.createGood(name, typeId);
				message = "Successfuly created!" + goodToString(result, catalog);
			} catch (MyShopException e) {
				message = "fail to create record";
			}
    	}
    	
    	if ("retrieve".equals(action)){
    		Integer id = Integer.parseInt((String)request.getParameter("id")); 
    		try {
				Good result = catalog.getGoodById(id);
				message =   goodToString(result, catalog);
			} catch (MyShopException e) {
				message = "fail to read record";
			}
    	}
    	
    	if ("update".equals(action)){
    		Integer id = Integer.parseInt((String)request.getParameter("id")); 
    		Integer typeId = Integer.parseInt((String)request.getParameter("type")); 
    		String name = (String)request.getParameter("name"); 
    		try {
				Good result= catalog.updateGood(id, name, typeId);
				message =  goodToString(result, catalog);
			} catch (MyShopException e) {
				e.printStackTrace();
				message = "fail to update record";
			} 
    		
    	}
    	
    	if ("delete".equals(action)){
    		Integer id = Integer.parseInt((String)request.getParameter("type")); 
    		try {
				catalog.deleteGood(id);
				message =  "successfully deleted";
			} catch (MyShopException e) {
				message = "fail to delete record";
			}
    	}
    	
    	if ("getall".equals(action)){
    		message = new String();
    		List<Good> list;
			try {
				list = catalog.getAllGoods();
				for (Good type: list){
	    			message += goodToString(type, catalog) + " <br/> ";
	    		}
			} catch (MyShopException e) {
				message = "fail to read all records";
			}
    		
    	}
    	session.setAttribute("message", message);
    	response.sendRedirect("result.jsp");
    }
    
    private String goodToString(Good arg, GoodCatalog catalog) {
    	if (arg == null){
    		return null;
    	}
    	GoodType parent = null;
    	String stringedType  ;
		try {
			parent = catalog.getGoodTypeById(arg.getType().getId());
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getRootLogger());
			stringedType = "cannot read";
		}
    	if (parent == null){
    		stringedType = "null";
    	}
    	else {
    		stringedType  = parent.getName();
    	}
    	
    	return arg.getName() + "  " + arg.getId() + "   " + stringedType;    	
	}
}