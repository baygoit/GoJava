package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import org.junit.Test;

import kickstarter.manager.Manager;

public class KickstarterTest {

	Manager operator = new Manager();

	@Test
	public void QuoteTest() {
		String quote = operator.getRandomQuote();
		assertEquals(quote.getClass(), "quote".getClass());
	}

	@Test
	public void CategoriesTest() {
		List<String> categories = operator.getAllCategories();
		int number = categories.size();
		assertEquals(number > 0, true);
	}

	@Test
	public void ProjectsTest() {
		List<String> category = operator.getAllCategories();
		int number = 0;
		for (int index = 0; index < category.size(); index++) {
			// if category is empty we are checking out other
			HashMap<Integer, String> projects = operator
					.getAllProjectsByCategory(category.get(index));
			number = projects.size();
			if (number > 0) {
				break;
			}
		}
		assertEquals(number > 0, true);
	}

	@Test
	public void openProjectTest() {
		List<String> category = operator.openProject(1);
		String name = category.get(0);
		assertEquals(name.getClass(), "String".getClass());
	}

	@Test
	// I really don`t like it (idea in keeping some test project)
	public void sponsorTest() {
		int difference = 1;
		int id = 1;
		int before = operator.getMoneyCollected(1);
		operator.sponsor(id, 1);
		int after = operator.getMoneyCollected(1);

		assertEquals(after - before, difference);
		/**
		 * AccountingDAO dao = new AccountingDAO();
		 * 
		 * @SuppressWarnings("unchecked") List<Accounting> archive =
		 *                                dao.emf.createQuery
		 *                                ("select from accounting where id='" +
		 *                                id + "'").getResultList();
		 *                                for(Accounting bill:archive){
		 *                                System.out.println(bill.getInvoice());
		 * 
		 *                                }
		 */
	}
}
