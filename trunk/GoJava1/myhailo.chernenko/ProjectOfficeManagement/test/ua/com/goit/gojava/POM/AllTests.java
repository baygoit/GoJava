package ua.com.goit.gojava.POM;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ua.com.goit.gojava.POM.dataModel.*;
import ua.com.goit.gojava.POM.persistence.*;

@RunWith(Suite.class)
@SuiteClasses({ 
		CostItemTest.class, 
		CostItemTransactionTest.class,
		ProjectFinResultTransactionTest.class, 
		ProjectStageTest.class,
		ProjectTest.class,
		DataManagerTest.class,
		//GenericDAOTest.class
		ProjectDAOTest.class,
		CostItemDAOTest.class
	})
public class AllTests {

}
