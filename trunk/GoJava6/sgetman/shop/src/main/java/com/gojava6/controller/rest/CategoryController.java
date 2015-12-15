/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.controller.rest;

import com.gojava6.entity.Category;
import com.gojava6.entity.Product;
import com.gojava6.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 12/13/15
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Category getCategory(@PathVariable("categoryId") short categoryId) {
        return categoryService.find(categoryId);
    }

    @ResponseBody
    @RequestMapping(value = "/{categoryId}/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Product> getCategoryProducts(@PathVariable("categoryId") short categoryId) {
        return categoryService.find(categoryId).getProducts();
    }

    @ResponseBody
    @RequestMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Category createCategory(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @ResponseBody
    @RequestMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public Category updateCategory(@PathVariable("categoryId") short categoryId, @RequestBody Category category) {
        return categoryService.update(categoryId, category);
    }

}
