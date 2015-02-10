package mainkick;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestCheckClass {
	
	class FakeInputsConsole extends InputsConsole{
		private List<String> strings;
		
		public FakeInputsConsole(String... strings){
			this.strings = new ArrayList<String>(Arrays.asList(strings));
		}

		@Override
		public String enter() throws IOException{
			return strings.remove(0);
		}
	}
	
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
    public void shouldSendReport_whenNotSendReport() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("5", "i", "88", "4"), new FakeOutputConsole());
		
		int rezult = check.checkNumber(new int[] {1,4,6});
		
		assertEquals("This number does not exist, please try again", check.getOut().getMessages().get(0).toString());
		assertEquals("It is not a number, please try again", check.getOut().getMessages().get(1).toString());
		assertEquals("This number does not exist, please try again", check.getOut().getMessages().get(2).toString());
		assertEquals("You have used three attempts, try ten minutes", check.getOut().getMessages().get(3).toString());
		assertEquals(rezult, 777);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
    public void shouldMethodStop_whenMethodDontStop() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("5", "i", "88", "4"), new FakeOutputConsole());
		
		check.checkNumber(new int[] {1,4,6});
		check.getOut().getMessages().get(4);
	}
	
	@Test
    public void shouldFallWithinTheBoundaries_whenIsRankedWithinTheBoundaries() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("1", "4", "6"), new FakeOutputConsole());
		
		int rezult = check.checkNumber(new int[] {1,4,6});
		assertTrue(1 == rezult);
		assertEquals(rezult, 1);
		
		rezult = check.checkNumber(new int[] {1,4,6});
		assertTrue(4 == rezult);
		assertEquals(rezult, 4);
		
		rezult = check.checkNumber(new int[] {1,4,6});
		assertTrue(6 == rezult);
		assertEquals(rezult, 6);
    }
	
	@Test
    public void shouldSendReportNotNumber_whenNotSendReport() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("е", "1"), new FakeOutputConsole());
		
		int rezult = check.checkNumber(new int[] {1,4,6});
		assertEquals("It is not a number, please try again", check.getOut().getMessages().get(0).toString());
		assertTrue(1 == rezult);
		assertEquals(rezult, 1);
    }
	
	@Test (expected = IndexOutOfBoundsException.class)
    public void shouldIOOBE_whenNotIOOBE() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("е"), new FakeOutputConsole());
		
		check.checkNumber(new int[] {1,4,6});
    }	

	@Test
    public void shouldSendReportNumberNumberDoesNotExist_whenNotSendReport() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("-1", "6"), new FakeOutputConsole());
		
		int rezult = check.checkNumber(new int[] {1,4,6});
		
		assertEquals("This number does not exist, please try again", check.getOut().getMessages().get(0).toString());
		assertTrue(6 == rezult);
		assertEquals(rezult, 6);
    }
	
	@Test (expected = IndexOutOfBoundsException.class)
    public void shouldExpectedIOOBE_whenNotIOOBE() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("-1"), new FakeOutputConsole());
		
		check.checkNumber(new int[] {1,4,6});
    }
	
	@Test
    public void shouldZero_whenNotZero() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("0", "1"), new FakeOutputConsole());
		
		int rezult = check.checkNumber(new int[] {0,1,4,6});
		
		assertTrue(0 == rezult);
		assertEquals(rezult, 0);
    }

	@Test
    public void shouldZero_whenNotZero2() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("2", "1"), new FakeOutputConsole());
		
		int rezult = check.checkNumber(new int[] {0,1,4,6});
		assertEquals("This number does not exist, please try again", check.getOut().getMessages().get(0).toString());
		assertTrue(1 == rezult);
		assertEquals(rezult, 1);
    }

}