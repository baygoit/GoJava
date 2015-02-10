package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.action.Action;
import ua.com.goit.gojava1.lslayer.hackit2.action.InfoAction;
import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionResult;
import ua.com.goit.gojava1.lslayer.hackit2.dto.ActionParameters;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.InfoDevice;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.ScanDevice;

public class InfoActionTest {
    private ActionParameters parameters = new ActionParameters();
    @Test
    public void testInfoAction()  {
        Actor actor = null; 
        Gear tool = null;
        @SuppressWarnings("unused")
        Gear target = null;
        ActionResult result = null;
        //Init section
        try {
            actor = new HumanControlledCharacter("MegaPihar");
            tool = new InfoDevice("Tool");
            target =  new ScanDevice("Target"); 
            parameters.actor = actor;
        } catch (HackitWrongParameterException e) {
            fail ("No exceptions expected");
            }
        Action action = new InfoAction();
        action.setParameters(parameters);
        
        //Usage section
        try {
            result = action.execute();
        } catch (HackitWrongParameterException e) {
            assertEquals("info action. TargetActor nedded", e.getMessage());
        }

        
        parameters.targetActor =  actor;
        action.setParameters(parameters);
        try {
            result = action.execute();
        } catch (HackitWrongParameterException e) {
            assertEquals("info action. Tool needed", e.getMessage());
        }

    
    
        parameters.tool =  tool;
        action.setParameters(parameters);
        try {
            result = action.execute();
        } catch (HackitWrongParameterException e) {
            fail("Should pass, no exceptions expected");
        }
        //Target has no parameters defined, so info action should be empty
        assertEquals("", result.getResultMessage());
}

}
