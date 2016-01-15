package ua.com.goit.gojava7.kickstarter.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CategoryMappingTest.class, PaymentMappingTest.class, ProjectMappingTest.class,
		QuestionMappingTest.class, QuoteMappingTest.class, RewardMappingTest.class })

public class TestSuite {
}
