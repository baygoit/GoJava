package ua.com.goit.gojava.POM.presentation.beans.cash;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.CashMovementService;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.Paginator;


@ViewScoped
@ManagedBean
public class CashMovementListBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG=Logger.getLogger(CashMovementListBean.class);
	private LazyDataModel<CashMovementEntry> cashMovements;
	private BankAccount bankAccountFilter;
	private CashMovementEntry selectedCashMovementEntry;
	
	private LazyDataModel<CashMovementEntry> initCashMovements() {
		
		return new LazyDataModel<CashMovementEntry>() {

			private static final long serialVersionUID = 1L;
			
			private List<CashMovementEntry> cashMovementList;
			
			@Override
			public List<CashMovementEntry> load(int first, int pageSize, 
							String sortField, SortOrder sortOrder, Map<String,Object> filters) {
				
				CashMovementService cashMovementService = ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);
				Paginator paginator = new Paginator();
				paginator.setFirstResult(first);
				paginator.setMaxResults(pageSize);
				
				try {
					if(bankAccountFilter == null) {
						cashMovementList = cashMovementService.retrieveAll(paginator);
					} else {
						cashMovementList = cashMovementService.retrieveAll(bankAccountFilter, paginator);
					}
				} catch (POMServicesException e) {
					LOG.error("Can not retrieve Cash Movement List: " + e.getMessage(), e);
					FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not retrieve Cash Movement List!"));
				}
				
				setRowCount(paginator.getTotal());
		        setPageSize(pageSize);
		 
		        return cashMovementList;
		    }
			
			@Override
			public Object getRowKey(CashMovementEntry cashMovement) {
				return cashMovement.getId();
			}

			@Override
			public CashMovementEntry getRowData(String cashMovementId) {
				Long id = Long.valueOf(cashMovementId);
				for (CashMovementEntry cashMovement : cashMovements) {
					if (id.equals(cashMovement.getId())) {
						return cashMovement;
					}
				}
				return null;
			}
		};
	}

	public void deleteCashMovement(CashMovementEntry cashMovement){
		
		if(cashMovement == null){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Nothing is done!", "Cash Movement not selected!"));
			return;
		}
		
		CashMovementService cashMovementService = ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);
		try {
			cashMovementService.delete(cashMovement);
		} catch (POMServicesException e) {
			LOG.error("Can not delete Cash Movement: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not delete Cash Movement!"));
		}
	}
	
	public LazyDataModel<CashMovementEntry> getCashMovements() {
		if(cashMovements == null){			
			cashMovements = initCashMovements();
		}
		return cashMovements;
	}
	
	public BankAccount getBankAccountFilter() {
		return bankAccountFilter;
	}

	public void setBankAccountFilter(BankAccount bankAccountFilter) {
		this.bankAccountFilter = bankAccountFilter;
	}

	public CashMovementEntry getSelectedCashMovementEntry() {
		return selectedCashMovementEntry;
	}

	public void setSelectedCashMovementEntry(
			CashMovementEntry selectedCashMovementEntry) {
		this.selectedCashMovementEntry = selectedCashMovementEntry;
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
