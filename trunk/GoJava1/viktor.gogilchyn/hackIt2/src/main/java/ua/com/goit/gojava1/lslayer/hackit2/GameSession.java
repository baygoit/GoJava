package ua.com.goit.gojava1.lslayer.hackit2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.dao.ActorDAO;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitEcxeptionForUI;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;

public final class GameSession { // Singleton. There is only one game per app.
    // Multithreading ignored for a while

    private static GameSession instance = new GameSession();

    public static GameSession getInstance() {
        return GameSession.instance;
    }

    private LinkedList<Map<Actor, Action>> actionQueue = new LinkedList<Map<Actor, Action>>();
    private List<Actor> gamers = new ArrayList<Actor>();
    private Map<Actor, ActionResult> resultsQueue = new LinkedHashMap<Actor, ActionResult>();

    private List<Gear> stuff = new ArrayList<Gear>();

    private GameSession() {
        ActorDAO dao = new ActorDAO();
        try {
            this.gamers = dao.loadAll();
        } catch (HackitEcxeptionForUI e) {
        }
    }

    public void addAction(Actor whoActs, Action whatToDo)
            throws HackitWrongParameterException { // This method called from
        // above

        if (whoActs == null) {
            throw new HackitWrongParameterException("Nobody can't act!");
        }

        if (whatToDo == null) {
            throw new HackitWrongParameterException("No action provided!");
        }

        Map<Actor, Action> currentElement;
        currentElement = new LinkedHashMap<Actor, Action>();
        currentElement.put(whoActs, whatToDo);

        this.actionQueue.add(currentElement);
    }

    public void addGamer(Actor gamer) throws HackitWrongParameterException {
        if (gamer == null) {
            throw new HackitWrongParameterException("Where is actor?");
        }
        this.gamers.add(gamer);
    }

    public void addStuff(Gear item) throws HackitWrongParameterException {
        if (item == null) {
            throw new HackitWrongParameterException("Where is item?");
        }
        this.stuff.add(item);
    }

    public String displayStuffList() {
        String eol = System.getProperty("line.separator");
        String result = "Stuff list:";
        for (Gear element : this.stuff) {
            result += eol + element.getStringForOutput();
        }
        return result;
    }

    public List<Actor> getGamers() {
        return this.gamers;
    }

    public ActionResult getResult(Actor a) {
        return this.resultsQueue.get(a);
    }

    public void goTick() throws HackitWrongParameterException {
        // Going through all actors, find their actions, and run each
        for (Actor currentActor : this.getGamers()) {
            for (Map<Actor, Action> currentAction : this.actionQueue) {
                if (currentAction.get(currentActor) != null) {
                    try {
                        this.resultsQueue.put(currentActor, currentActor
                                                                        .act(currentAction.get(currentActor)));
                    } catch (HackitWrongParameterException e) {
                        throw new HackitWrongParameterException(e.getMessage(),
                                                                e);
                    }
                }
            }
        }
    }
}
