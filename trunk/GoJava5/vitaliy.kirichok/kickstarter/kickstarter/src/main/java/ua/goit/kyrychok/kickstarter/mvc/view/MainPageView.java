package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.mvc.model.MainPageModel;

import java.util.List;

public class MainPageView extends BaseView {

    public void render(MainPageModel model) {
        writeLine(model.getWelcomeMessage());
        List<Category> categories = model.getCategories();
        for (int counter = 0; counter < categories.size(); counter++) {
            writeLine(String.format("[%s]. %s", counter + 1, categories.get(counter).getName()));
        }
        writeLine(CHOICE_MESSAGE);
    }

}
