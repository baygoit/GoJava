package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.InfoAction;
import ua.com.goit.gojava1.lslayer.hackit2.action.ScanAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.BombDevice;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.InfoDevice;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.ScanDevice;

public class MultiplayerTest {
    @Test
    public void testMultiplay() {
        GameSession session = GameSession.getInstance();
        ActionParameters infoPo = new ActionParameters();
        ActionParameters scanPo = new ActionParameters();
        Actor gamerWantedToInfo = new HumanControlledCharacter("Gamer1");
        Actor gamerWantedToScan = new HumanControlledCharacter("Gamer2");
        Action infoAction = new InfoAction();
        Action scanAction = new ScanAction();
        try {
            infoPo.targetActor = new HumanControlledCharacter("MegaPihar");
            scanPo.targetGear = new BombDevice("TargetName");
            scanPo.tool = new ScanDevice("Scanner");
            infoPo.tool = new InfoDevice("Informator");
            scanAction.setParameters(scanPo);
            session.addGamer(gamerWantedToScan);
            session.addAction(gamerWantedToScan, scanAction);
            session.addGamer(gamerWantedToInfo);
            infoAction.setParameters(infoPo);
            session.addAction(gamerWantedToInfo, infoAction);
        } catch (HackitWrongParameterException e) {
            fail("No exceptions expected");
        }
        try {
            session.goTick();
        } catch (HackitWrongParameterException e) {
            fail("No exceptions expected");
        }
        ActionResult res2 = session.getResult(gamerWantedToScan);
        assertEquals("You successfully scanned TargetName. Got new information", res2.getResultMessage());
        ActionResult res1 = session.getResult(gamerWantedToInfo);
        //Target actor has no attributes, so info action result should be empty
        assertEquals("", res1.getResultMessage());
        
        //Testing exception during tick
        scanPo.tool = null;
        scanAction.setParameters(scanPo);
        try {
            session.addAction(gamerWantedToScan, scanAction);
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        try {
            session.goTick();
        } catch (HackitWrongParameterException e) {
            assertEquals("scan action. Tool needed", e.getMessage());
        }
    }
    
    @Test
    public void testExceptionDuringMultiplay() {
    }

}
