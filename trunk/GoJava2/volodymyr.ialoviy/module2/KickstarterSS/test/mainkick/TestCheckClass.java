package mainkick;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestCheckClass {

	class FakeOutputConsole extends OutputConsole{
		private List<String> messages = new LinkedList<String>(); 

		@Override
		public void print(String message) {
            messages.add(message); 
	    }
	
		@Override
	    public List<String> getMessages() {
	            return messages;
	    }
	}
	
	@Test
    public void shouldSendReport_whenNotSendReport(){
//		InputChecker check  = new InputChecker(new FakeOutputConsole());

		int rezult = InputChecker.checkNumber(new int[] {1,4,6}, "5");//, "i", "88", "4"
		
		assertEquals("This number does not exist, please try again", InputChecker.getOut().getMessages().get(0).toString());
		assertEquals("It is not a number, please try again", InputChecker.getOut().getMessages().get(1).toString());
		assertEquals("This number does not exist, please try again", InputChecker.getOut().getMessages().get(2).toString());
		assertEquals("You have used three attempts, try ten minutes", InputChecker.getOut().getMessages().get(3).toString());
		assertEquals(rezult, 777);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
    public void shouldMethodStop_whenMethodDontStop(){
		InputChecker check  = new InputChecker(new FakeOutputConsole());
		
		InputChecker.checkNumber(new int[] {1,4,6}, "5");//, "i", "88", "4"
		InputChecker.getOut().getMessages().get(4);
	}
	
	@Test
    public void shouldFallWithinTheBoundaries_whenIsRankedWithinTheBoundaries(){
		InputChecker check  = new InputChecker(new FakeOutputConsole());
		
		int rezult = InputChecker.checkNumber(new int[] {1,4,6}, "1");
		assertTrue(1 == rezult);
		assertEquals(rezult, 1);
		
		rezult = InputChecker.checkNumber(new int[] {1,4,6}, "4");
		assertTrue(4 == rezult);
		assertEquals(rezult, 4);
		
		rezult = InputChecker.checkNumber(new int[] {1,4,6}, "6");
		assertTrue(6 == rezult);
		assertEquals(rezult, 6);
    }
	
	@Test
    public void shouldSendReportNotNumber_whenNotSendReport(){
		InputChecker check  = new InputChecker(new FakeOutputConsole());
		
		int rezult = InputChecker.checkNumber(new int[] {1,4,6}, "е");//, "1"
		assertEquals("It is not a number, please try again", check.getOut().getMessages().get(0).toString());
		assertTrue(1 == rezult);
		assertEquals(rezult, 1);
    }
	
	@Test (expected = IndexOutOfBoundsException.class)
    public void shouldIOOBE_whenNotIOOBE(){
		InputChecker check  = new InputChecker(new FakeOutputConsole());
		
		InputChecker.checkNumber(new int[] {1,4,6}, "е");
    }	

	@Test
    public void shouldSendReportNumberNumberDoesNotExist_whenNotSendReport(){
		InputChecker check  = new InputChecker(new FakeOutputConsole());
		
		int rezult = check.checkNumber(new int[] {1,4,6}, "-1");//, "6"
		
		assertEquals("This number does not exist, please try again", InputChecker.getOut().getMessages().get(0).toString());
		assertTrue(6 == rezult);
		assertEquals(rezult, 6);
    }
	
	@Test (expected = IndexOutOfBoundsException.class)
    public void shouldExpectedIOOBE_whenNotIOOBE(){
		InputChecker check  = new InputChecker(new FakeOutputConsole());
		
		InputChecker.checkNumber(new int[] {1,4,6}, "-1");
    }
	
	@Test
    public void shouldZero_whenNotZero(){
		InputChecker check  = new InputChecker(new FakeOutputConsole());
		
		int rezult = InputChecker.checkNumber(new int[] {0,1,4,6}, "0");//, "1"
		
		assertTrue(0 == rezult);
		assertEquals(rezult, 0);
    }

	@Test
    public void shouldZero_whenNotZero2(){
		InputChecker check  = new InputChecker(new FakeOutputConsole());
		
		int rezult = InputChecker.checkNumber(new int[] {0,1,4,6}, "2");//, "1"
		assertEquals("This number does not exist, please try again", InputChecker.getOut().getMessages().get(0).toString());
		assertTrue(1 == rezult);
		assertEquals(rezult, 1);
    }

}