package goit.nz.kickstartermvc.test;

import goit.nz.kickstartermvc.test.model.MainPageModelTest;
import goit.nz.kickstartermvc.test.view.CategoryViewTest;
import goit.nz.kickstartermvc.test.view.MainPageViewTest;
import goit.nz.kickstartermvc.test.view.ProjectViewTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ MainPageViewTest.class, CategoryViewTest.class,
		ProjectViewTest.class, MainPageModelTest.class })
public class KickstarterTestSuite {
}
