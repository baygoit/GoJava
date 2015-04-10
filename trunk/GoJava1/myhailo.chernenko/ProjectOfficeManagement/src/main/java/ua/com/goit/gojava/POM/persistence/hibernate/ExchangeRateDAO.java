package ua.com.goit.gojava.POM.persistence.hibernate;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;

public class ExchangeRateDAO extends AbstractDAO<ExchangeRate> {
	
	private static final String CLASS_NAME = "Exchange Rate"; 
	private static final Logger LOG = Logger.getLogger(ExchangeRateDAO.class);
	
	public ExchangeRateDAO() {
		super(ExchangeRate.class);
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
	protected ExchangeRate getNewObject() {
		return new ExchangeRate();	
	}

}
