/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.controller;

import com.gojava6.entity.Category;
import com.gojava6.entity.Product;
import com.gojava6.service.CategoryService;
import com.gojava6.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/8/15
 */
@WebServlet(urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

    private final String ADMIN_URL_PATH = "/admin/admin.jsp";
    private CategoryService categoryService = new CategoryService();
    private ProductService productService = new ProductService();
    private Category selectedCategory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Collection<Product> categoryProducts;
        String categoryId = req.getQueryString();
        if (categoryId != null) {

            // get selected category
            selectedCategory = categoryService.find(Short.parseShort(categoryId));

            // place selected category in session scope
            session.setAttribute("selectedCategory", selectedCategory);

            // get all products for selected category
            categoryProducts = selectedCategory.getProducts();

            // place category products in session scope
            session.setAttribute("categoryProducts", categoryProducts);
        }
        req.getRequestDispatcher(ADMIN_URL_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        BigDecimal price = new BigDecimal(req.getParameter("productPrice"));
        productService.updatePrice(id, price);

        resp.sendRedirect("/admin?" + selectedCategory.getId());
    }
}
