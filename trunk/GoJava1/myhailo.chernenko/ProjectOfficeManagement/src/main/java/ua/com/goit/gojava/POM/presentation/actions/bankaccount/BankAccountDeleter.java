package ua.com.goit.gojava.POM.presentation.actions.bankaccount;

import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import com.opensymphony.xwork2.ActionSupport;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.services.BankAccountService;

@Configurable(autowire=Autowire.BY_TYPE)
public class BankAccountDeleter extends ActionSupport {

	private static final long serialVersionUID = -5101172404895872222L;
	private static final Logger LOG=Logger.getLogger(BankAccountDeleter.class);
	@Inject
	private BankAccountService bankAccountService;
	
	private long id;
	
	public String execute() throws Exception {
		
		try {
			bankAccountService.delete(bankAccountService.retrieveById(id));
			return ActionSupport.SUCCESS;
		} catch(POMDataModelException e) {
			LOG.error("Can not delete Bank Account: "+e.getMessage(),e);
			addActionError("Can not delete Bank Account!"); 
			return ActionSupport.ERROR;
		}
	
	}
	
	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}
	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
