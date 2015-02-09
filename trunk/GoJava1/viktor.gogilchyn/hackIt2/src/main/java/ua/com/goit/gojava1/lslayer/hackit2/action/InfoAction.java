package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;

public class InfoAction extends AbstractAction implements Action {

    public InfoAction() {
        super("info");
    }

    @Override
    public ActionResult execute() {
        if (super.checkParameters(true, true, true, getParameters()) != null) {
            return new ActionResult(false,
                    checkParameters(true, true, true, getParameters()));
        }
        if (this.getParameters().targetActor != null) {
            return new ActionResult(super.checkSuccess(getParameters()), super.getInfo(
                    this.getParameters().targetActor, this.getParameters().value));
        }
        return new ActionResult(super.checkSuccess(this.getParameters()), this.getParameters().targetGear.getName());

    }

}
