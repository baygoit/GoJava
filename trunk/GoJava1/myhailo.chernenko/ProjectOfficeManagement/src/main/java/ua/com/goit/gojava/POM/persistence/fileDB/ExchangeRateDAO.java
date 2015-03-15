package ua.com.goit.gojava.POM.persistence.fileDB;

import java.util.Currency;
import java.util.Date;
import java.util.List;

import ua.com.goit.gojava.POM.dataModel.common.ExchangeRate;

public class ExchangeRateDAO extends GenericDAO<ExchangeRate> {

	public ExchangeRateDAO(DAOFactory dataManager) {
	
		super(ExchangeRate.class, dataManager);
	
	}
	
	public ExchangeRate getLastOnDate(Date date, Currency fromCurrency, Currency toCurrency) {

		List<ExchangeRate> list = getList();
		Date lastDate = null; // instead of sorting...
		ExchangeRate findedExchangeRate = null;
		
		for(ExchangeRate exchangeRate : list) {
			if((exchangeRate.getFromCurrency() == fromCurrency)
					&&(exchangeRate.getToCurrency() == toCurrency)
					&&( (exchangeRate.getDate().before(date))
						 || (exchangeRate.getDate().equals(date))	)
					&&( (lastDate == null)
							 || (lastDate.before(exchangeRate.getDate()))	)){
				findedExchangeRate = exchangeRate;
				lastDate = exchangeRate.getDate();
			}
		}
	
		return findedExchangeRate;

	}

}
