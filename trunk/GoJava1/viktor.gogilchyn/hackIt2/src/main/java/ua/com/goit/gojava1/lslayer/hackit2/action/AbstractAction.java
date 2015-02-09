package ua.com.goit.gojava1.lslayer.hackit2.action;

import java.util.Map.Entry;
import java.util.Random;

import org.apache.log4j.Logger;
import ua.com.goit.gojava1.lslayer.hackit2.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionParameters;

public abstract class AbstractAction implements Action {
    static Logger log = Logger.getLogger(AbstractAction.class);
    protected String commandToInvoke;
    protected int timeNeededToInvokeAction;
    private ActionParameters parameters = new ActionParameters();

    protected AbstractAction(String command) {
        this.commandToInvoke = command;
    }

    protected String getCommand() {
        return this.commandToInvoke;
    }

    protected int getSuccessChance () throws HackitWrongParameterException {
    int bonus = 0;
        bonus += parameters.actor == null ? 0: parameters.actor.getSkill(commandToInvoke);
        bonus += parameters.tool == null ? 0: parameters.tool.getPurposeValue(commandToInvoke);
    int antibonus = 0;
        antibonus += parameters.targetGear == null ? 0: parameters.targetGear.getPurposeValue(commandToInvoke);
        antibonus += parameters.targetActor == null ? 0: parameters.targetActor.getSkill(commandToInvoke);
        
        return bonus - antibonus;
    }
    

    protected boolean checkSuccess() {
        try {
            return (this.getSuccessChance() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    protected String getInfo() {
//        if (target == null) return null; All checks is made before here 
        final int MAX_PERCENT = 100;
        Actor target = this.parameters.targetActor;
        int percent = this.parameters.value;
        String eol = System.getProperty("line.separator");
        String result = "";
        String unknown = "?????";
        Random rand = new Random();
        for (Entry<String, String> entry : target.getAttributes().entrySet()) {
            int randomNum = rand.nextInt((MAX_PERCENT - 1) + 1) + 1;
            result += entry.getKey() + ": ";
            if (randomNum <= percent) {
                result += entry.getValue();
            } else {
                result += unknown;
            }
            result += eol;
        }
        return result;
    }

    public ActionParameters getParameters() {
        return parameters;
    }

    public void setParameters(ActionParameters po) {
        this.parameters = po;
    }
}
