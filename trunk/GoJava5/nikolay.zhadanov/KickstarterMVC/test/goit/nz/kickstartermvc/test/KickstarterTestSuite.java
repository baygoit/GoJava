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
import goit.nz.kickstartermvc.test.view.CategoryViewTest;
import goit.nz.kickstartermvc.test.view.FAQViewTest;
import goit.nz.kickstartermvc.test.view.MainPageViewTest;
import goit.nz.kickstartermvc.test.view.PaymentViewTest;
import goit.nz.kickstartermvc.test.view.ProjectViewTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MainPageViewTest.class, CategoryViewTest.class,
		ProjectViewTest.class, MainPageModelTest.class,
		CategoryModelTest.class, ProjectModelTest.class, ProjectTest.class,
		MainPageControllerTest.class, CategoryControllerTest.class,
		ProjectControllerTest.class, DispatcherTest.class,
		KickstarterTest.class, PaymentViewTest.class, PaymentModelTest.class,
		PaymentControllerTest.class, FAQTest.class, FAQViewTest.class,
		FAQControllerTest.class })
public class KickstarterTestSuite {
}
