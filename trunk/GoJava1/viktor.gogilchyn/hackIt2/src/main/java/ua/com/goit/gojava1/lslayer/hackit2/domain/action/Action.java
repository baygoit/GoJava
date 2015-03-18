package ua.com.goit.gojava1.lslayer.hackit2.domain.action;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;


public interface Action {
    public ActionResult execute() throws HackitWrongParameterException;
    public void setParameters(ActionParameters po);
    public ActionParameters getParameters(); 
}
