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
		catalog = new CategoryCatalog();
		catalog.addCategory("games");
		out = mock( ConsolePrinter.class);
		printer = new Printer(out);
	}
	@Test
	public void expectCatalogName_WhenGiveCatalog(){
		doThrow(new IllegalArgumentException()).when(out).print(anyString());
		doNothing().when(out).print("1)games");
		printer.showCategoryCatalog(catalog);
	}
	

}
