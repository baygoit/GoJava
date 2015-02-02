package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;

public class SimpleExplosionAction extends AbstractAction implements Action {

    public SimpleExplosionAction() {
        super("explode");
    }

    @Override
    public ActionResult execute(ParameterObject po) {
        if (super.checkParameters(false, true, true, po) != null) {
            return new ActionResult(false, checkParameters(false, true, true, po));
        }
        if (po.targetGear != null) { //If targetActor and targetGear both set, priority is to Gear.
            return new ActionResult(super.checkSuccess(po), po.targetGear.getName() + " exploded!");
        } 
        return new ActionResult(super.checkSuccess(po), po.targetActor.getName() + " exploded!");
    }

}
