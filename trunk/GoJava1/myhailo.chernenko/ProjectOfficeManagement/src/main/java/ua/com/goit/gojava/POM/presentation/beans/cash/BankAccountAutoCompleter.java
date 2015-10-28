package ua.com.goit.gojava.POM.presentation.beans.cash;

import java.io.Serializable;
import java.util.List;

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
public class BankAccountAutoCompleter implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(BankAccountAutoCompleter.class);

	public List<BankAccount> completeText(String query) {

		BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
		List<BankAccount> result = null;
		try {
			if(!query.isEmpty()){
				result = bankAccountService.findByName(query);
			} else {
				result = bankAccountService.retrieveAll();
			}
		} catch (POMServicesException e) {
			LOG.error("Can not retrieve BankAccount List: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not retrieve BankAccount List!"));
		}
		result.add(0, null);
		return result;
    }
}
