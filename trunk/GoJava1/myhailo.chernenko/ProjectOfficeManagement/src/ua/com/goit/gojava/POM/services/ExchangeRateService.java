package ua.com.goit.gojava.POM.services;

import java.util.List;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;
import ua.com.goit.gojava.POM.persistence.postgresDB.ExchangeRateDAO;

public class ExchangeRateService {
	
	ExchangeRateDAO exchangeRateDAO;

	public void setExchangeRateDAO(ExchangeRateDAO exchangeRateDAO) {
		
		this.exchangeRateDAO = exchangeRateDAO;
		
	}

	public List<ExchangeRate> retrieveAll() throws POMDataModelException {
		
		return exchangeRateDAO.retrieveAll();
		
	}

	public ExchangeRate retrieveById(long id) throws POMDataModelException {
		
		return exchangeRateDAO.retrieveById(id);
		
	}

	public void delete(ExchangeRate exchangeRate) throws POMDataModelException {

		exchangeRateDAO.delete(exchangeRate);
		
	}

	public void create(ExchangeRate newRate) throws POMDataModelException {

		exchangeRateDAO.create(newRate);
		
	}

	public void update(ExchangeRate exchangeRate) throws POMDataModelException {

		exchangeRateDAO.update(exchangeRate);
		
	}

}
