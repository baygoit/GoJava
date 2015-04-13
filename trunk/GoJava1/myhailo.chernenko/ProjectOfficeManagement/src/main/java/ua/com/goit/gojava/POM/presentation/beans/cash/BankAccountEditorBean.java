package ua.com.goit.gojava.POM.presentation.beans.cash;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.POMServicesException;


@RequestScoped
@ManagedBean
public class BankAccountEditorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG=Logger.getLogger(BankAccountEditorBean.class);
	private BankAccount bankAccount;
	
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		if(bankAccount == null){			
			bankAccount = new BankAccount();
		}
		return bankAccount;
	}
	
	public void save() {
		
		BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
		try {
			if(bankAccount.getId() == 0) {
				bankAccountService.create(bankAccount);
			} else {
				bankAccountService.update(bankAccount);
			}
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Complete!", "BankAccount saved!"));
		
		} catch (POMServicesException e) {
			LOG.error("Can not save BankAccount: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not save BankAccount!"));
		}
	}
	
}
