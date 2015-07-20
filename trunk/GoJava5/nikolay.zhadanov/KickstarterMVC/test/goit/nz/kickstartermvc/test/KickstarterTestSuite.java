package goit.nz.kickstartermvc.test;

import goit.nz.kickstartermvc.test.controller.CategoryControllerTest;
import goit.nz.kickstartermvc.test.controller.MainPageControllerTest;
import goit.nz.kickstartermvc.test.controller.ProjectControllerTest;
import goit.nz.kickstartermvc.test.dao.ProjectTest;
import goit.nz.kickstartermvc.test.model.CategoryModelTest;
import goit.nz.kickstartermvc.test.model.MainPageModelTest;
import goit.nz.kickstartermvc.test.model.ProjectModelTest;
import goit.nz.kickstartermvc.test.view.CategoryViewTest;
import goit.nz.kickstartermvc.test.view.MainPageViewTest;
import goit.nz.kickstartermvc.test.view.ProjectViewTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MainPageViewTest.class, CategoryViewTest.class,
		ProjectViewTest.class, MainPageModelTest.class,
		CategoryModelTest.class, ProjectModelTest.class, ProjectTest.class,
		MainPageControllerTest.class, CategoryControllerTest.class,
		ProjectControllerTest.class, DispatcherTest.class,
		KickstarterTest.class, BootstrapTest.class })
public class KickstarterTestSuite {
}
