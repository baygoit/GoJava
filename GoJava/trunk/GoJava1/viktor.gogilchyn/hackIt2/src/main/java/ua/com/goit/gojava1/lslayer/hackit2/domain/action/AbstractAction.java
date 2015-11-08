package ua.com.goit.gojava1.lslayer.hackit2.domain.action;

public abstract class AbstractAction implements Action {
    protected String commandToInvoke;
    protected int timeNeededToInvokeAction;
    private ActionParameters parameters = new ActionParameters();

    protected AbstractAction(String command) {
        this.commandToInvoke = command;
    }

    protected String getCommand() {
        return this.commandToInvoke;
    }

    protected int getSuccessChance() {
        int bonus = 0;
        bonus += parameters.actor == null ? 0 : 
            parameters.actor.getSkillValue(this.getCommand());
        bonus += parameters.tool == null ? 0 : 
            parameters.tool.getPurposeValue(this.getCommand());

        int antibonus = 0;
        antibonus += parameters.targetGear == null ? 0 : 
            parameters.targetGear.getPurposeValue(this.getCommand());
        antibonus += parameters.targetActor == null ? 0 : 
            parameters.targetActor.getSkillValue(this.getCommand());

        return bonus - antibonus;
    }

    protected boolean checkSuccess() {
        return (this.getSuccessChance() > 0);
    }


    public ActionParameters getParameters() {
        return parameters;
    }

    public void setParameters(ActionParameters po) {
        this.parameters = po;
    }

    @Override
    public String toString() {
        return "AbstractAction [commandToInvoke=" + commandToInvoke
                + ", timeNeededToInvokeAction=" + timeNeededToInvokeAction
                + ", parameters=" + parameters + "]";
    }

}
