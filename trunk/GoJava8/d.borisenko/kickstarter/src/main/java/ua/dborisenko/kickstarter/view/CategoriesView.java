package ua.dborisenko.kickstarter.view;

import java.util.List;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Quote;

public class CategoriesView extends View {

    public CategoriesView(List<Category> categories, Quote quote) {
        addContentString(HEADER_BLOCK);
        addContentString("*** The phrase of the day: ***");
        addContentString("\"" + quote.getText() + "\" " + quote.getAuthor() + ".");
        addContentString(SOLID_LINE);
        addContentString("Project categories list");
        addContentString(SOLID_LINE);
        for (int i = 0; i < categories.size(); i++) {
            addContentString(((i + 1) + ": " + categories.get(i).getName()));
        }
        addContentString(SOLID_LINE);
        addContentString("Enter category number or \"0\" to exit: ");
    }
}
