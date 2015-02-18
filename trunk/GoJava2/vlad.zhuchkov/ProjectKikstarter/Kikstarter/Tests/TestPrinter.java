import org.junit.Before;
import org.junit.Test;

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
