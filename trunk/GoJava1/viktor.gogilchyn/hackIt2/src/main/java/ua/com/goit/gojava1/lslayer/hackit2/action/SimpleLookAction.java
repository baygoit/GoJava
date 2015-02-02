package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;

public class SimpleLookAction extends AbstractAction {

    public SimpleLookAction() {
        super("look");
    }

    @Override
    public ActionResult execute(ParameterObject po) {
        if (super.checkParameters(true, false, true, po) != null) {
            return new ActionResult(false, super.checkParameters(true, false, false, po));
        }
        return new ActionResult(true, "You examined "+ po.targetGear.getName() + ". Looks simple, yeah?");
    }

}
