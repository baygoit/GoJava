package integration.MySqlSuiteTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MySqlEmptyIntegrationTest.class,
        MySqlFillerForTest.class,
        MySqlInsertTest.class
})
public class MySqlSuiteTest {
}
