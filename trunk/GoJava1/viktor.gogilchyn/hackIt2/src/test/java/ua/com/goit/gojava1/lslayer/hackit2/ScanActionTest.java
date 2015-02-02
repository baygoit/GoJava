package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.ScanAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ParameterObject;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.Devices.ScanDevice;

public class ScanActionTest {
    private Action scan;
    private ParameterObject po = new ParameterObject();
    private Actor actor = new HumanControlledCharacter("MegaPihar");
    private ScanDevice tool = new ScanDevice("Tool");
    private Gear target =  new ScanDevice("Target"); 
    
    @Before
    public void init() {
        this.scan = new ScanAction();
        this.tool.addPurpose("scan", 100);
        po.actor = this.actor;
        po.tool = this.tool;
        po.targetGear = this.target;
    }
    
    @Test
    public void testScanActionCreation() {
        assertNotNull(scan);
    }
    
    @Test
    public void testScanActionResult() {
        
        ActionResult result = scan.execute(this.po);
        assertNotNull(result);
        
        
    }
}
