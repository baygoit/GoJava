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
import com.ua.goit.alexkholmov.webform.StudioContactForm;

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
        //add new studio
        if (actionAnswer == 1 && selectedParam != null && selectedParam.equals("stud")) {
            FotoStudio studio = new FotoStudio();
            studio.setStudioId(0);
            StudioContactForm studioCF = new StudioContactForm();
            studioCF.iniFromFotostudio(studio);
            request.setAttribute("studio", studioCF);
            getServletContext().getRequestDispatcher("/StudioPage.jsp").forward(request, response);
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
                    return;
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
        //edit studio
        if (actionAnswer == 2 && selectedParam != null && selectedParam.equals("stud")) {
            DAOFactory daoFactory = new PostgreSQLDaoFactory();
            Connection con = null;
            FotoStudio studio;
            if (request.getParameter("cont_id") != null) {
                int studioId =  Integer.parseInt(request.getParameter("cont_id"));
                try {
                    con = daoFactory.getConnection();
                    StudioDao studioDao = daoFactory.getStudioDao(con);
                    studio = studioDao.read(studioId);
                    StudioContactForm studioCF = new StudioContactForm();
                    studioCF.iniFromFotostudio(studio);
                    request.setAttribute("studio", studioCF);
                    getServletContext().getRequestDispatcher("/StudioPage.jsp").forward(request, response);
                    return;                    
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            
        }
        
        //delete customer
        if (actionAnswer == 3 && selectedParam != null && selectedParam.equals("cust")) {
            DAOFactory daoFactory = new PostgreSQLDaoFactory();
            Connection con = null;
            if (request.getParameter("cont_id") != null) {
                try {
                    Customer customer = new Customer();
                    customer.setCustomerId(Integer.parseInt(request.getParameter("cont_id")));
                    con = daoFactory.getConnection();
                    CustomerDao customerDao = daoFactory.getCustomerDao(con);
                    customerDao.delete(customer);
                    getServletContext().getRequestDispatcher("/MainPage.jsp").forward(request, response);
                    return;
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
        
        //delete studio
        if (actionAnswer == 3 && selectedParam != null && selectedParam.equals("stud")) {
            DAOFactory daoFactory = new PostgreSQLDaoFactory();
            Connection con = null;
            if (request.getParameter("cont_id") != null) {
                try {
                    FotoStudio studio = new FotoStudio();
                    studio.setStudioId(Integer.parseInt(request.getParameter("cont_id")));
                    con = daoFactory.getConnection();
                    StudioDao studioDao = daoFactory.getStudioDao(con);
                    studioDao.delete(studio);
                    getServletContext().getRequestDispatcher("/MainPage.jsp").forward(request, response);
                    return;
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
      //show list of contacts or list of studios
        if (actionAnswer == 4) {
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
                    e.printStackTrace();
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
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
                    e.printStackTrace();
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
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
        
        if (request.getParameter("delete") != null) {
            return 3;
        }
        
        if (request.getParameter("getlist") != null) {
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
