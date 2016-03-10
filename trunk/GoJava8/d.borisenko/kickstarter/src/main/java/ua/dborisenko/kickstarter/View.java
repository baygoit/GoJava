package ua.dborisenko.kickstarter;

public abstract class View {

    protected StringBuilder content = new StringBuilder(); 
    protected IoHandler ioHandler = new IoHandler();;
    protected String solidLine = "─────────────────────────────────────────";
    protected String headerBlock = 
            "╔═══════════════════════════════════════╗\n" + 
            "║              Kickstarter              ║\n" + 
            "╚═══════════════════════════════════════╝"; 
    protected void addContentString(String inputString) {
        this.content.append(inputString + System.getProperty("line.separator"));
    }
    
    public String getInput() {
        return ioHandler.read();
    }
    
    public void generate() {
    }
}

