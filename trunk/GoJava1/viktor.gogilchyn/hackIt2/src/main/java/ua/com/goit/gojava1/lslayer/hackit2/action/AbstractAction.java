package ua.com.goit.gojava1.lslayer.hackit2.action;

public abstract class AbstractAction implements Action {
    protected String commandToInvoke;
    protected AbstractAction() {
    }
    protected String getCommand() {
        return this.commandToInvoke;
    }
}
