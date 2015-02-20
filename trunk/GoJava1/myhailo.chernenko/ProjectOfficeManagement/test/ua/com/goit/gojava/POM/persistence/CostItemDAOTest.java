package ua.com.goit.gojava.POM.persistence;


import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.persistence.abstraction.GenericDAOTest;

public class CostItemDAOTest extends GenericDAOTest<CostItem> {

	public CostItemDAOTest() {
		super(CostItem.class);
	}

}
