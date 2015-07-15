package ua.goit.kyrychok.kickstarter.mvc.model;

import ua.goit.kyrychok.kickstarter.DataProvider;
import ua.goit.kyrychok.kickstarter.model.Category;

import java.util.List;


public class MainPageModel {
    private DataProvider dataProvider;
    private List<Category> categories;

    public MainPageModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String getHelloMessage() {
        return dataProvider.getHelloMessage();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void update() {
        categories = dataProvider.getCategories();
    }

    public int getCount() {
        return categories.size();
    }
}
