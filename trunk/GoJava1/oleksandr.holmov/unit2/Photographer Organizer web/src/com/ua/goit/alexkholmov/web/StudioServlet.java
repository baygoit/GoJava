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

import com.ua.goit.alexkholmov.dao.DAOFactory;
import com.ua.goit.alexkholmov.dao.StudioDao;
import com.ua.goit.alexkholmov.logic.FotoStudio;
import com.ua.goit.alexkholmov.sqldao.PostgreSQLDaoFactory;

/**
 * Servlet implementation class StudioServlet
 */
@WebServlet("/StudioServlet")
public class StudioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processReques(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studioId = request.getParameter("studioId");
        if (studioId != null && request.getParameter("ok") != null) {
            try {
                if (Integer.parseInt(studioId) > 0) {
                    updateStudio(request);
                } else {
                    insertStudio(request);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        getServletContext().getRequestDispatcher("/ContactsPage.jsp").forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processReques(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processReques(request, response);
	}
	
	private void insertStudio(HttpServletRequest request) throws ServletException, ParseException {
	    FotoStudio studio = prepareStudio(request);
	    DAOFactory daoFactory = new PostgreSQLDaoFactory();
	    Connection connection = null;
	    try {
            connection = daoFactory.getConnection();
            StudioDao studioDao = daoFactory.getStudioDao(connection);
            studioDao.create(studio);
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
	
	private void updateStudio(HttpServletRequest request) throws ServletException, ParseException {
        FotoStudio studio = prepareStudio(request);
        DAOFactory daoFactory = new PostgreSQLDaoFactory();
        Connection connection = null;
        try {
            connection = daoFactory.getConnection();
            StudioDao studioDao = daoFactory.getStudioDao(connection);
            studioDao.update(studio);
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
	
	private FotoStudio prepareStudio(HttpServletRequest request) throws ServletException, ParseException {
        FotoStudio studio = new FotoStudio();
        studio.setStudioId(Integer.parseInt(request.getParameter("studioId")));
        studio.setName(request.getParameter("studname"));
        studio.setAddress(request.getParameter("studaddress"));
        studio.setPhone(request.getParameter("studphone"));
        studio.setAdditionalInfo(request.getParameter("studinfo"));
        return studio;
    }

}
