package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;

public class InfoAction extends AbstractAction implements Action {

    public InfoAction() {
        super("info");
    }

    @Override
    public ActionResult execute() throws HackitWrongParameterException {
        if (this.getParameters().actor == null) throw new HackitWrongParameterException(this.commandToInvoke + " action. Actor needed");
        if (this.getParameters().targetActor == null) throw new HackitWrongParameterException(this.commandToInvoke + " action. TargetActor nedded");
        if (this.getParameters().tool == null) throw new HackitWrongParameterException(this.commandToInvoke + " action. Tool needed");
        return new ActionResult(super.checkSuccess(), super.getInfo());
//        return new ActionResult(super.checkSuccess(), this.getParameters().targetActor.getName()); //TODO: Hardcoded result
    }

}
