package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.ScanAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.BombDevice;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.ScanDevice;

public class ScanDeviceTest {
    @Test
    public void testCreation() throws HackitWrongParameterException {
        ScanDevice scanner = new ScanDevice("Vizor3000");
        assertEquals("Vizor3000", scanner.getName());
        assertEquals("AbstractUtility [name=Vizor3000, purpose={scan=1}]", scanner.toString());
    }
    @Test
    public void testViewOfScanner() throws HackitWrongParameterException {
        ScanDevice scanner = new ScanDevice("Vizor3000");
        try {
            scanner.addPurpose("scan", 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String eol = System.getProperty("line.separator");
        assertEquals("Vizor3000", scanner.getStringForOutput());
        scanner.addParameter("cpu", 100);
        assertEquals("Vizor3000"+ eol +"cpu: 100", scanner.getStringForOutput());
    }
    @Test
    public void testUseOfDeviceWrongWay() {
        //Init section
        ActionParameters po = new ActionParameters();
        Actor actor = new HumanControlledCharacter("MegaPihar");
        actor.addSkill("scan");
        Gear scanner = null;
        try {
            scanner = new ScanDevice("ScanMaster22000").addPurpose("scan", 100);
        } catch (HackitWrongParameterException e) {
            fail("unexpected exception");
        }
        Action action = new ScanAction();
        //Use section
        action.setParameters(po);
        @SuppressWarnings("unused")
        ActionResult result = null;
        try {
            result = action.execute();
        } catch (HackitWrongParameterException e) {
            assertEquals("scan action. Actor needed", e.getMessage());
        }

        po.actor = actor;
        action.setParameters(po);
        try {
            result = action.execute();
        } catch (HackitWrongParameterException e) {
            assertEquals("scan action. Tool needed", e.getMessage());
        }

        po.tool = scanner;
        action.setParameters(po);
        try {
            result = action.execute();
        } catch (HackitWrongParameterException e) {
            assertEquals("scan action. TargetGear needed", e.getMessage());
        }
        
    }
    @Test
    public void testUseOfDeviceRightWay() throws HackitWrongParameterException {
        ActionParameters po = new ActionParameters();
        Actor actor = new HumanControlledCharacter("MegaPihar");
        actor.addSkill("scan");
        Gear scanner = new ScanDevice("ScanMaster22000").addPurpose("scan", 100);
        Action action = new ScanAction();
        Gear target = new ScanDevice("WTF");
        Gear unscannableTarget = new ScanDevice("You can't see my name").addPurpose("scan", 10000);
        try {
            @SuppressWarnings("unused")
            Gear failedCreation = new BombDevice("BombMaster").addPurpose(null, 0);
        } catch (Exception e) {
            assertEquals("No null purpose allowed", e.getMessage());
        }
        Gear scannerWithotScanPurpose = new BombDevice("BombMaster");
        po.actor = actor;
        po.tool = scanner;
        po.targetGear = target;

        action.setParameters(po);
        ActionResult result = action.execute();
        assertTrue(result.isSuccess());
        assertEquals("You successfully scanned "+ target.getName()+". Got new information", result.getResultMessage());
      
        po.targetGear = unscannableTarget;
        action.setParameters(po);
        result = action.execute();
        assertFalse(result.isSuccess());
        assertEquals("Unsuccesful scan. You got no new information", result.getResultMessage());
        
        po.targetGear = target;
        po.tool = scannerWithotScanPurpose;
        action.setParameters(po);
        result = action.execute();
        assertFalse(result.isSuccess());
        assertEquals("Unsuccesful scan. You got no new information", result.getResultMessage());
    }
}
