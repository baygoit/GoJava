package ua.com.goit.gojava1.lslayer.hackit2.dto;

import java.util.LinkedList;

public class ActionResult { //May be it will be initialized using constructor. 
                            //It's "parameter Object" and have no sense without data 
    private boolean success;
    private String succesMessage;
    private String failMessage;
    private LinkedList<ParameterObject> changes = new LinkedList<ParameterObject>();
    
    public void addChange(ParameterObject what) {
        if (what != null) changes.add(what);
    }
    
    public ParameterObject getNextChange() {
        return changes.pollLast(); //Return PO or null;
    }

    public String getResultMessage() { 
        return this.success ? this.succesMessage : failMessage;
    }
    
    public ActionResult(boolean success, String resultMessage) {
        super();
        this.success = success;
        if (success) { 
            succesMessage = resultMessage;
        } else {
            failMessage = resultMessage;
        }
    }

    public boolean isSuccess() {
        return success;
    }

}
