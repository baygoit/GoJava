package ua.com.goit.gojava7.salivon.context;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import ua.com.goit.gojava7.salivon.state.State;
import static org.mockito.Mockito.*;

public class ConsoleTest {

    Console instance;

    @Before
    public void setUp() {
        instance = new Console();
    }

    @Test
    public void testGetCurrentState() {
        State result = instance.getCurrentState();
        assertTrue(result instanceof State);

    }

    @Test
    public void testSetCurrentState() {
        State currentState = mock(State.class);
        instance.setCurrentState(currentState);
        assertEquals(currentState, instance.getCurrentState());

    }

    @Test
    public void testOutputContentState() {

        State state = mock(State.class);
        instance.setCurrentState(state);
        instance.outputContentState();
        verify(state).outputContentState();
    }

    @Test
    public void testVerification() {
        State state = mock(State.class);
        instance.setCurrentState(state);
        instance.verification();
        verify(state).verification();

    }

    @Test
    public void testChangeState() {
        State state = mock(State.class);
        instance.setCurrentState(state);
        instance.changeState();
        verify(state).changeState(instance);

    }

    @Test
    public void testNextState() {
        State state = mock(State.class);
        instance.setCurrentState(state);
        instance.nextState();
        verify(state).nextState(instance);

    }

    @Test
    public void testExecute() {
        State state = mock(State.class);
        instance.setCurrentState(state);
        instance.execute();
    }

}
