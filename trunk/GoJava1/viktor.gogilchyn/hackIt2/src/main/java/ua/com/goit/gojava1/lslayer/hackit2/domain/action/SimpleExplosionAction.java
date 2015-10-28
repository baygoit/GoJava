package ua.com.goit.gojava1.lslayer.hackit2.domain.action;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;


public class SimpleExplosionAction extends AbstractAction implements Action {

    public SimpleExplosionAction() {
        super("explode");
    }

    @Override
    public ActionResult execute() throws HackitWrongParameterException {
        if (this.getParameters().tool == null)
            throw new HackitWrongParameterException(this.commandToInvoke
                    + " action. Tool needed");
        if (this.getParameters().targetActor == null
                && this.getParameters().targetGear == null) {

            throw new HackitWrongParameterException(this.commandToInvoke
                    + " action. Target needed");

        }
        String target = (this.getParameters().targetActor == null) ? this
                .getParameters().targetGear.getName()
                : this.getParameters().targetActor.getName();
        String resultMessage = (super.checkSuccess()) ? target + " exploded!"
                : target + " stay alive!";
        return new ActionResult(super.checkSuccess(), resultMessage);
    }

}
