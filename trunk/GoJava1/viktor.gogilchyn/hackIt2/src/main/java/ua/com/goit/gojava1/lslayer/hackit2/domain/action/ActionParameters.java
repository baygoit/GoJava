package ua.com.goit.gojava1.lslayer.hackit2.domain.action;

import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.Gear;


public class ActionParameters { //Used to pass a lot of parameters
    public Actor actor;
    public Gear tool;
    public Gear targetGear;
    public Actor targetActor;
    public int value;
    
    
    @Override
    public String toString() {
        return "ActionParamters [actor=" + actor + ", tool=" + tool
                + ", targetGear=" + targetGear + ", targetActor=" + targetActor
                + ", value=" + value + "]";
    }
    
    
  
}
