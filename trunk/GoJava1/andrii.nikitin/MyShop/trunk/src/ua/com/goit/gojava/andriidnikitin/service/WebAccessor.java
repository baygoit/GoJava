package ua.com.goit.gojava.andriidnikitin.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public class WebAccessor extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    public WebAccessor() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	GoodCatalogImpl catalog = new GoodCatalogImpl();
    	List<GoodType> list = catalog.getGoodTypesFromRoot();
    	request.setAttribute("types", list);
    	request.setAttribute("types", list);
    	request.setAttribute("name", "test");
    	request.getRequestDispatcher("/index.jsp").forward(request, response);
     }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    }

}