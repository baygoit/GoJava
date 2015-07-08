package ua.goit.kyrychok.views;

import ua.goit.kyrychok.common.Console;
import ua.goit.kyrychok.domain.Category;

import java.util.List;

public class ApplicationView {
    private Console console = new Console();

    public void show(String path, List<Category> model) {
        console.writeLine(path);
        for (int counter = 0; counter < model.size(); counter++) {
            Category category = model.get(counter);
            console.writeLine(String.format("[%s]. %s", counter + 1, category.getName()));
        }
    }
}
