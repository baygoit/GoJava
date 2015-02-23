package ua.com.goit.gojava.kickstarter;
import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava.kickstarter.CategoryCatalog;
import ua.com.goit.gojava.kickstarter.in_memory_storage.InMemoryCategoryCatalog;
import ua.com.goit.gojava.kickstarter.input_output.Output;
import ua.com.goit.gojava.kickstarter.input_output.Printer;
import ua.com.goit.gojava.kickstarter.input_output.Reader;
import static org.mockito.Mockito.*;

public class TestPrinter {
	Output out;
	Reader in;
	Printer printer;
	CategoryCatalog catalog;
	@Before
	public void init(){
		catalog = new InMemoryCategoryCatalog();
		catalog.addCategory("games");
		out = mock( Output.class);
		printer = new Printer(out);
	}
	@Test
	public void expectCatalogName_WhenGiveCatalog(){
		printer.showCategoryCatalog(catalog);
		verify(out).print(contains("1)games"));
	}
	

}
