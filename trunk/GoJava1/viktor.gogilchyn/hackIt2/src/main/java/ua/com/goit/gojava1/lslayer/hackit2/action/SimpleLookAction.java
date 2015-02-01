package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public class SimpleLookAction extends AbstractAction {

    public SimpleLookAction() {
        super("look");
    }

    @Override
    public ActionResult execute(ParameterObject po) {
        if (po.target == null) {
            return new ActionResult(true, "You examined the universe. Looks simple, yeah?");
        }
        return new ActionResult(true, "You examined " + ((Gear) po.target).getName() + ". Looks simple, yeah?");
    }

}
