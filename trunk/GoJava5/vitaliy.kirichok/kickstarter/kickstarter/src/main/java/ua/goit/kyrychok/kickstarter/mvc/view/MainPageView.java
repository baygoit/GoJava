package ua.goit.kyrychok.kickstarter.mvc.view;

import ua.goit.kyrychok.kickstarter.Output;
import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.mvc.model.MainPageModel;

import java.util.List;

public class MainPageView {
    private Output output;

    public MainPageView(Output output) {
        this.output = output;
    }

    public void render(MainPageModel model) {
        output.writeLine(model.getHelloMessage());
        List<Category> categories = model.getCategories();
        for (int counter = 0; counter < categories.size(); counter++) {
            output.writeLine(String.format("[%s]. %s", counter + 1, categories.get(counter).getName()));
        }
    }
}
