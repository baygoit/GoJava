package ua.home.kickstarter.engine;

import org.junit.Before;
import org.junit.Test;

import ua.home.kickstarter.controller.CategoriesController;
import ua.home.kickstarter.controller.ProjectsController;
import ua.home.kickstarter.controller.QuotationsController;
import ua.home.kickstarter.view.ConsoleInput;
import ua.home.kickstarter.view.ConsoleOutput;
import ua.home.kickstarter.view.Display;
import static org.mockito.Mockito.*;

public class KickstarterTest {
	private CategoriesController categoriesController;
	private QuotationsController quotationsController;
	private ProjectsController projectsController;
	private ConsoleOutput consoleOutput;
	private Display display;
	private ConsoleInput consoleInput;
	private Kickstarter kickstarter;
	

	@Before
	public void setUp() {
		categoriesController = mock(CategoriesController.class);
		quotationsController = mock(QuotationsController.class);
		projectsController = mock(ProjectsController.class);
		consoleOutput = mock(ConsoleOutput.class);
		consoleInput = mock(ConsoleInput.class);
		display = new Display(quotationsController, categoriesController, projectsController, consoleOutput);
		kickstarter = new Kickstarter(quotationsController, categoriesController, projectsController, consoleOutput,
				consoleInput, display);
	} 

	@Test
	public void shouldReturnWarningMassage_whenCategoryNotExist() {		
		when(consoleInput.nextIntIndex()).thenReturn(1, 0);
		kickstarter.run();
		verify(consoleOutput).output("Категория под номером 1 отстствует в системе, повторите ввод. \n");
	}
	
	@Test
	public void shouldReturnChooseMassage() {
		when(consoleInput.nextIntIndex()).thenReturn(1, 0);
		kickstarter.menuLevel1(1);

		verify(consoleOutput).output("null[Выберите проект от 1 до 0 или нажмите 0 для возврата к выбору категорий]\n");
	}
	
	@Test
	public void shouldReturnWarningMassage_whenProjectNotExist() {
		when(consoleInput.nextIntIndex()).thenReturn(1, 0);
		kickstarter.menuLevel2(1);

		verify(consoleOutput).output("Проект под номером 1 отстствует в системе, повторите ввод. \n");
	}
}
