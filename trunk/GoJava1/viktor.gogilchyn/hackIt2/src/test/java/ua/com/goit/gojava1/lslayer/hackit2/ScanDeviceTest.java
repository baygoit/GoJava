package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Devices.ScanDevice;

public class ScanDeviceTest {
    @Test
    public void testCreation() {
        ScanDevice scanner = new ScanDevice("Vizor3000");
        assertEquals("Vizor3000", scanner.getName());
    }
    @Test
    public void testViewOfScanner() {
        ScanDevice scanner = new ScanDevice("Vizor3000");
        scanner.addPurpose("scan", 100);
        String eol = System.getProperty("line.separator");
        assertEquals("Vizor3000", scanner.toString());
        scanner.addParameter("cpu", 100);
        assertEquals("Vizor3000"+ eol +"cpu: 100", scanner.toString());
    }
    @Test
    public void testUseOfDeviceWrongWay() {
        //Init section
        Actor actor = new HumanControlledCharacter("MegaPihar");
        actor.addSkill("scan");
        Gear scanner = new ScanDevice("ScanMaster22000").addPurpose("scan", 100);
        Action action = new ScanAction();
        //Use section
        ActionResult result = action.execute(actor);
        assertFalse(result.isSuccess());
        assertEquals("You can't scan with your eyes, try using tools.", result.getResultMessage());

        result = action.execute(actor, scanner);
        assertFalse(result.isSuccess());
        assertEquals("You scanned, but recevied no result. Try scan something!", result.getResultMessage());
        
    }
    @Test
    public void testUseOfDeviceRightWay() {
        Actor actor = new HumanControlledCharacter("MegaPihar");
        actor.addSkill("scan");
        Gear scanner = new ScanDevice("ScanMaster22000").addPurpose("scan", 100);
        Action action = new ScanAction();
        Gear target = new ScanDevice("WTF");
        Gear unscannableTarget = new ScanDevice("You shouldn't see my name").addPurpose("scan", 10000);
        Gear scannerWithotScanPurpose = new ScanDevice("ScrewMaster").addPurpose(null, 0); //Test null branch.

        ActionResult result = action.execute(actor, scanner, target);
        assertTrue(result.isSuccess());
        assertEquals("You successfully scanned "+ target.getName()+". Got new information", result.getResultMessage());
      
        result = action.execute(actor, scanner, unscannableTarget);
        assertFalse(result.isSuccess());
        assertEquals("Unsuccesful scan. You got no new information", result.getResultMessage());
        
        result = action.execute(actor, scannerWithotScanPurpose, target);
        assertFalse(result.isSuccess());
        assertEquals("You tried to scan with " + scannerWithotScanPurpose.getName() + " but it can't do it. Use proper tool", result.getResultMessage());
    }
}
