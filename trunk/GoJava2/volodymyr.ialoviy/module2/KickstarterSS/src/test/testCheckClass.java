package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import mainkick.Check;
import static org.mockito.Mockito.mock;

public class testCheckClass {
	Check check  = new Check();
	
	@Test
    public void should_when() throws IOException, InterruptedException{
		
		int[] border = {1,2,3};
		Boolean yes = true;
		Check check  = mock(Check.class);
		check check1 = mock(check.checkNumber());
		

		int i = 2;
		String chosen = "2";
		
		int rezult = check.checkNumber(border, true);

		
		assertTrue(i == rezult);
    }
}