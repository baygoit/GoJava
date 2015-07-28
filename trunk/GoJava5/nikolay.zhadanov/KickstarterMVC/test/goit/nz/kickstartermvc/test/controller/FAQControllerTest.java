package goit.nz.kickstartermvc.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import goit.nz.kickstartermvc.controller.FAQController;
import goit.nz.kickstartermvc.controller.ProjectController;
import goit.nz.kickstartermvc.view.FAQView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FAQControllerTest {
	@Mock
	FAQView view;
	@Mock
	ProjectController parentController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenOnInputCorrectPaymentThenReturnBackMoveAndUpdateProject() {

		FAQController faqController = new FAQController(view, parentController);

		int expected = -2;
		int actual = faqController.onInput("test");
		assertEquals(expected, actual);
		verify(parentController, times(1)).addQuestion(anyString());
	}

	@Test
	public void whenOnTakeControlThenViewUpdated() {
		FAQController faqController = new FAQController(view, parentController);
		faqController.onTakeControl();
		verify(view, times(1)).update();
	}

	@Test
	public void whenZeroOnInputThenBack() {

		FAQController faqController = new FAQController(view, parentController);

		int expected = -2;
		int actual = faqController.onInput("0");
		assertEquals(expected, actual);
	}
}
