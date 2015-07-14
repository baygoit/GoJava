package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainPageModel {

    private DataProvider dataProvider;
    private String quote;
    private List<String> categories = new ArrayList<>();

    public MainPageModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String getQuote() {
        return quote;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void update() {
        quote = dataProvider.getSomeQuote();
        List<Category> categories = dataProvider.getCategoriesList();
        this.categories.clear();
        for (Category c : categories) {
            this.categories.add(c.getName());
        }
    }

}
