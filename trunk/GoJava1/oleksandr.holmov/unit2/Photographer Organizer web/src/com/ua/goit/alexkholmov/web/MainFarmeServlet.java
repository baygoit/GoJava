package com.ua.goit.alexkholmov.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ua.goit.alexkholmov.dao.CustomerDao;
import com.ua.goit.alexkholmov.dao.DAOFactory;
import com.ua.goit.alexkholmov.dao.StudioDao;
import com.ua.goit.alexkholmov.logic.Customer;
import com.ua.goit.alexkholmov.logic.FotoStudio;
import com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoFactory;
import com.ua.goit.alexkholmov.webform.ContactsForm;
import com.ua.goit.alexkholmov.webform.CustomerContactForm;

/**
 * Servlet implementation class MainFarmeServlet
 */
@WebServlet("/MainFarmeServlet")
public class MainFarmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFarmeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedParam = request.getParameter("typecontact");
        int actionAnswer = 0;
        actionAnswer = checkAction(request);
        
        //add new customer
        if (actionAnswer == 1 && selectedParam != null && selectedParam.equals("cust")) {
            Customer customer = new Customer();
            customer.setCustomerId(0);
            CustomerContactForm customerCF = new CustomerContactForm();
            customerCF.initFromCustomer(customer);
            request.setAttribute("customer", customerCF);
            getServletContext().getRequestDispatcher("/CustomerPage.jsp").forward(request, response);
            return;
        }
        
        //edit customer
        if (actionAnswer == 2 && selectedParam != null && selectedParam.equals("cust")) {
            DAOFactory daoFactory = new PostgreSQLDaoFactory();
            Connection con = null;
            Customer customer;
            if (request.getParameter("cont_id") != null) {
                int customerId = Integer.parseInt(request.getParameter("cont_id"));
                try {
                    con = daoFactory.getConnection();
                    CustomerDao customerDao = daoFactory.getCustomerDao(con);
                    customer = customerDao.read(customerId);
                    CustomerContactForm customerCF = new CustomerContactForm();
                    customerCF.initFromCustomer(customer);
                    request.setAttribute("customer", customerCF);
                    getServletContext().getRequestDispatcher("/CustomerPage.jsp").forward(request, response);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
        if (actionAnswer == 3) {
            //show list of contacts or list of studios
            DAOFactory daoFactory = new PostgreSQLDaoFactory();
            Connection con = null;
            if (selectedParam != null && selectedParam.equals("cust")) {
                List<Customer> customers;
                try {
                    ContactsForm form = new ContactsForm();
                    con = daoFactory.getConnection();
                    CustomerDao customerDao = daoFactory.getCustomerDao(con);
                    customers = customerDao.getAll();
                    form.setList(customers);
                    form.setType(Customer.TYPE);
                    request.setAttribute("form", form);
                    getServletContext().getRequestDispatcher("/MainPage.jsp").forward(request, response);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (selectedParam != null && selectedParam.equals("stud")) {
                List<FotoStudio> studios;
                try {
                    ContactsForm form = new ContactsForm();
                    con = daoFactory.getConnection();
                    StudioDao studioDao = daoFactory.getStudioDao(con);
                    studios = studioDao.getAll();
                    form.setList(studios);
                    form.setType(FotoStudio.TYPE);
                    request.setAttribute("form", form);
                    getServletContext().getRequestDispatcher("/MainPage.jsp").forward(request, response);
                } catch (SQLException e) {
                    // TODO: handle exception
                }
            }
        }

    }
    
    private int checkAction(HttpServletRequest request) {
        if (request.getParameter("add") != null) {
            return 1;
        }
        
        if (request.getParameter("edit") != null) {
            return 2;
        }
        
        if (request.getParameter("getlist") != null) {
            return 3;
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
