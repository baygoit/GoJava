package ua.com.scread.kickstarter;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class KickstarterTest {
		
	@Test
	public void shouldBeQuestion_whenGetQuestion() {
//	    Categories categories = new Categories();
//	    Category category1 = new Category("category1");
//        Category category2 = new Category("category2");
//        categories.add(category1);
//        categories.add(category2);
//        
//        Projects projects = new Projects();
//        Project project = new Project("Project", "Description", 10, 10, 
//                new Details("Some history", "Video link", new FAQ("Question", "Answer")));
//        
//        projects.add(project);
	    
	    Model model = new Model();
	    IO io = mock(IO.class);
	    QuoteGenerator quote = mock(QuoteGenerator.class);
	    when(quote.getQuote()).thenReturn("quote");
	    when(io.read()).thenReturn(0);
	    
		KickstarterRunner kickstarter = new KickstarterRunner(model, io, quote);
		
		kickstarter.run();
		
		verify(io).print("quote\n");
		verify(io).print("\nChoose category: ");
		verify(io).print("[1 - Sport, 2 - Science, 3 - Virtual reality]");
		verify(io).print("Thanks for using my program!");
        
	}
}
