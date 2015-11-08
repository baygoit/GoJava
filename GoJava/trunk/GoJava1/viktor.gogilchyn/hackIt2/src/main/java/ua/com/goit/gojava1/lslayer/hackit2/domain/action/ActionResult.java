package ua.com.goit.gojava1.lslayer.hackit2.domain.action;

import java.util.LinkedList;

public class ActionResult { // May be it will be initialized using constructor.
                            // It's "parameter Object" and have no sense without
                            // data
    private boolean success;
    private String succesMessage;
    private String failMessage;
    private LinkedList<ActionParameters> changes = new LinkedList<ActionParameters>();

    public void addChange(ActionParameters what) {
        if (what != null)
            changes.add(what);
    }

    public ActionParameters getNextChange() {
        return changes.pollLast(); // Return PO or null;
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

    public ActionResult() {

    }

    public boolean isSuccess() {
        return success;
    }

}
