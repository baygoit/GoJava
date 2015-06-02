package kickstarter.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ FakeConsole.class, test_bank.class,
		test_comments_repository.class,test_example_jaxb.class

})
public class test_suite {

}
