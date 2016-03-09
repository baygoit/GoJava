package ua.dborisenko.kickstarter;

import java.util.List;

public class ViewCategories extends View {
    private Quote quote;
    private List<Category> categories;

    public ViewCategories(List<Category> inputCategories, Quote inputQuote) {
        categories = inputCategories;
        quote = inputQuote;
    }

    @Override
    public void generate() {
        addContentString(headerBlock);
        addContentString("*** The phrase of the day: ***");
        addContentString("\"" + quote.getText() + "\" " + quote.getAuthor() + ".");
        addContentString(solidLine);
        addContentString("Project categories list");
        addContentString(solidLine);
        for (int i = 0; i < this.categories.size(); i++) {
            addContentString(((i + 1) + ": " + categories.get(i).getName()));
        }
        addContentString(solidLine);
        addContentString("Enter category number or select \"0\" to exit: ");
        ioHandler.write(content.toString());
     }
}
