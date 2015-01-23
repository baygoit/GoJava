package ua.com.goit.gojava1.lslayer.hackit2;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public interface Action {
    public ActionResult performAction(Actor actor);
    public ActionResult performAction(Actor actor, Gear gear);
}
