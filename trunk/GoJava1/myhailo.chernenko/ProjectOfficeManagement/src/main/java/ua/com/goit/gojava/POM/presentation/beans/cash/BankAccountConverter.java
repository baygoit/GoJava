package ua.com.goit.gojava.POM.presentation.beans.cash;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.BankAccount;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.BankAccountService;
import ua.com.goit.gojava.POM.services.POMServicesException;


@FacesConverter("bankAccountConverter")
public class BankAccountConverter implements Converter {

	private static final Logger LOG = Logger.getLogger(BankAccountConverter.class);
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		BankAccount result = null;
		
		if(arg2 != null && arg2.trim().length() > 0) {
			
			BankAccountService bankAccountService = ApplicationContextProvider.getApplicationContext().getBean(BankAccountService.class);
			try {
            	result = bankAccountService.retrieveById(Long.parseLong(arg2));    
            } catch( NullPointerException | IllegalArgumentException | POMServicesException e) {
            	LOG.error("Can not convert BankAccount: " + e.getMessage(), e);
            	arg0.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not convert BankAccount: !"));
    		}
        }
		
		return result;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		String objName = "";
		if(arg2 != null) {
			objName = ((Long)((BankAccount)arg2).getId()).toString();
        }

		return objName;
	}

}
