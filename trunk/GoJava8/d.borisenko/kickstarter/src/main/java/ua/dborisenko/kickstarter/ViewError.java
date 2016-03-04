package ua.dborisenko.kickstarter;

public class ViewError extends View {
    private Error error;
    
    public ViewError(Error error) {
        this.error = error;
    }

    @Override
    public String generate() {
        drawHeaderBlock();
        System.out.println("ERROR: " + error.getCode());
        System.out.println(error.getName());
        drawDivider();
        System.out.println(error.getDescription());
        drawDivider();
        System.out.println("Press Enter to return.");
        return readInput();
    }
}
