package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MainPageModel extends AbstractModel{

    private String quote;

    private List<String> categories = new ArrayList<>();

    public MainPageModel(DataProvider dataProvider) {
        super(dataProvider);
    }

    public String getQuote() {
        return quote;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void update(int... parameters) {
        quote = dataProvider.getSomeQuote();
        List<Category> categories = dataProvider.getCategoriesList();
        this.categories.clear();
        for (Category c : categories) {
            this.categories.add(c.getName());
        }
    }
}
