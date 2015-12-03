package com.kickstarter.util.test;

import static org.junit.Assert.*;


import java.io.PrintStream;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.HashMap;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.kickstarter.app.KRun;
import com.kickstarter.model.Category;
import com.kickstarter.model.Project;
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
		Map<Integer, Project> projectList = new HashMap<>();
		projectList.put(1, new Project(1, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "", "it"));
		consolePrinter.categorysProjectsView(projectList);

		verify(printSteam).println(contains("itproject1"));
	}

	@Test
	public void multyCategorysProjectsViewTest() {
		Map<Integer, Project> projectList = new HashMap<>();
		projectList.put(1, new Project(1, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "", "it"));
		projectList.put(2, new Project(2, "itproject2", "discription2", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "", "it"));
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
	@Test
	public void singleCategorysProjectsViewTest() {
		consolePrinter.singleCategorysProjectsView(new Project(1, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "", "it"));
		verify(printSteam).println(contains("itproject1"));
		verify(printSteam).println(contains("discription1"));

	}
	@Test
	public void viewSelectedCategoryProjectsTest() {
		Map<Integer, Project> projectList = new HashMap<>();
		projectList.put(1, new Project(1, "itproject1", "discription1", 10, 10500, 8300, "Project History ",
				"www.videolink.com", "", "it"));
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
		Map<Integer, Category> list = new HashMap<>();
		list.put(1, new Category ("it",1));
		list.put(2, new Category ("sport",2));
		consolePrinter.allCategoriesView(list);
		verify(printSteam).println(contains("it"));
		verify(printSteam).println(contains("sport"));


		}
	@Test
	public void qoutePrint() {
		consolePrinter.qoutePrint("quote");
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

	

