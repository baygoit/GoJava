package goit.nz.kickstartermvc.test;

import goit.nz.kickstartermvc.test.controller.CategoryControllerTest;
import goit.nz.kickstartermvc.test.controller.FAQControllerTest;
import goit.nz.kickstartermvc.test.controller.MainPageControllerTest;
import goit.nz.kickstartermvc.test.controller.PaymentControllerTest;
import goit.nz.kickstartermvc.test.controller.ProjectControllerTest;
import goit.nz.kickstartermvc.test.dao.FAQTest;
import goit.nz.kickstartermvc.test.dao.ProjectTest;
import goit.nz.kickstartermvc.test.model.CategoryModelTest;
import goit.nz.kickstartermvc.test.model.MainPageModelTest;
import goit.nz.kickstartermvc.test.model.PaymentModelTest;
import goit.nz.kickstartermvc.test.model.ProjectModelTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MainPageModelTest.class, CategoryModelTest.class,
		ProjectModelTest.class, ProjectTest.class,
		MainPageControllerTest.class, CategoryControllerTest.class,
		ProjectControllerTest.class, DispatcherTest.class,
		KickstarterTest.class, PaymentModelTest.class,
		PaymentControllerTest.class, FAQTest.class, FAQControllerTest.class })
public class KickstarterTestSuite {
}
