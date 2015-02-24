package gojava;

import gojava.InMemory.InMemoryCategories;
import gojava.InMemory.InMemoryMenu;
import gojava.Interface.Categories;
import gojava.Interface.IO;
import gojava.Interface.Menu;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class KickstarterFakeIOTest {
		
	@Test
	public void mockTest() {
        // given
            Categories categories = new InMemoryCategories();
            
            IO io = mock(IO.class);
            
    		InputCheck check = new InputCheck(io);
    		Menu menu = new InMemoryMenu(categories, io, check);
    		categories.fillCategories();
                       
           
            Kickstarter kickstarter = new Kickstarter(io, menu);
           
            
            when(io.input()).thenReturn(3, 2, 0, 0, 2,0,5,0);
           
            kickstarter.run();

            // then
            verify(io).out("Welcome to the place where your dreams become real possibilities! ;)\n");
            verify(io, times (3)).out("Choose a category:\n1 - Games\n2 - Music\n3 - Sports\n0 - Go back\n");
            verify(io, times (2)).out("You have chosen Category Sports\n"+
					"Choose a project:\n"+
					"1 - Basketball\n"+
					"this is a short description\n"+
					"Money needed: 10000; Money collected: 0\n"+
					"Days left: 7\n"+
					"--------------------------\n"+
					"2 - Football\n"+
					"this is a short description\n"+
					"Money needed: 10000; Money collected: 0\n"+
					"Days left: 7\n"+
					"--------------------------\n"+
					"0 - Go back\n");
            verify(io).out("Wrong input!!!\nChoose again!");
            verify(io).out("Empty!\n0 - Go back");
    }

}
