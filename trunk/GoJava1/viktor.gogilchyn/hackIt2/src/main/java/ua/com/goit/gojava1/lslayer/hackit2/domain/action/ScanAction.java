package ua.com.goit.gojava1.lslayer.hackit2.domain.action;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;


public class ScanAction extends AbstractAction implements Action {

    public ScanAction() {
        super("scan");
    }

    @Override
    public ActionResult execute() throws HackitWrongParameterException {
        /* Every action works in this way:
         * 1. Gather skill bonuses from actor and tool.
         * 2. Gather anti-skill bonuses from target
         * 3. If bonuses more then anti-bonuses - succeed else - fail 
         * 4. Formatting ResultMesage
         * 5. Making changes (if necessary) to possession and control lists. 
         */
        if (this.getParameters().actor == null) throw new HackitWrongParameterException(this.commandToInvoke + " action. Actor needed");
        if (this.getParameters().tool == null) throw new HackitWrongParameterException(this.commandToInvoke + " action. Tool needed");
        if (this.getParameters().targetGear == null) throw new HackitWrongParameterException(this.commandToInvoke + " action. TargetGear needed");
        
        boolean succeed = super.checkSuccess();
        ActionResult result = new ActionResult(succeed, 
                succeed ? "You successfully scanned "+ this.getParameters().targetGear.getName() +". Got new information" :
                          "Unsuccesful scan. You got no new information"
                );
        return result; //TODO: Hardcoded result
    }
}
