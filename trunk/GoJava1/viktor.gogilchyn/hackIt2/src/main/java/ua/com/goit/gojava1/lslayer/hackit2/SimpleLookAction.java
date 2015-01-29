package ua.com.goit.gojava1.lslayer.hackit2;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public class SimpleLookAction extends AbstractAction {

    @Override
    public ActionResult execute(Actor actor, Gear tool, Gear target) {
        if (target == null) {
            return new ActionResult(true, "You examined the universe. Looks simple, yeah?");
        }
        return new ActionResult(true, "You examined " + target.getName() + ". Looks simple, yeah?");
    }

}
