package ua.com.goit.gojava1.lslayer.hackit2;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public class ScanAction extends AbstractAction implements Action {

    protected ScanAction() {
        super.commandToInvoke = "scan";
    }

    @Override
    public ActionResult execute(Actor actor, Gear tool, Gear target) {
        /* Every action works in this way:
         * 1. Gather skill bonuses from actor and tool.
         * 2. Gather anti-skill bonuses from target
         * 3. If bonuses more then anti-bonuses - succeed else - fail 
         * 4. Formatting ResultMesage
         * 5. Making changes (if necessary) to possession and control lists. 
         */
        if (tool == null) {
            return new ActionResult(false, "You can't scan with your eyes, try using tools.");
        }
        if (target == null) {
            return new ActionResult(false, "You scanned, but recevied no result. Try scan something!");
        }
        if (tool.getPurposeValue(this.getCommand()) == 0) {
            return new ActionResult(false, "You tried to scan with " + tool.getName() + " but it can't do it. Use proper tool");
        }
        int bonus = actor.getSkillValue(this.getCommand()) + tool.getPurposeValue(this.getCommand());
        int antibonus = target.getPurposeValue(this.getCommand());
        boolean succeed = bonus - antibonus > 0;
        return new ActionResult(succeed, 
                succeed ? "You successfully scanned "+ target.getName() +". Got new information" :
                          "Unsuccesful scan. You got no new information"
                );
    }

}
