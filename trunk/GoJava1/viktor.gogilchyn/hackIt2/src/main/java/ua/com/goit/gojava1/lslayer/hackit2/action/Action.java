package ua.com.goit.gojava1.lslayer.hackit2.action;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;

public interface Action {
    public ActionResult execute();
    public void setParameters(ParameterObject po);
    public ParameterObject getParameters(); 
}
