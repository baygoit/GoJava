package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;

public class InformationAction extends AbstractAction implements Action {

    public InformationAction() {
        super("info");
    }

    @Override
    public ActionResult execute(ParameterObject po) {
        if (super.checkParameters(true, true, true, po) != null) {
            return new ActionResult(false, checkParameters(true, true, true, po));
        }
        return null;
    }

}
