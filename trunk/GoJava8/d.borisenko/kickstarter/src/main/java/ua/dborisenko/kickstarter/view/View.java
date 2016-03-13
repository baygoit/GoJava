package ua.dborisenko.kickstarter.view;

import ua.dborisenko.kickstarter.IoHandler;

public abstract class View {
    protected StringBuilder content = new StringBuilder();
    protected IoHandler ioHandler = new IoHandler();
    protected static final String SOLID_LINE = "─────────────────────────────────────────";
    protected static final String HEADER_BLOCK = 
            "╔═══════════════════════════════════════╗\n"
          + "║              Kickstarter              ║\n" 
          + "╚═══════════════════════════════════════╝";

    protected void addContentString(String inputString) {
        this.content.append(inputString + "\n");
    }

    public String getInput() {
        return ioHandler.read();
    }

    public void showHint(String hint) {
        ioHandler.write(hint + "\n");
    }

    public void show() {
        ioHandler.write(content.toString());
    }
}