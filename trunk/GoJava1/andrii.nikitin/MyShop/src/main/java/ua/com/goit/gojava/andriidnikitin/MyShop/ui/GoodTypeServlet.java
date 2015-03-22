package ua.com.goit.gojava.andriidnikitin.MyShop.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalogImpl;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;

public class GoodTypeServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    public GoodTypeServlet() {    	
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
    		Integer parentId = Integer.parseInt((String)request.getParameter("parent")); 
    		GoodType result;
    		try {
				result = catalog.createType(name, parentId);
				message = "Successfuly created!" + typeToString(result);
			} catch (MyShopException e) {
				message = "fail to create record";
			}
    	}
    	
    	if ("retrieve".equals(action)){
    		Integer id = Integer.parseInt((String)request.getParameter("id")); 
    		try {
				GoodType result = catalog.getGoodTypeById(id);
				message =  typeToString(result);
			} catch (MyShopException e) {
				message = "fail to read record";
			}
    	}
    	
    	if ("update".equals(action)){
    		Integer id = Integer.parseInt((String)request.getParameter("id")); 
    		Integer parentId = Integer.parseInt((String)request.getParameter("parent")); 
    		String name = (String)request.getParameter("name"); 
    		try {
				GoodType result= catalog.updateGoodType(id, name, parentId);
				message =  typeToString(result);
			} catch (MyShopException e) {
				e.printStackTrace();
				message = "fail to update record";
			} 
    		
    	}
    	
    	if ("delete".equals(action)){
    		Integer id = Integer.parseInt((String)request.getParameter("type")); 
    		try {
				catalog.deleteGoodType(id);
				message =  "successfully deleted";
			} catch (MyShopException e) {
				message = "fail to delete record";
			}
    	}
    	
    	if ("getall".equals(action)){
    		message = new String();
    		List<GoodType> list;
			try {
				list = catalog.getAllTypes();
				for (GoodType type: list){
	    			message += typeToString(type) + " <br/> ";
	    		}
			} catch (MyShopException e) {
				message = "fail to read all records";
			}
    		
    	}
    	session.setAttribute("message", message);
    	response.sendRedirect("result.jsp");
    }
    
    private String typeToString(GoodType type){
    	if (type == null){
    		return null;
    	}
    	GoodType parent = type.getParent();
    	String stringedParent  ;
    	if (parent == null){
    		stringedParent = "null";
    	}
    	else {
    		stringedParent  = parent.getName();
    	}
    	
    	return type.getName() + "  " + type.getId() + "   " + stringedParent;
    	
    }

   /* @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {	
    	HttpSession session = request.getSession();   
    	GoodCatalogImpl catalog = GoodCatalogImpl.getInstance();
    	String action = (String)request.getParameter("action"); 
    	switch (action){
	    	case "retrieve": session = retrieve(session, request, catalog);
	    	break;
	    	case "retrieve_list": session = retrieveList(session, request, catalog);
	    	break;
	    	case "create_from_root":session = createFromRoot(session, request, catalog);
	    	break;
	    	case "create":session = create(session, request, catalog);
	    	break;
	    	case "update":session = update(session, request, catalog);
	    	break;
	    	case "delete":session = delete(session, request, catalog);
	    	break;
    	}
    		response.sendRedirect(redirectLocation);
    }

	private HttpSession delete(HttpSession session, HttpServletRequest request, GoodCatalogImpl catalog) {
		// TODO Auto-generated method stub
		return null;
	}

	private HttpSession update(HttpSession session, HttpServletRequest request, GoodCatalogImpl catalog) {
		// TODO Auto-generated method stub
		return null;
	}

	private HttpSession createfromRoot(HttpSession session, HttpServletRequest request, GoodCatalogImpl catalog) {
		String name = (String)request.getParameter("type"); 
		try {
			GoodType brandNewType = catalog.createType(name, null);
			session.setAttribute("message", "Successfully created!");
			session.setAttribute("newType", brandNewType); 
			session.setAttribute("typeOfReport", "goodType");
		} catch(ShopException e) {
			MyShopGUIException.logException(e);
			session.setAttribute("message", "Unsuccessfully");
		}		
		redirectLocation = "result_page.jsp";
		return session;
	}

	private HttpSession create(HttpSession session,
			HttpServletRequest request, GoodCatalogImpl catalog) {
		Integer parentID; 
    	String name = (String)request.getParameter("type"); 
    	parentID = (Integer)request.getParameter("type");
		try {
			GoodType brandNewType = catalog.createType(name, null);
			session.setAttribute("message", "Successfully created!");
			session.setAttribute("newType", brandNewType); 
			session.setAttribute("typeOfReport", "goodType");
		} catch(ShopException e) {
			MyShopGUIException.logException(e);
			session.setAttribute("message", "Unsuccessfully");
		}		
		redirectLocation = "result_page.jsp";
		return session;
	}

	private HttpSession retrieveList(HttpSession session,
			HttpServletRequest request, GoodCatalogImpl catalog) {
		// TODO Auto-generated method stub
		return null;
	}

	private HttpSession retrieve(HttpSession session, HttpServletRequest request, GoodCatalogImpl catalog) {
		// TODO Auto-generated method stub
		return null;
	} */

}