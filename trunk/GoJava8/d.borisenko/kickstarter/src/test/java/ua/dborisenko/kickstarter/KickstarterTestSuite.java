package ua.dborisenko.kickstarter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ProjectCategoryTest.class,
                ProjectTest.class,
                DataSourceProjectTest.class,
                DataSourceProjectCategoryTest.class,
                DataSourceDailyPhraseTest.class,
                DataSourceTest.class,
                ErrorTest.class})
public class KickstarterTestSuite {

}
