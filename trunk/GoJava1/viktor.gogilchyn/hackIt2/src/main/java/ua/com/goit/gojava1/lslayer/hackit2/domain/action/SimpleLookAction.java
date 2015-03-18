package ua.com.goit.gojava1.lslayer.hackit2.domain.action;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;


public class SimpleLookAction extends AbstractAction {

    public SimpleLookAction() {
        super("look");
    }

    @Override
    public ActionResult execute() throws HackitWrongParameterException {
        if (this.getParameters().targetActor == null && 
                this.getParameters().targetGear == null) {

                throw new HackitWrongParameterException(this.commandToInvoke + " action. Target nedded");
            
            }
        String target = (this.getParameters().targetActor == null) ? 
                this.getParameters().targetGear.getName() : 
                this.getParameters().targetActor.getName();
        return new ActionResult(true, "You examined "+ target + ". Looks simple, yeah?");
    }

}
