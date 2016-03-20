package categories;

import org.junit.Test;

import site.Page;
import site.StartPage;

public class SqlDAOTest {

	@Test
	public void loadBaseTest(){
		
		SqlDAO dao = new SqlDAO();
		Category kickstarter = dao.loadBase();
		
		
	}
}
