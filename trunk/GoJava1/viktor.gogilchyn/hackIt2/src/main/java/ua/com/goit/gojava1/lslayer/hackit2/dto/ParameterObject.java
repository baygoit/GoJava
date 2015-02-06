package ua.com.goit.gojava1.lslayer.hackit2.dto;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public class ParameterObject { //Used to pass a lot of parameters to Action
    public Actor actor;
    public Gear tool;
    public Gear targetGear;
    public Actor targetActor;
    public int value;
    public String action; //MS-style. Reserved for future use. 
    @Override
    public String toString() {
        return "ParameterObject [actor=" + actor + ", tool=" + tool
                + ", targetGear=" + targetGear + ", targetActor=" + targetActor
                + ", value=" + value + ", action=" + action + "]";
    }
}
