package ua.dborisenko.kickstarter.view;

import java.io.PrintWriter;
import java.util.List;

import ua.dborisenko.kickstarter.domain.Category;
import ua.dborisenko.kickstarter.domain.Quote;

public class CategoriesView extends View {

    public void show(PrintWriter writer, List<Category> categories, Quote quote) {
        this.pageTitle = "categories";
        content = new StringBuilder();
        addContentString(getHeaderBlock());
        addContentString("<p>The phrase of the day:<br/>");
        addContentString("\"" + quote.getText() + "\" " + quote.getAuthor() + ".</p>");
        addContentString("<hr>");
        addContentString("Choose the category:");
        addContentString("<ul>");
        for (Category category : categories) {
            addContentString(
                    "<li><a href='?page=category&id=" + category.getId() + "'>" + category.getName() + "</a></li>");
        }
        addContentString("</ul>");
        writer.println(content.toString());
    }
}
