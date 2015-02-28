package ua.com.sas.model;

import java.util.Random;

import org.junit.Test;

import ua.com.sas.model.Quote;
import ua.com.sas.model.QuoteGenerator;
import ua.com.sas.model.Storage;
import ua.com.sas.view.Input;
import ua.com.sas.view.Output;
import static org.mockito.Mockito.*;

public class StorageTest {
	
	@Test
	public void mockTest(){
		//given
		Output out = mock(Output.class);
		Input in = mock(Input.class);
		Random rand = mock(Random.class);
		Quote quote = new QuoteGenerator(rand);
		Storage storage = new Storage(out, in, quote);
		
		//when
		when(rand.nextInt()).thenReturn(0);
		when(in.readChoice()).thenReturn("51", "2", "51", "1", "0", "0", "0");
		storage.initiate();
		
		//then
		verify(out).println("If you don't know where you're going, you will probably end up somewhere else. (c) Laurence J. Peter");
		verify(out, times(2)).println("1 - Sport, 2 - Science, 3 - Music\nWhat are you interested in? Pleace, make your choice:");
		verify(out).println("You chose - Science");
		verify(out, times(2)).println("1) Name - Space Warning, Description - Discover the univerce, Money we need - 156540, Money we have - 125140, Days left - 42");
		verify(out, times(2)).println("If you want to return press \"0\"");
		verify(out).println("Thanks for using our program, Goodbye!");
		verify(out).println("bla-bla-bla");
		verify(out).println("youtube.com");
		verify(out).println("Q: Have you invested your money? A: yes");
		verify(out, times(2)).println("--------------------------------------------------");
		verify(out).println("Error!! There are no such project - Try again:");
		verify(out).println("Error!! There are no such category - Try again:");
	}
}
