package ua.com.goit.gojava.kickstarter.input;
import org.junit.Test;

import ua.com.goit.gojava.kickstarter.input.Input;
import ua.com.goit.gojava.kickstarter.input.Reader;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class TestReader  {

private Reader reader;

@Test
public void expect1_WhenInput1(){
	Input in = mock(Input.class);
	reader = new Reader(in);
	when(in.read()).thenReturn("1");
	assertEquals(1,reader.readInt());
}
@Test(expected = NumberFormatException.class)
public void expectNumberFormatException_WhenLiteralInput(){
	Input in = mock(Input.class);
	reader = new Reader(in);
	when(in.read()).thenReturn("uhagkhdgk");
	reader.readInt();
}
	



}
