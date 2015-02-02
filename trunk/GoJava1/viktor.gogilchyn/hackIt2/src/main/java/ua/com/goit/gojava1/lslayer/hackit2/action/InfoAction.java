package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;

public class InfoAction extends AbstractAction implements Action {

    public InfoAction() {
        super("info");
    }

    @Override
    public ActionResult execute(ParameterObject po) {
        if (super.checkParameters(true, true, true, po) != null) {
            return new ActionResult(false,
                    checkParameters(true, true, true, po));
        }
        if (po.targetActor != null) {
            return new ActionResult(super.checkSuccess(po), super.getInfo(
                    po.targetActor, po.value));
        }
        return new ActionResult(super.checkSuccess(po), po.targetGear.getName());

    }

}
