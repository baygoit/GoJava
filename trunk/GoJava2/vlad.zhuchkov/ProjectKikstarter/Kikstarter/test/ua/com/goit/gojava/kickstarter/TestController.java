package ua.com.goit.gojava.kickstarter;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.kickstarter.Controller;
import ua.com.goit.gojava.kickstarter.Input;
import ua.com.goit.gojava.kickstarter.Output;
import static org.mockito.Mockito.*;

public class TestController {
	private Output out;
	private Input in;
	private Controller app;
	@Before
	public void init(){
		in = mock(Input.class);
		out = mock(Output.class);
		app = new Controller(out,in);
	}
	@Test
	public void expectProjectInfo_When11Input() {
		when(in.read()).thenReturn("1","1","0","0");
		app.run();
		verify(out, atLeastOnce()).print(contains("*history**history**history*"));
	}
	
}
