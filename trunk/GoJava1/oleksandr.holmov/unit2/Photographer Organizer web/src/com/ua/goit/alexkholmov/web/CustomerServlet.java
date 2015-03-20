package com.ua.goit.alexkholmov.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ua.goit.alexkholmov.dao.CustomerDao;
import com.ua.goit.alexkholmov.dao.DAOFactory;
import com.ua.goit.alexkholmov.logic.Customer;
import com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoFactory;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerId = request.getParameter("customerId");
        if (customerId != null && request.getParameter("ok") != null) {
            try {
                if (Integer.parseInt(customerId) > 0) {
                    updateCustomer(request);
                } else {
                    insertCustomer(request);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        getServletContext().getRequestDispatcher("/AddOrderPage.jsp").forward(request, response);
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

	private void insertCustomer(HttpServletRequest request) throws ServletException, ParseException {
	    Customer customer = prepareCustomer(request);
	    DAOFactory daoFactory = new PostgreSQLDaoFactory();
	    Connection connection = null;
	    try {
            connection = daoFactory.getConnection();
            CustomerDao customerDao = daoFactory.getCustomerDao(connection);
            customerDao.create(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	private void updateCustomer(HttpServletRequest request) throws ServletException, ParseException{
        Customer customer = prepareCustomer(request);
        DAOFactory daoFactory = new PostgreSQLDaoFactory();
        Connection connection = null;
        try {
            connection = daoFactory.getConnection();
            CustomerDao customerDao = daoFactory.getCustomerDao(connection);
            customerDao.update(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	private Customer prepareCustomer(HttpServletRequest request) throws ServletException, ParseException{
	    Customer customer = new Customer();
	    customer.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
	    customer.setName(request.getParameter("custname"));
	    customer.setAddress(request.getParameter("custaddress"));
	    customer.setPhone(request.getParameter("custphone"));
	    customer.setAdditionalInfo(request.getParameter("custinfo"));
	    return customer;
    }
}
