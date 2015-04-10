package ua.com.goit.gojava.POM.presentation.beans.cash;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.CashMovementService;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.Paginator;


@SessionScoped
@ManagedBean
public class BankAccountListBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG=Logger.getLogger(BankAccountListBean.class);
	private LazyDataModel<BankAccount> bankAccounts;
	
	private LazyDataModel<BankAccount> initBankAccounts() {
		
		return new LazyDataModel<BankAccount>() {

			private static final long serialVersionUID = 1L;
			
			private List<BankAccount> bankAccountList;
			
			@Override
			public List<BankAccount> load(int first, int pageSize, 
							String sortField, SortOrder sortOrder, Map<String,Object> filters) {
				
				BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
				Paginator paginator = new Paginator();
				paginator.setFirstResult(first);
				paginator.setMaxResults(pageSize);
				
				try {
					bankAccountList = bankAccountService.retrieveAll(paginator);
				} catch (POMServicesException e) {
					LOG.error("Can not retrieve BankAccount List: " + e.getMessage(), e);
					FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not retrieve BankAccount List!"));
				}
				
				setRowCount(paginator.getTotal());
		        setPageSize(pageSize);
		 
		        return bankAccountList;
		    }
			
			@Override
			public Object getRowKey(BankAccount bankAccount) {
				return bankAccount.getId();
			}

			@Override
			public BankAccount getRowData(String bankAccountId) {
				Long id = Long.valueOf(bankAccountId);
				for (BankAccount bankAccount : bankAccountList) {
					if (id.equals(bankAccount.getId())) {
						return bankAccount;
					}
				}
				return null;
			}
		};
	}

	public void deleteBankAccount(BankAccount bankAccount){
		
		BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
		try {
			bankAccountService.delete(bankAccount);
		} catch (POMServicesException e) {
			LOG.error("Can not delete BankAccount: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not delete BankAccount!"));
		}
	}
	
	public Money getTotal(BankAccount bankAccount){
		
		Money result = null;
		CashMovementService cashMovementService = ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);
		try {
			result = cashMovementService.getTotalByBankAccount(bankAccount);
		} catch (POMServicesException e) {
			LOG.error("Can not retrieve Total by BankAccount: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not retrieve Total by BankAccount!"));
		}
		return result;
		
	}
	 
	public LazyDataModel<BankAccount> getBankAccounts() {
		if(bankAccounts == null){			
			bankAccounts = initBankAccounts();
		}
		return bankAccounts;
	}
	
	// Temporary solution for step-by-step migration on JSF.
	// This method redirects to non JSF pages
	public String redirectTo(String action, long id) {
		
		FacesContext context = FacesContext.getCurrentInstance();  
		String rootRef  = context.getExternalContext().getRequestContextPath();  
		HttpServletResponse response  = ((HttpServletResponse)context.getExternalContext().getResponse());  
	    try {
	    	//throw new IOException("Can not redirect to");
	    	String url = rootRef + "/" + action + ((id == 0)? ("") : ("?id=" + id));
			response.sendRedirect(url);
		} catch (IOException e) {
			LOG.error("Can not redirect to "+action+": " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not redirect to "+action+"!"));
		}  
	    context.responseComplete();  
		return action;
	}
	
}
