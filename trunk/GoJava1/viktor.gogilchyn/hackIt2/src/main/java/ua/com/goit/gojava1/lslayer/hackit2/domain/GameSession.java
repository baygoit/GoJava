package ua.com.goit.gojava1.lslayer.hackit2.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.com.goit.gojava1.lslayer.hackit2.common.ConfigurationProvider;
import ua.com.goit.gojava1.lslayer.hackit2.dao.ActorJDBCDAO;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.ActorFactory;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.Gear;


public final class GameSession { // Singleton. There is only one game per app.

    private static GameSession instance;
    private static AnnotationConfigApplicationContext gameContext = null;
    private static ActorJDBCDAO dao = null;

    public static GameSession getInstance() {
            if (GameSession.instance == null) {
                instance = new GameSession();
        }
        return GameSession.instance;
    }

    private LinkedList<Map<Actor, Action>> actionQueue = new LinkedList<Map<Actor, Action>>();
    private List<Actor> gamers = new ArrayList<Actor>();
    private Map<Actor, ActionResult> resultsQueue = new LinkedHashMap<Actor, ActionResult>();

    private List<Gear> stuff = new ArrayList<Gear>();

    private GameSession() {
        gameContext = new AnnotationConfigApplicationContext();
        gameContext.register(ActorJDBCDAO.class);
        gameContext.register(ActorFactory.class);
        gameContext.register(ConfigurationProvider.class);
        gameContext.refresh();
        dao = (ActorJDBCDAO) gameContext.getBean("getActorJDBCDAO");
    }
    
    public List<Actor> getRegisteredGamers() throws HackitIOException {
        return dao.loadAll();
    }
    
    public Actor getRegisteredActor(long id) throws HackitIOException {
        return dao.load(id);
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

    public void deleteRegisteredActor(long id) throws HackitIOException {
        dao.delete(id);
    }

    public void registerActor(Actor createActor) throws HackitIOException {
        dao.save(createActor);
    }
}
