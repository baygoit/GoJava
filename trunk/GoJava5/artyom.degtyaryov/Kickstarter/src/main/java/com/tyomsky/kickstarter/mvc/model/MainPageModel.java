package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainPageModel {

    private DataProvider dataProvider;
    private String quote;
    private List<Category> categories = new ArrayList<>();

    public MainPageModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String getQuote() {
        return quote;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void update() {
        quote = dataProvider.getSomeQuote();
        categories = dataProvider.getCategoriesList();

    }

}
