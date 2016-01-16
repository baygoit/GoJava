package integration.MySqlSuiteTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MySqlEmptyIT.class,
        MySqlFillerForIT.class,
        MySqlInsertIT.class
})
public class MySqlSuiteIT {
}
