package ua.goit.kyrychok.kickstarter.view;

import ua.goit.kyrychok.kickstarter.model.Categories;
import ua.goit.kyrychok.kickstarter.model.Category;

import java.util.List;

public class MainPageView extends BaseView {

    public void render(Categories model, String welcomeMessage) {
        writeLine(welcomeMessage);
        List<Category> categories = model.getCategories();
        for (int counter = 0; counter < categories.size(); counter++) {
            writeLine(String.format("[%s]. %s", counter + 1, categories.get(counter).getName()));
        }
        writeLine(CHOICE_MESSAGE);
    }

}
