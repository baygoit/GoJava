package ua.com.goit.gojava1.lslayer.hackit2.action;

import java.util.Map.Entry;
import java.util.Random;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;

public abstract class AbstractAction implements Action {
    protected String commandToInvoke;

    protected AbstractAction(String command) {
        this.commandToInvoke = command;
    }

    protected String getCommand() {
        return this.commandToInvoke;
    }

    protected String checkParameters(boolean actor, boolean tool,
            boolean target, ParameterObject arg) {
        if (actor && arg.actor == null) {
            return "A person needed to " + commandToInvoke;
        }
        if (tool && arg.tool == null) {
            return "A tool needed to " + commandToInvoke;
        }
        if (target && (arg.targetGear == null && arg.targetActor == null)) {
            return "A target needed to " + commandToInvoke;
        }
        if (tool && arg.tool.getPurposeValue(this.getCommand()) == 0) {
            return "Your " + arg.tool.getName() + " can't " + commandToInvoke;
        }
        return null;
    }

    protected boolean checkSuccess(ParameterObject arg) {
        int bonus = 0;
        if (arg.actor != null) {  
            bonus += arg.actor.getSkillValue(commandToInvoke);
        }
        if (arg.tool != null) {
            bonus += arg.tool.getPurposeValue(commandToInvoke); 
        }
        int antibonus = 0;
        if (arg.targetGear != null ) {
            antibonus += arg.targetGear.getPurposeValue(commandToInvoke);
        }
        if (arg.targetActor != null) {
            antibonus += arg.targetActor.getSkillValue(commandToInvoke); 
        }
        return bonus >= antibonus;
    }

    protected String getInfo(Actor target, int percent) {
        if (target == null) return null; 
        final int MAX_PERCENT = 100;
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
}
