package ua.dborisenko.kickstarter.view;

import ua.dborisenko.kickstarter.domain.Error;

public class ErrorView extends View {

    public ErrorView(Error error) {
        addContentString(HEADER_BLOCK);
        addContentString("ERROR: " + error.getCode());
        addContentString(error.getName());
        addContentString(SOLID_LINE);
        addContentString(error.getDescription());
        addContentString(SOLID_LINE);
        addContentString("Press Enter to return.");
    }
}
