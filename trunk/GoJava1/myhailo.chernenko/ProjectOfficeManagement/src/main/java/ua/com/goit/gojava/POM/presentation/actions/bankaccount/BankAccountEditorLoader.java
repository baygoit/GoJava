package ua.com.goit.gojava.POM.presentation.actions.bankaccount;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import com.opensymphony.xwork2.ActionSupport;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.POMServicesException;

@Configurable(autowire=Autowire.BY_TYPE)
public class BankAccountEditorLoader extends ActionSupport {

	private static final long serialVersionUID = 5935835332123968813L;
	private static final Logger LOG=Logger.getLogger(BankAccountEditorLoader.class);
	@Inject
	private BankAccountService bankAccountService;
	
	private long id;
	private BankAccount bankAccount;
	private Map<String,String> currenciesMap;
	
	public String execute() throws Exception {
		
		try {
			
			bankAccount = bankAccountService.retrieveById(id);
			currenciesMap = new HashMap<String,String>();
			for(Currency currency: Currency.getAvailableCurrencies()) {
				currenciesMap.put(currency.getCurrencyCode(), currency.getCurrencyCode());
			};
			return ActionSupport.SUCCESS;
			
		} catch(POMServicesException e) {
			
			LOG.error("Can not load Bank Account for edit: "+e.getMessage(),e);
			addActionError("Can not load Bank Account for edit!");
			return ActionSupport.ERROR;
		}
			
	}
	
	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}
	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Map<String, String> getCurrenciesMap() {
		return currenciesMap;
	}
}
