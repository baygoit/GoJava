package com.ua.goit.alexkholmov.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ua.goit.alexkholmov.logic.Customer;
import com.ua.goit.alexkholmov.logic.FotoStudio;
import com.ua.goit.alexkholmov.webform.CustomerContactForm;
import com.ua.goit.alexkholmov.webform.StudioContactForm;

/**
 * Servlet implementation class AllocateServlet
 */
@WebServlet("/AllocateServlet")
public class AllocateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllocateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int actionAnswer = 0;
        actionAnswer = checkAction(request);
        
        if (actionAnswer == 1) {
            Customer customer = new Customer();
            customer.setCustomerId(0);
            CustomerContactForm customerCF = new CustomerContactForm();
            customerCF.initFromCustomer(customer);
            request.setAttribute("customer", customerCF);
            getServletContext().getRequestDispatcher("/CustomerPage.jsp").forward(request, response);
            return; 
        }
        
        if (actionAnswer == 2) {
            FotoStudio studio = new FotoStudio();
            studio.setStudioId(0);
            StudioContactForm studioCF = new StudioContactForm();
            studioCF.iniFromFotostudio(studio);
            request.setAttribute("studio", studioCF);
            getServletContext().getRequestDispatcher("/StudioPage.jsp").forward(request, response);
            return;
        }
    }
    
    private int  checkAction(HttpServletRequest request) {
        if (request.getParameter("addcust") != null) {
            return 1;
        }
        
        if (request.getParameter("addstud") != null) {
            return 2;
        }
        
        if (request.getParameter("addphot") != null) {
            return 3;
        }
        
        if (request.getParameter("addsched") != null) {
            return 4;
        }
        return 0;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}

}
