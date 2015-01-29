package ua.com.goit.gojava1.lslayer.hackit2;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public abstract class AbstractAction implements Action {
    @Override
    public ActionResult execute(Actor actor) {
        return execute(actor, null);
    }
    @Override
    public ActionResult execute(Actor actor, Gear tool) {
        return execute(actor, tool, null);
    }
    protected String commandToInvoke;
    protected AbstractAction() {
    }
    protected String getCommand() {
        return this.commandToInvoke;
    }
}
