package ua.com.goit.gojava1.lslayer.hackit2.dto;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public class ParameterObject { //Used to pass a lot of parameters
    public Actor actor;
    public Gear tool;
    public Gear targetGear;
    public Actor targetActor;
    public int value;
    public Action action;
    
    
    @Override
    public String toString() {
        return "ParameterObject [actor=" + actor + ", tool=" + tool
                + ", targetGear=" + targetGear + ", targetActor=" + targetActor
                + ", value=" + value + ", action=" + action + "]";
    }

    
}
