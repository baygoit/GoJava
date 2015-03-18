package ua.com.goit.gojava1.lslayer.hackit2.domain.actor;


import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.ActionResult;


public interface Actor {
    
    //UI part
    public String getName();
    public long   getId();
    public int    getSkillValue(String skillName);
    public String getAttributeValue(String attribute);
    
    //Game part
    public ActionResult act(Action whatToDo) throws HackitWrongParameterException;
}
