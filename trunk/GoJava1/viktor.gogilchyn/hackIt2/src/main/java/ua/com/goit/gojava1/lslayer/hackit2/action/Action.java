package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;

public interface Action {
    public ActionResult execute() throws HackitWrongParameterException;
    public void setParameters(ActionParameters po);
    public ActionParameters getParameters(); 
}
