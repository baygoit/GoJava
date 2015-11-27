package com.kickstarter.util.test;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.kickstarter.model.Category;
import com.kickstarter.model.Project;
import com.kickstarter.model.Quote;
import com.kickstarter.util.ConsolePrintView;

@RunWith(MockitoJUnitRunner.class)
public class ConsolePrintViewTest {

	private PrintStream defaultSystemOut;

	@Mock
	private PrintStream printSteam;

	ConsolePrintView consolePrinter = new ConsolePrintView();

	@Before
	public void setUp() {
		defaultSystemOut = System.out;
		System.setOut(printSteam);

	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
		System.setOut(defaultSystemOut);
	}

	@Test
	public void programExitInformTest() {
		ConsolePrintView consolePrinter = new ConsolePrintView();

		consolePrinter.programExitInform();
		verify(printSteam).println("You hava left the program");
	}

	@Test
	public void categorysProjectsViewTest() {
		List<Project> projectList = new ArrayList<>();
		projectList.add(new Project(1, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com","it"));
		consolePrinter.categorysProjectsView(projectList);

		verify(printSteam).println(contains("itproject1"));
	}

	@Test
	public void multyCategorysProjectsViewTest() {
		List<Project> projectList = new ArrayList<>();
		projectList.add(new Project(1, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com","it"));
		projectList.add(new Project(2, "itproject2", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com","it"));
		consolePrinter.categorysProjectsView(projectList);

		verify(printSteam).println(contains("itproject1"));
		verify(printSteam).println(contains("itproject2"));

	}

	@Test
	public void exitInformerTest() {
		consolePrinter.exitInformer();
		verify(printSteam).println("If you`d like to return to previous menu, please input 0 sign");
	}

	@Test
	public void projectSelectionInform() {
		consolePrinter.projectSelectionInform();
		verify(printSteam).println(contains("Choose project :"));

	}

	@Test
	public void choosenProjectTitleInformTest() {
		consolePrinter.choosenProjectTitleInform("Test");
		verify(printSteam).println(contains("You hava selected project -> " + "Test"));

	}
	@Test
	public void posobilitiesInfirm() {
		consolePrinter.posobilitiesInfirm();
		verify(printSteam).println(contains(
				"\n You can donate to this projec. If you'd lile to, please input 200, \n or you can ask a question inpyt 300,\n if you want to return to project selection menu pres any button "));

	}

	@Test
	public void InputPayersNameInfoTest() {
		consolePrinter.InputPayersNameInfo();
		verify(printSteam).println(contains("Please input your Name : "));
	}

	@Test
	public void InputCardIdInfoTest() {
		consolePrinter.InputCardIdInfo();
		verify(printSteam).println(contains("Please input your card number : "));
	}

	@Test
	public void paymentSizeInfoTest() {
		consolePrinter.paymentSizeInfo();
		verify(printSteam).println(contains("Please input amount of payment : "));

	}
//	@Test
//	public void categorysProjectsViewTest1() {
//		List<Project> projectList = new ArrayList<>();
//		projectList.add(new Project(1, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
//				"www.videolink.com", "it"));
//		consolePrinter.categorysProjectsView(projectList);
//		verify(printSteam).println(contains("itproject1"));
//		verify(printSteam).println(contains("discription1"));
//
//	}
	@Test
	public void viewSelectedCategoryProjectsTest() {
		List<Project> projectList = new ArrayList<>();
		projectList.add(new Project(1, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com","it"));
		consolePrinter.viewSelectedCategoryProjects(projectList);
		verify(printSteam).println(contains("Press"));
		verify(printSteam).println(contains("itproject1"));

	}
	@Test
	public void selectedCategoryInformerTest() {
		consolePrinter.selectedCategoryInformer("Title");
		verify(printSteam).println(contains("Title"));
}
	@Test
	public void categorySelectionInformTest() {
		consolePrinter.categorySelectionInform();
		verify(printSteam).println("\nPlease choose category you'd like to see: ");
	}
	@Test
	public void allCategoriesViewTest() {
		List<Category> list = new ArrayList<>();
		list.add( new Category ("it",1));
		list.add( new Category ("sport",2));
		consolePrinter.allCategoriesView(list);
		verify(printSteam).println(contains("it"));
		verify(printSteam).println(contains("sport"));


		}
	@Test
	public void qoutePrint() {
		consolePrinter.qoutePrint(new Quote("quote" ,"author"));
		verify(printSteam).println(contains("quote"));
	}
	@Test
	public void InputQuestionInfo() {
		consolePrinter.InputQuestionInfo();
		verify(printSteam).println("Plese enter your quastion : ");
	}
	@Test
	public void paymentPosobilitiesInfo() {
		consolePrinter.paymentPosobilitiesInfo();
		verify(printSteam).println("Amount of posible  payment to the project : \n Press 1 -> 50$ \n Press 2 -> 100$ \n Press 3 -> 100$ \n Press 4 -> user amount \n");
	}
	}

	