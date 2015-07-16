package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataRegistry;
import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.mvc.view.ModelUpdateListener;

import java.util.ArrayList;
import java.util.List;

public class MainPageModel extends AbstractPageModel {

    ModelUpdateListener<MainPageModel> modelUpdateListener;

    private String quote;

    private List<Category> categories = new ArrayList<>();

    public MainPageModel (DataRegistry dataRegistry) {
        super(dataRegistry);
    }

    public String getQuote() {
        return quote;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void update () {
        quote = dataRegistry.getSomeQuote();
        categories = dataRegistry.getCategoriesList();
        modelUpdateListener.onModelUpdate(this);
    }

    public void setModelUpdateListener(ModelUpdateListener<MainPageModel> modelUpdateListener) {
        this.modelUpdateListener = modelUpdateListener;
    }
}
