package ua.com.goit.gojava.POM.presentation.actions.bankaccount;

import java.util.Currency;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import com.opensymphony.xwork2.ActionSupport;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.POMServicesException;

@Configurable(autowire=Autowire.BY_TYPE)
public class BankAccountSaver extends ActionSupport {

	private static final long serialVersionUID = -3450043051898248690L;
	private static final Logger LOG=Logger.getLogger(BankAccountSaver.class);
	@Inject
	private BankAccountService bankAccountService;
	
	private long id;
	private String name;
	private String bankName;
	private String currencyCode;
	private boolean cancel;

	public String execute() throws Exception {
		
		try {
			if(cancel != true) {
				saveObject();
			}
			return ActionSupport.SUCCESS;
		} catch(POMDataModelException e) {
			LOG.error("Can not save Bank Account: "+e.getMessage(),e);
			addActionError("Can not save Bank Account!"); 
			return ActionSupport.ERROR;
		}
	
	}
	
	private void saveObject() throws POMDataModelException, POMPersistenceException, POMServicesException {

		BankAccount bankAccount;
		if(id == 0) {
			bankAccount = new BankAccount();
		} else {
			bankAccount = bankAccountService.retrieveById(id); 
		}
		
		bankAccount.setName(name);
		bankAccount.setBankName(bankName);
		
		if(!currencyCode.isEmpty()) {
			bankAccount.setCurrency(Currency.getInstance(currencyCode));
		}
		
		if(id == 0) {
			bankAccountService.create(bankAccount);
		} else {
			bankAccountService.update(bankAccount);
		}
		
	}

	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}
	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isCancel() {
		return cancel;
	}
	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}
	
}
