package ua.com.goit.gojava.POM.presentation.actions.bankaccount;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import com.opensymphony.xwork2.ActionSupport;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.services.BankAccountService;

@Configurable(autowire=Autowire.BY_TYPE)
public class BankAccountCreatorLoader extends ActionSupport {

	private static final long serialVersionUID = 1627825568890651904L;
	private static final Logger LOG=Logger.getLogger(BankAccountCreatorLoader.class);
	@Inject
	private BankAccountService bankAccountService;
	
	private long id;
	private BankAccount bankAccount;
	private Map<String,String> currenciesMap;
	
	public String execute() throws Exception {
		
		bankAccount = new BankAccount();
		if(id != 0) {
		
			try {
				
				BankAccount bankAccountForCopy = bankAccountService.retrieveById(id);
				bankAccount.setName(bankAccountForCopy.getName());
				bankAccount.setBankName(bankAccountForCopy.getBankName());
				bankAccount.setCurrency(bankAccountForCopy.getCurrency());
				
			} catch(POMDataModelException e) {
				
				LOG.error("Can not copy Bank Account: "+e.getMessage(),e);
				addActionError("Can not copy Bank Account!");
				return ActionSupport.ERROR;
			}
			
		}
		
		currenciesMap = new HashMap<String,String>();
		for(Currency currency: Currency.getAvailableCurrencies()) {
			currenciesMap.put(currency.getCurrencyCode(), currency.getCurrencyCode());
		};
		
		return ActionSupport.SUCCESS;
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
