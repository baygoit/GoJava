package ua.goit.kyrychok.views;

import ua.goit.kyrychok.common.Output;
import ua.goit.kyrychok.domain.Category;
import ua.goit.kyrychok.models.MainPageModel;

import java.util.List;

public class MainPageView {
    private Output output;

    public MainPageView(Output output) {
        this.output = output;
    }

    public void show(MainPageModel model) {
        List<Category> categories = model.getCategories();
        Category category;
        for (int counter = 0; counter < categories.size(); counter++) {
            category = categories.get(counter);
            output.show(String.format("[%s]. %s", counter + 1, category.getName()));
        }
    }
}
