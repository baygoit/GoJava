package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.domain.GameSession;
import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.SimpleLookAction;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.ScanDevice;

public class GameSessionTest {

    @Test
    public void testCreation() {
        GameSession session = GameSession.getInstance();
        assertNotNull(session);
    }
    
    @Test
    public void testStuffList() {
        GameSession session = GameSession.getInstance();
        String eol = System.getProperty("line.separator");
        try {
            session.addStuff(new ScanDevice("Vizor3000"));
            session.addStuff(new ScanDevice("Vizor2000"));
            session.addStuff(new ScanDevice("Vizor1000"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Stuff list:" + eol + "Vizor3000"
                + eol + "Vizor2000"
                + eol + "Vizor1000", 
                session.displayStuffList());
    }
    
    @Test(expected=HackitWrongParameterException.class)
    public void testGameSessionWrongStuffException() throws Exception {
        GameSession session = GameSession.getInstance();
        session.addStuff(null);
    }
    
    @Test
    public void testGameSessionWrongActionException() {
        GameSession session = GameSession.getInstance();
        try {
            session.addAction(null, new SimpleLookAction());
        } catch (HackitWrongParameterException e) {
            assertEquals("Nobody can't act!", e.getMessage());
        }

        try {
            session.addAction(new HumanControlledCharacter("MeMe"), null);
        } catch (HackitWrongParameterException e) {
            assertEquals("No action provided!", e.getMessage());
        }
    }
    
    @Test
    public void testWrongActorAddition() {
        GameSession session = GameSession.getInstance();
        try {
            session.addGamer(null);
        } catch (HackitWrongParameterException e) {
            assertEquals("Where is actor?", e.getMessage());
        }
    }
}
