package kickstarter.interfaces;

import static org.junit.Assert.*;
import kickstarter.engine.Category;
import kickstarter.engine.Data;
import kickstarter.engine.Project;
import kickstarter.engine.Quote;
import kickstarter.interfaces.printers.TestPrinter;
import kickstarter.interfaces.readers.TestReader;
import kickstarter.storages.CategoriesStorage;
import kickstarter.storages.ProjectsStorage;

import org.junit.Test;

public class UserInterfaceTest {
/*
	@Test
	public void shouldQoutePrint_whenShowQuote() {
		TestPrinter printer = new TestPrinter();
		TestReader reader = new TestReader();
		UserInterface ui = new UserInterface(printer, reader);
		ui.showQuotePage(new Quote("quote"));

		assertEquals("Quote: quote\r\n", printer.getResult());
	}

	@Test
	public void shouldProjectPrint_whenShowProject() {
		TestPrinter printer = new TestPrinter();
		TestReader reader = new TestReader();
		reader.append("0");

		UserInterface ui = new UserInterface(printer, reader);
		ui.showProject(new Project("velo parking", "velo parking in Kiev", new Category("Sport"), 10000, 100));

		assertEquals("--------------------\r\n" + "name=velo parking\r\n" + " description=velo parking in Kiev\r\n"
				+ " totalAmount=10000\r\n" + " collectAmount=0\r\n" + " daysLeft=100\r\n" + " history=\r\n"
				+ " link=\r\n" + " questionsAndAnswers=\r\n" + "0 - exit\r\n", printer.getResult());
	}

	@Test
	public void shouldGoodLuck_whenShowTheEndMessage() {
		TestPrinter printer = new TestPrinter();
		TestReader reader = new TestReader();
		UserInterface ui = new UserInterface(printer, reader);
		ui.showTheEndPage();

		assertEquals("Good Luck!\r\n", printer.getResult());
	}

	@Test
	public void shouldPrintCateroriesList_whenChoiceCategory() {
		TestPrinter printer = new TestPrinter();
		TestReader reader = new TestReader();
		reader.append("0");

		UserInterface ui = new UserInterface(printer, reader);

		Category category1 = new Category("Name1");
		Category category2 = new Category("Name2");
		CategoriesStorage storage = new CategoriesStorage();
		storage.add(category1);
		storage.add(category2);

		Data result = ui.choiceCategory(storage);

		assertEquals(Defaults.EXIT, result);
		assertEquals("--------------------\r\n" + "Choice Category:\r\n" + category1.getId() + " - Name1\r\n"
				+ category2.getId() + " - Name2\r\n" + "0 - exit\r\n", printer.getResult());
	}

	@Test
	public void shouldPrintProjectsList_whenChoiceProject() {
		TestPrinter printer = new TestPrinter();
		TestReader reader = new TestReader();
		reader.append("0");

		UserInterface ui = new UserInterface(printer, reader);

		Project project1 = new Project("project1", "description", new Category("Sport"), 10000, 100);
		Project project2 = new Project("project2", "description", new Category("Sport"), 10000, 100);
		ProjectsStorage storage = new ProjectsStorage();
		storage.add(project1);
		storage.add(project2);

		Data result = ui.choiceProject(storage);

		assertEquals(Defaults.EXIT, result);
		assertEquals("--------------------\r\n" + "Choice Project:\r\n" + project1.getId()
				+ " - project1, description=description, totalAmount=10000, collectAmount=0, daysLeft=100\r\n"
				+ project2.getId()
				+ " - project2, description=description, totalAmount=10000, collectAmount=0, daysLeft=100\r\n"
				+ "0 - exit\r\n", printer.getResult());
	}*/
}
