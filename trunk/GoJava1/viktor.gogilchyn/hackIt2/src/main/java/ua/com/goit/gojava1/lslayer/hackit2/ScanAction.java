package ua.com.goit.gojava1.lslayer.hackit2;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.exceptions.SkillUninitilizedException;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public class ScanAction extends AbstractAction implements Action {

    protected ScanAction() {
        super.commandToInvoke = "scan";
    }

    @Override
    public ActionResult performAction(Actor actor) throws SkillUninitilizedException {
        //Basic action - scan nothing. 
        //If actor have skill for scanning - action will succeed
        //Otherwise action will fail
        boolean succeed = actor.skillValue(this.getCommand()) > 0;
        return new ActionResult(succeed, "Scan " + (succeed ? "successful" : "failed"));
    }

    @Override
    public ActionResult performAction(Actor actor, Gear gear) throws SkillUninitilizedException {
        // TODO Auto-generated method stub
        return this.performAction(actor);
    }
    

}
