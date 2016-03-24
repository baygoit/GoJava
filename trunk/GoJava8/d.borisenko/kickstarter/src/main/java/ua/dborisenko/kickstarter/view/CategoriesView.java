package ua.dborisenko.kickstarter.view;

import java.util.List;

import ua.dborisenko.kickstarter.domain.Quote;

public class CategoriesView extends View {

    public static final String INPUT_TO_EXIT = "0";

    public void showContent(List<String> categoryNames, Quote quote) {
        content = new StringBuilder();
        addContentString(HEADER_BLOCK);
        addContentString("*** The phrase of the day: ***");
        addContentString("\"" + quote.getText() + "\" " + quote.getAuthor() + ".");
        addContentString(SOLID_LINE);
        addContentString("Project categories list");
        addContentString(SOLID_LINE);
        for (int i = 0; i < categoryNames.size(); i++) {
            addContentString(((i + 1) + ": " + categoryNames.get(i)));
        }
        addContentString(SOLID_LINE);
        addContentString("Enter category number or \"" + INPUT_TO_EXIT + "\" to exit: ");
        ioHandler.writeMessage(content.toString());
    }

    public void showMsgGoodbye() {
        showMessage("Goodbye! Thanks for all the fish.");
    }
}
