package ua.goit.kyrychok.models;

import ua.goit.kyrychok.DataProvider;
import ua.goit.kyrychok.domain.Category;

import java.util.List;

public class MainPageModel {
    private List<Category> categories;
    private DataProvider dataProvider;

    public MainPageModel(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void load() {
        categories = dataProvider.getCategories();
    }
}
