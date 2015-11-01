package com.azuiev.servlet;

import com.azuiev.dao.DaoCity;
import com.azuiev.dao.DaoDB;
import com.azuiev.db.AirbnbDB;
import com.azuiev.model.City;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Masta on 31.10.2015.
 */
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DaoDB db = new AirbnbDB();
        DaoCity daoCity = new DaoCity(db.getConnection());
        List<City> city = null;
        try {
            city = (List<City>) daoCity.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("City", city);
        ServletContext context = req.getSession().getServletContext();
       // ServletContext context = getServletContext();
        req.getRequestDispatcher(context.getInitParameter("path")+"Search.jsp").forward(req,resp);

    }
}
