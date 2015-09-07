package belskii.artem.kickstarter;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class InputTest {
	private Input in = mock(Input.class);
	private Input in1 = new Input();

	@Test
	public void testRead() {
		Mockito.when(in.read()).thenReturn(1);
		Assert.assertNotNull(in1);
	}

}	
