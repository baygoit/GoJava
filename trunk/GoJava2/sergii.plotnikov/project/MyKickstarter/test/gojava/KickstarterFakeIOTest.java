package gojava;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class KickstarterFakeIOTest {
		
	@Test
	public void mockTest() {
        // given
            Categories categories = new Categories();
            categories.fillCategories();
           
            IO io = mock(IO.class);
           
            Kickstarter kickstarter = new Kickstarter(categories, io);
           
            
            when(io.input()).thenReturn(1, 1, 0, 0, 2,0,5,0);
           
            kickstarter.run();

            // then
            verify(io).out("Welcome to the place where your dreams become real possibilities! ;)\n");
            verify(io, times (3)).out("Choose a category:\n1 - Sports\n2 - Music\n3 - Games\n0 - Go back\n");
            verify(io, times (2)).out("You have chosen Category Sports\n"+
					"Choose a project:\n"+
					"1 - Football\n"+
					"this is a short description\n"+
					"Money needed: 10000; Money collected: 0\n"+
					"Days left: 7\n"+
					"--------------------------\n"+
					"2 - Basketball\n"+
					"this is a short description\n"+
					"Money needed: 10000; Money collected: 0\n"+
					"Days left: 7\n"+
					"--------------------------\n"+
					"0 - Go back\n");
            verify(io).out("Wrong input!!!\nChoose again!");
            verify(io).out("Empty!\n0 - Go back");
    }

}
