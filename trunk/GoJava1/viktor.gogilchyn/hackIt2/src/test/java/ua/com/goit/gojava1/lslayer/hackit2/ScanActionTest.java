package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitWrongParameterException;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.domain.action.ScanAction;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.domain.gear.ScanDevice;

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
        target = new ScanDevice("Target");
        try {
            this.tool.addPurpose("scan", 100);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        po.actor = this.actor;
        po.tool = this.tool;
        po.targetGear = this.target;
    }

    @Test
    public void testScanActionCreation() {
        assertNotNull(scan);
        assertEquals(
                "AbstractAction [commandToInvoke=scan, timeNeededToInvokeAction=0, parameters=ActionParamters [actor=null, tool=null, targetGear=null, targetActor=null, value=0]]",
                scan.toString());
    }

    @Test
    public void testScanActionResult() {
        scan.setParameters(this.po);
        try {
            assertNotNull(scan.execute());
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
    }
}
