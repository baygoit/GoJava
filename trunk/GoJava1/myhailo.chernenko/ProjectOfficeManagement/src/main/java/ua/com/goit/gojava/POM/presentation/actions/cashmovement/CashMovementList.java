package ua.com.goit.gojava.POM.presentation.actions.cashmovement;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.POMServicesException;

@Configurable(autowire=Autowire.BY_TYPE)
public class CashMovementList extends ActionSupport {

	private static final long serialVersionUID = 8584494629967226365L;
	private static final Logger LOG=Logger.getLogger(CashMovementList.class);
	@Inject
	private BankAccountService bankAccountService;
	
	private long bankAccountId;
	
	public String execute() throws Exception {
			
		  BankAccount bankAccountFilter = null;
		  if(bankAccountId != 0 ) {		  
			  	try {
			  		bankAccountFilter = bankAccountService.retrieveById(bankAccountId);	
				} catch(POMServicesException e) {
					
					LOG.error("Can not load Bank Account for filtering: "+e.getMessage(),e);
					addActionError("Can not load Bank Account for filtering!");
					return ActionSupport.ERROR;
				}
		  }
		  ActionContext.getContext().getSession().put("bankAccountFilterValue", bankAccountFilter);
			
	      return ActionSupport.SUCCESS;
	 }

	public long getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}
	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}
}
