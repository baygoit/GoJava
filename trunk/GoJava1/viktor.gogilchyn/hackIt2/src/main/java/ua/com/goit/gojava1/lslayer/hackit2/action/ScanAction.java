package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public class ScanAction extends AbstractAction implements Action {

    public ScanAction() {
        super.commandToInvoke = "scan";
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
        if (po.tool == null) {
            return new ActionResult(false, "You can't scan with your eyes, try using tools.");
        }
        if (po.target == null) {
            return new ActionResult(false, "You scanned, but recevied no result. Try scan something!");
        }
        if (((Gear) po.tool).getPurposeValue(this.getCommand()) == 0) {
            return new ActionResult(false, "You tried to scan with " + ((Gear) po.tool).getName() + " but it can't do it. Use proper tool");
        }
        int bonus = ((Actor) po.actor).getSkillValue(this.getCommand()) + ((Gear) po.tool).getPurposeValue(this.getCommand());
        int antibonus = ((Gear) po.target).getPurposeValue(this.getCommand());
        boolean succeed = bonus - antibonus > 0;
        ActionResult result = new ActionResult(succeed, 
                succeed ? "You successfully scanned "+ ((Gear) po.target).getName() +". Got new information" :
                          "Unsuccesful scan. You got no new information"
                );
        ParameterObject change = new ParameterObject();
        change.action = "addknowledge";
        change.actor = po.actor;
        change.target = po.target;
        result.addChange(change);
        return result;
    }
}
