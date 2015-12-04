/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.controller;

import com.gojava6.cart.ShoppingCart;
import com.gojava6.entity.Category;
import com.gojava6.entity.Product;
import com.gojava6.service.CategoryService;
import com.gojava6.service.OrderService;
import com.gojava6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.inject.Scope;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 12/1/15
 */
@Controller
@SessionAttributes(value = {"selectedCategory", "categoryProducts"})
public class ShopController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderManager;

    @Autowired
    ServletContext context;

    private String surcharge;

    @RequestMapping(value = {"/category"} , method = RequestMethod.GET)
    public ModelAndView category(@RequestParam("id") String categoryId,
                                 ModelAndView modelAndView){

        /*ModelAndView modelAndView = new ModelAndView();*/
        modelAndView.setViewName("category");
        Category selectedCategory;
        Collection<Product> categoryProducts;


            // get categoryId from request
            //String categoryId = request.getQueryString();

            if (categoryId != null) {

                // get selected category
                selectedCategory = categoryService.find(Short.parseShort(categoryId));

                // place selected category in session scope
                modelAndView.addObject("selectedCategory", selectedCategory);

                // get all products for selected category
                categoryProducts = selectedCategory.getProducts();

                // place category products in session scope
                modelAndView.addObject("categoryProducts", categoryProducts);
            }


        return modelAndView;
    }

    @RequestMapping(value = {"/viewCart"} ,method = RequestMethod.GET)
    public String viewCart(){
        return "cart";
    }

    @PostConstruct
    public void init() {
        surcharge = context.getInitParameter("deliverySurcharge");
        context.setAttribute("categories", categoryService.findAll());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
