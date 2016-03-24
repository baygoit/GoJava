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

    void showMessage(String message) {
        ioHandler.writeMessage(message + "\n");
    }
    
    public void showError(String error) {
        ioHandler.writeError(SOLID_LINE + "\n");
        ioHandler.writeError("ERROR:\n");
        ioHandler.writeError(error + "\n");
        ioHandler.writeError("Press Enter to return...\n");
        getInput();
    }
}