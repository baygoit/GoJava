package org.kudryavtsev.kickstarter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.kudryavtsev.kickstarter.Input;
import static org.mockito.Mockito.*;

public class InputTest {

    @Test
    public void shouldGetAnswer_whenInsertedNegative() {
        // fail("Not yet implemented");
//        Input scan = null;
//        int actual = scan.getAnswer();
//        int expected = 0;
//        assertEquals(expected, actual);
        Input mockedScan = mock(Input.class);
        mockedScan.getAnswer();
        verify(mockedScan).getAnswer();
    }

    @Test
    public void testClose() {
//        fail("Not yet implemented");

    }
    // public class Input {
    // private Scanner in = new Scanner(System.in);
    //
    // public int getAnswer() {
    // System.out.print("You choice (0 - exit):");
    // int answer = 0;
    // answer = in.nextInt();
    // return answer;
    // }
    //
    // public void close() {
    // in.close();
    // }
}
