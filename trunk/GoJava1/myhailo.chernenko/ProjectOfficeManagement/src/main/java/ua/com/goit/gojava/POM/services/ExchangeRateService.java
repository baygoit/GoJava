package ua.com.goit.gojava.POM.services;

import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.ExchangeRateDAO;

public class ExchangeRateService {
	
	private static final String CLASS_NAME = "Exchange Rate"; 
	private static final Logger LOG = Logger.getLogger(ExchangeRateService.class);
	ExchangeRateDAO exchangeRateDAO;

	public void setExchangeRateDAO(ExchangeRateDAO exchangeRateDAO) {
		
		this.exchangeRateDAO = exchangeRateDAO;
		
	}

	public List<ExchangeRate> retrieveAll() throws POMServicesException {
		
		try {
			return exchangeRateDAO.retrieveAll();
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve all "+CLASS_NAME+"s: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve all "+CLASS_NAME+"s",e);
		}
	}

	public ExchangeRate retrieveById(long id) throws POMServicesException {
		
		try {
			return exchangeRateDAO.retrieveById(id);
		} catch (POMPersistenceException e) {
			LOG.error("Could not retrieve "+CLASS_NAME+" by ID: "+e.getMessage(), e);
			throw new POMServicesException("Could not retrieve "+CLASS_NAME+" by ID",e);
		}
	}

	public void delete(ExchangeRate exchangeRate) throws POMServicesException {

		try {
			exchangeRateDAO.delete(exchangeRate);
		} catch (POMPersistenceException e) {
			LOG.error("Could not delete "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not delete "+CLASS_NAME+"",e);
		}
	}

	public void create(ExchangeRate newRate) throws POMServicesException {

		try {
			exchangeRateDAO.create(newRate);
		} catch (POMPersistenceException e) {
			LOG.error("Could not create "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not create "+CLASS_NAME+"",e);
		}
	}

	public void update(ExchangeRate exchangeRate) throws POMServicesException {

		try {
			exchangeRateDAO.update(exchangeRate);
		} catch (POMPersistenceException e) {
			LOG.error("Could not update "+CLASS_NAME+": "+e.getMessage(), e);
			throw new POMServicesException("Could not update "+CLASS_NAME+"",e);
		}
	}

}
