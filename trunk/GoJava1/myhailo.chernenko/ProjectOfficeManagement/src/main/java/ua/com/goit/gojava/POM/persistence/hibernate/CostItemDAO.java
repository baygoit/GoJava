package ua.com.goit.gojava.POM.persistence.hibernate;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;

public class CostItemDAO extends AbstractDAO<CostItem> {
	
	private static final String CLASS_NAME = "Cost Item"; 
	private static final Logger LOG = Logger.getLogger(CostItemDAO.class);
	
	public CostItemDAO() {
		super(CostItem.class);
	}

	@Override
	protected String getClassName() {		
		return CLASS_NAME;
	}

	@Override
	protected Logger getLog() {	
		return LOG;	
	}

	@Override
	protected CostItem getNewObject() {
		return new CostItem();	
	}

}
