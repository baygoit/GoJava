package ua.com.goit.gojava.POM.presentation.actions.bankaccount;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.CashMovementService;
import ua.com.goit.gojava.POM.services.Paginator;

import com.opensymphony.xwork2.ActionSupport;

@Configurable(autowire=Autowire.BY_TYPE)
public class BankAccountList extends ActionSupport {

	private static final long serialVersionUID = 6252551373098179983L;
	private static final Logger LOG=Logger.getLogger(BankAccountList.class);
	private Paginator paginator;
	private boolean previousPage;
	private boolean nextPage;
	@Inject
	private BankAccountService bankAccountService;
	@Inject
	private CashMovementService cashMovementService;
	
	private List<BankAccount> bankAccounts;
	
	public String execute() throws Exception {
		
		if (nextPage == true) {
			paginator.hextPage();
		} else if (previousPage == true) {
			paginator.previousPage();
		} else if(paginator == null) {
			paginator = new Paginator();
		}
		
		try {
			bankAccounts = bankAccountService.retrieveAll(paginator);
			return ActionSupport.SUCCESS;
		} catch(POMDataModelException e) {
			LOG.error("Can not load Bank Accounts list: "+e.getMessage(),e);
			addActionError("Can not load Bank Accounts list!");
			return ActionSupport.ERROR;
		}
		
	}
	
	public BankAccountService getBankAccountService() {
		return bankAccountService;
	}
	public void setBankAccountService(BankAccountService bankAccountService) {
		this.bankAccountService = bankAccountService;
	}
	public CashMovementService getCashMovementService() {
		return cashMovementService;
	}
	public void setCashMovementService(CashMovementService cashMovementService) {
		this.cashMovementService = cashMovementService;
	}
	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public Paginator getPaginator() {
		return paginator;
	}
	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}
	public boolean isPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(boolean previousPage) {
		this.previousPage = previousPage;
	}
	public boolean isNextPage() {
		return nextPage;
	}
	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}
	
}
