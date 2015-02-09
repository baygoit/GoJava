package ua.com.goit.gojava1.lslayer.hackit2.actor;

import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;

public interface Actor {

    //Accessors part
    public int    getSkill(String skillName);
    public void   addSkill(String string);
    public void   incSkill(String skillName, int value);
    public void   addAttribute(String what, String value);
    public String getAttribute(String what);
    
    //UI part
    public String getName();
    public Map<String, Integer> getSkills();
    public Map<String, String> getAttributes();
    public String getStringForOutput();
    
    //Game part
    public ActionResult act(Action whatToDo) throws HackitWrongParameterException;
}
