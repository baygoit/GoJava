package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;

public class ScanAction extends AbstractAction implements Action {

    public ScanAction() {
        super("scan");
    }

    @Override
    public ActionResult execute(ParameterObject po) {
        /* Every action works in this way:
         * 1. Gather skill bonuses from actor and tool.
         * 2. Gather anti-skill bonuses from target
         * 3. If bonuses more then anti-bonuses - succeed else - fail 
         * 4. Formatting ResultMesage
         * 5. Making changes (if necessary) to possession and control lists. 
         */
        if (super.checkParameters(true, true, true, po) != null) {
            return new ActionResult(false, checkParameters(true, true, true, po));
        }
        boolean succeed = super.checkSuccess(po);
        ActionResult result = new ActionResult(succeed, 
                succeed ? "You successfully scanned "+ po.targetGear.getName() +". Got new information" :
                          "Unsuccesful scan. You got no new information"
                );
        ParameterObject change = new ParameterObject();
        change.actor = po.actor;
        change.targetGear = po.targetGear;
        result.addChange(change);
        return result;
    }
}
