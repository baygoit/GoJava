package goit.nz.kickstartermvc.test.controller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MainPageControllerTest.class,
		CategoryControllerTest.class, ProjectControllerTest.class,
		PaymentControllerTest.class })
public class ControllerTestSuite {
}
