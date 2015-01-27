package ua.com.goit.gojava.POM.dataModel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CostItemTest.class, CostItemTransactionTest.class,
		ProjectFinResultTransactionTest.class, ProjectStageTest.class,
		ProjectTest.class })
public class AllTests {

}
