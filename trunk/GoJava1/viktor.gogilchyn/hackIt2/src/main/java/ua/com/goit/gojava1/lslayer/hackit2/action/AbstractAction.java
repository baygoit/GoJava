package ua.com.goit.gojava1.lslayer.hackit2.action;

import java.util.Map.Entry;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;

public abstract class AbstractAction implements Action {
    static Logger log = Logger.getLogger(AbstractAction.class);
    protected String commandToInvoke;
    protected int timeNeededToInvokeAction;

    protected AbstractAction(String command) {
        this.commandToInvoke = command;
    }

    protected String getCommand() {
        return this.commandToInvoke;
    }

    //TODO Rewrite. I don't like such "gvozdyami pribity" method 
    protected String checkParameters(boolean actor, boolean tool,
            boolean target, ParameterObject arg) { 
        if (actor && arg.actor == null) {
            return "A person needed to " + commandToInvoke;
        }
        if (tool && arg.tool == null) {
            return "A tool needed to " + commandToInvoke;
        }
        if (target && (arg.targetGear == null && arg.targetActor == null)) {
            PropertyConfigurator.configure("log4j.properties");
            log.debug(arg);
            return "A target needed to " + commandToInvoke;
        }
        if (tool && arg.tool.getPurposeValue(this.getCommand()) == 0) {
            return "Your " + arg.tool.getName() + " can't " + commandToInvoke;
        }
        return null;
    }

    protected boolean checkSuccess(ParameterObject arg) {
        int bonus = 0;
            bonus += arg.actor == null ? 0: arg.actor.getSkill(commandToInvoke);
            bonus += arg.tool == null ? 0: arg.tool.getPurposeValue(commandToInvoke);
        int antibonus = 0;
            antibonus += arg.targetGear == null ? 0: arg.targetGear.getPurposeValue(commandToInvoke);
            antibonus += arg.targetActor == null ? 0: arg.targetActor.getSkill(commandToInvoke);
        return bonus >= antibonus;
    }

    protected String getInfo(Actor target, int percent) {
//        if (target == null) return null; All checks is made before here 
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
