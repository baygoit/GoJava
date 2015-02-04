package ua.com.scread.kickstarter;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class KickstarterTest {
		
	@Test
	public void shouldBeQuote_whenStartApplication() {
	    Model model = new Model();
	    IO io = mock(IO.class);
	    QuoteGenerator quote = mock(QuoteGenerator.class);
	    when(quote.getQuote()).thenReturn("quote");
	    when(io.read()).thenReturn(0);
	    
		KickstarterRunner kickstarter = new KickstarterRunner(model, io, quote);
		
		kickstarter.run();
		
		verify(io).print("quote\n");        
	}
	
	@Test
    public void shouldBeCategories_whenStartApplication() {
	    Categories categories = new Categories();
	    Category category1 = new Category("category1");
        Category category2 = new Category("category2");
        categories.add(category1);
        categories.add(category2);
        
        Projects projects = new Projects();
  
        Model model = new Model(categories, projects);
        IO io = mock(IO.class);
        QuoteGenerator quote = mock(QuoteGenerator.class);
        when(quote.getQuote()).thenReturn("quote");
        when(io.read()).thenReturn(1, 0);
        
        KickstarterRunner kickstarter = new KickstarterRunner(model, io, quote);
        
        kickstarter.run();
        
        verify(io).print("quote\n");
        verify(io, times(2)).print("\nChoose category: ");
        verify(io, times(2)).print("[1 - category1, 2 - category2]");
        verify(io).print("You choosed: category1\n");
        verify(io).print("Thanks for using my program!"); 
    }
	
	@Test
    public void shouldBeProjects_whenChoosedCategory() {
        Categories categories = new Categories();
        Category category1 = new Category("category1");
        Category category2 = new Category("category2");
        categories.add(category1);
        categories.add(category2);
        
        Projects projects = new Projects();
        Project project = new Project("Project", "Description", 10, 10, 
                new Details("Some history", "Video link", new FAQ("Question", "Answer")));
        project.setCategory(category1);
        projects.add(project);
      
        Model model = new Model(categories, projects);
        IO io = mock(IO.class);
        QuoteGenerator quote = mock(QuoteGenerator.class);
        when(quote.getQuote()).thenReturn("quote");
        when(io.read()).thenReturn(1, 0, 0);
        
        KickstarterRunner kickstarter = new KickstarterRunner(model, io, quote);
        
        kickstarter.run();
        
        verify(io).print("Project\n");
        verify(io).print("Description\n");
    }
	
	@Test
    public void shouldCloseMessage_whenClosedApp() {
              
        Model model = new Model();
        IO io = mock(IO.class);
        QuoteGenerator quote = mock(QuoteGenerator.class);
        when(io.read()).thenReturn(0);
        
        KickstarterRunner kickstarter = new KickstarterRunner(model, io, quote);
        
        kickstarter.run();
        
        verify(io).print("Thanks for using my program!");
    }
	 
}
