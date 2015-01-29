package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Devices.ScanDevice;

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
        session.addStuff(new ScanDevice("Vizor3000"));
        session.addStuff(new ScanDevice("Vizor2000"));
        session.addStuff(new ScanDevice("Vizor1000"));
        assertEquals("Stuff list:" + eol + "Vizor3000"
                + eol + "Vizor2000"
                + eol + "Vizor1000", 
                session.displayStuffList());
    }
}
