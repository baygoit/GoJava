/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.controller;

import com.gojava6.cart.ShoppingCart;
import com.gojava6.entity.Category;
import com.gojava6.entity.Product;
import com.gojava6.model.CartForm;
import com.gojava6.service.CategoryService;
import com.gojava6.service.OrderService;
import com.gojava6.service.ProductService;
import com.gojava6.validate.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@SessionAttributes(value = {"selectedCategory", "categoryProducts", "cart"})
public class ShopController {

    public static final String DEFAULT_CATEGORY = "0";
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderManager;

    @Autowired
    ServletContext context;

    private String surcharge;

    private Validator validator = new Validator();

    @RequestMapping(value = "/category")
    public ModelAndView category(@RequestParam(value = "id", defaultValue = "0") String categoryId){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("category");
        Category selectedCategory;
        Collection<Product> categoryProducts;

            // get categoryId from request
            //String categoryId = request.getQueryString();
                if (!categoryId.equals(DEFAULT_CATEGORY)) {

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

    @RequestMapping(value = "/viewCart")
    public String viewCart(@RequestParam(value = "clear", defaultValue = "false") String clear,
                           @ModelAttribute("cart") ShoppingCart cart){
        if ((clear != null) && clear.equals("true")) {
            cart.clear();
        }
        return "cart";
    }

    @RequestMapping(value = "/updateCart")
    public String updateCart(@RequestParam("productId") String productId,
                             @RequestParam("quantity") String quantity,
                             Model model) {

        boolean invalidEntry = validator.validateQuantity(productId, quantity);

        if (!invalidEntry) {
            ShoppingCart cart = (ShoppingCart) model.asMap().get("cart");
            Product product = productService.find(Integer.parseInt(productId));
            cart.update(product, quantity);
        }

        return "cart";
    }

    @RequestMapping(value = "/checkout")
    public String checkout(Model model) {
        ShoppingCart cart = (ShoppingCart) model.asMap().get("cart");
        // calculate total
        cart.calculateTotal(surcharge);
        // forward to checkout page and switch to a secure channel
        return "checkout";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public String addToCart(@RequestParam("productId") String productId, Model model) {
        // if user is adding item to cart for first time
        // create cart object and attach it to user session
        ShoppingCart cart = (ShoppingCart) model.asMap().get("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            model.addAttribute("cart", cart);
        }
        // get user input from request
        if (!productId.isEmpty()) {
            Product product = productService.find(Integer.parseInt(productId));
            cart.addItem(product);
        }
        return  "category";
    }

    @RequestMapping(value = "/ajax", method = RequestMethod.POST)
    public @ResponseBody String ajax(@RequestBody CartForm cartForm){
        return "success again";
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
