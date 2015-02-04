package mainkick;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	@Test
    public void shouldFallWithinTheBoundaries_whenIsRankedWithinTheBoundaries() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("1", "4", "6"));
		
		int rezult = check.checkNumber(new int[] {1,4,6}, true);
		assertTrue(1 == rezult);
		assertEquals(rezult, 1);
		
		rezult = check.checkNumber(new int[] {1,4,6}, true);
		assertTrue(4 == rezult);
		assertEquals(rezult, 4);
		
		rezult = check.checkNumber(new int[] {1,4,6}, true);
		assertTrue(6 == rezult);
		assertEquals(rezult, 6);
    }
	
	@Test
    public void shouldSendReport_whenNotSendReport() throws IOException, InterruptedException{
		Check check  = new Check(new FakeInputsConsole("]", "fr rt", "2"));
		
		int rezult = check.checkNumber(new int[] {1,4,6}, true);
		assertTrue(1 == rezult);
		assertEquals(rezult, 1);
		
		rezult = check.checkNumber(new int[] {1,4,6}, true);
		assertTrue(4 == rezult);
		assertEquals(rezult, 4);
		
		rezult = check.checkNumber(new int[] {1,4,6}, true);
		assertTrue(6 == rezult);
		assertEquals(rezult, 6);
    }
	
//"-1", "0", "4", 
}
















