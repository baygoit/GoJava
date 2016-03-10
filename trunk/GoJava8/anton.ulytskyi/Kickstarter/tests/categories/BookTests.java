package categories;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

public class BookTests {

	Book puppet = new Book();

	@Test
	public void openCatalogTest() {
		loadFakeBase();
		String expectation = "1. Name_1 (short_information_1). Budget: 0USD/100USD. Days left: 30 days. id: 1"
				+ System.lineSeparator()
				+ "2. Name_2 (short_information_2). Budget: 0USD/100USD. Days left: 30 days. id: 2"
				+ System.lineSeparator();

		String result = puppet.openCatalog("TYPE_A");

		assertEquals(expectation, result);
	}

	@Test
	public void findProfileTest() {
		loadFakeBase();

		String expectation = "Name_3 (short_information_3). Budget: 0USD/100USD. Days left: 30 days."
				+ System.lineSeparator()
				+ System.lineSeparator()
				+ "Story_3"
				+ System.lineSeparator()
				+ System.lineSeparator()
				+ "URL_3"
				+ System.lineSeparator()
				+ System.lineSeparator()
				+ "Comments: ";
		String result = puppet.findProfile(3);
		assertEquals(expectation, result);
	}

	@Test
	public void sendCashTest() {
		loadFakeBase();

		String expectation = "1. Name_3 (short_information_3). Budget: 5USD/100USD. Days left: 30 days. id: 3"
				+ System.lineSeparator();

		puppet.sendCash(3, 5);

		String result = puppet.openCatalog("TYPE_B");
		assertEquals(expectation, result);
	}

	@Test
	public void addCommentTest() {
		loadFakeBase();
		String expectation = "Name_3 (short_information_3). Budget: 0USD/100USD. Days left: 30 days."
				+ System.lineSeparator()
				+ System.lineSeparator()
				+ "Story_3"
				+ System.lineSeparator()
				+ System.lineSeparator()
				+ "URL_3"
				+ System.lineSeparator()
				+ System.lineSeparator()
				+ "Comments: "+ System.lineSeparator()
				+ System.lineSeparator()
				+"puppet:"+ System.lineSeparator()+"Hello World!";
		
		puppet.addComment(3, "puppet", "Hello World!");
		String result = puppet.findProfile(3);
		assertEquals(expectation, result);
	}
	@Test
	public void checkTypeTest(){
		loadFakeBase();
		String expectation = "TYPE_A";
		String result = puppet.checkType(1);
		assertEquals(expectation, result);
	}

	public void loadFakeBase() {
		puppet.book.add(new Question(1, "Name_1", "short_information_1",
				"TYPE_A", 100, Calendar.getInstance(), "Story_1", "URL_1"));
		puppet.book.add(new Question(2, "Name_2", "short_information_2",
				"TYPE_A", 100, Calendar.getInstance(), "Story_2", "URL_2"));
		puppet.book.add(new Question(3, "Name_3", "short_information_3",
				"TYPE_B", 100, Calendar.getInstance(), "Story_3", "URL_3"));
	}
}
