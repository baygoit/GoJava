import static org.junit.Assert.*;

import org.junit.Test;

import dao.pool.KickstarterException;
import view.Categories;
import view.ViewDispatcher;


public class abstractTest {

	@Test
	public void test() {
		 ViewDispatcher dispatcher=new Categories();
		 try {
			dispatcher.forward(null, null);
		} catch (KickstarterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
