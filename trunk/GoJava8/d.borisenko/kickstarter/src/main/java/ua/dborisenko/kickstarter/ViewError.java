package ua.dborisenko.kickstarter;

public class ViewError extends View {
    private Error error;
    
    public ViewError(Error error) {
        this.error = error;
    }

    @Override
    public void generate() {
        addContentString(headerBlock);
        addContentString("ERROR: " + error.getCode());
        addContentString(error.getName());
        addContentString(solidLine);
        addContentString(error.getDescription());
        addContentString(solidLine);
        addContentString("Press Enter to return.");
        ioHandler.write(content.toString());
    }
}
