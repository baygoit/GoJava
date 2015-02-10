package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.ScanAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.ScanDevice;

public class ScanActionTest {
    private Action scan;
    private ActionParameters po = new ActionParameters();
    private Actor actor = new HumanControlledCharacter("MegaPihar");
    private ScanDevice tool;
    private Gear target; 
    
    @Before
    public void init() throws Exception {
        this.scan = new ScanAction();
        tool = new ScanDevice("Tool");
        target =  new ScanDevice("Target"); 
        try {
            this.tool.addPurpose("scan", 100);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        po.actor = this.actor;
        po.tool = this.tool;
        po.targetGear = this.target;
    }
    
    @Test
    public void testScanActionCreation() {
        assertNotNull(scan);
        assertEquals("AbstractAction [commandToInvoke=scan, timeNeededToInvokeAction=0, parameters=ActionParamters [actor=null, tool=null, targetGear=null, targetActor=null, value=0]]", scan.toString());
    }
    
    @Test
    public void testScanActionResult() {
        scan.setParameters(this.po);
        try {
            assertNotNull(scan.execute());
        } catch (HackitWrongParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
