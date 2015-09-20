package com.morkva.servlets;

import com.morkva.entities.Category;
import com.morkva.model.*;
import com.morkva.model.dao.DAOFactory;
import com.morkva.model.dao.PersistException;
import com.morkva.model.dao.jdbc.mysql.MySQLDaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by koros on 19.06.2015.
 */
@WebServlet("/")
public class MainServlet extends HttpServlet {

    DAOFactory<Connection> daoFactory = new MySQLDaoFactory();
    private CategoryRepository categoryRepository;
    private ProjectRepository projectRepository;
    private QuoteRepository quoteRepository;
    private PaymentOptionRepository paymentOptionRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            categoryRepository = new CategoryRepositoryImpl(daoFactory.getDao(daoFactory.getContext(), Category.class));
            req.setAttribute("categories", categoryRepository.getAll());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }
}
