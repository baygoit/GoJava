package ua.com.goit.gojava7.salivon.state;

import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import ua.com.goit.gojava7.salivon.context.Console;
import static org.mockito.Mockito.*;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandler;

public class StateTest {

    @Test
    public void testOutputContentState() {
        State instance = new StateImpl();
        instance.outputContentState();

    }

    @Test
    public void testChangeState() {
        Console context = new Console();
        State instance = new StateImpl();
        instance.changeState(context);

    }

    @Test
    @Ignore
    public void testGetInData() {
        State instance = new StateImpl();
        State inst = spy(instance);
        when(inst.readUserInformations()).thenReturn("q");
        inst.verification();
        String expResult = "q";
        String result = instance.getInData();
        assertEquals(expResult, result);

    }

    @Test
    public void testIsCommandZero() {
        State instance = new StateImpl();
        boolean expResult = true;
        boolean result = instance.isCommandZero();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetCommandZero() {
        boolean commandZero = false;
        State instance = new StateImpl();
        instance.setCommandZero(commandZero);
        assertEquals(false, instance.isCommandZero());

    }

    @Test
    public void testIsCommandExit() {
        State instance = new StateImpl();
        boolean expResult = true;
        boolean result = instance.isCommandExit();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetCommandExit() {
        boolean commandExit = false;
        State instance = new StateImpl();
        instance.setCommandExit(commandExit);
        assertEquals(false, instance.isCommandExit());

    }

    @Test
    public void testGetScan() {
        Scanner expResult = null;
        Scanner result = State.getScan();
        assertNotNull(result);

    }

    @Test
    public void testGetIdCategory() {
        int expResult = 2;
        State.setIdCategory(expResult);
        int result = State.getIdCategory();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetIdCategory() {
        int indexCategory = 10;
        State.setIdCategory(indexCategory);
        assertEquals(10, State.getIdCategory());

    }

    @Test
    public void testGetIdProject() {
        int expResult = 5;
        State.setIdProject(expResult);
        int result = State.getIdProject();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetIndexProject() {
        int indexProject = 0;
        State.setIdProject(indexProject);
        assertEquals(0, State.getIdProject());
    }

    @Test
    public void testVerification() {
        State instance = new StateImpl();
        ErrorHandler mock = mock(ErrorHandler.class);
        State spy = spy(instance);
        spy.handler = mock;
        spy.setCommandExit(true);
        when(mock.validate(anyString())).thenReturn(true);
        doReturn("q").when(spy).readUserInformations();
        spy.verification();
        doReturn("0").when(spy).readUserInformations();
        spy.verification();
        doReturn("1").when(spy).readUserInformations();
        spy.verification();

    }

    @Test
    @Ignore
    public void testReadUserInformations() {
        State instance = new StateImpl();
        String result = instance.readUserInformations();
        assertNotNull(result);

    }

    @Test
    @Ignore
    public void testPerformExit() {
        State instance = new StateImpl();

    }

    @Test
    public void testNextState() {
        System.out.println("nextState");
        Console context = mock(Console.class);
        State instance = new StateImpl();
        instance.nextState(context);
        verify(context).execute();

    }

    public class StateImpl extends State {

        public void outputContentState() {
        }

        public void changeState(Console context) {
        }
    }

}
