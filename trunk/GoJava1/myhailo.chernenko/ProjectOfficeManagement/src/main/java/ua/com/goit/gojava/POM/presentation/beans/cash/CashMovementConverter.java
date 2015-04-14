package ua.com.goit.gojava.POM.presentation.beans.cash;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.CashMovementService;
import ua.com.goit.gojava.POM.services.POMServicesException;


@FacesConverter(forClass = CashMovementEntry.class)
public class CashMovementConverter implements Converter {

	private static final Logger LOG = Logger.getLogger(CashMovementConverter.class);
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		CashMovementEntry result = null;
		
		if(arg2 != null && arg2.trim().length() > 0) {
			
			CashMovementService cashMovementService = ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);
			try {
            	result = cashMovementService.retrieveById(Long.parseLong(arg2));    
            } catch( NullPointerException | IllegalArgumentException | POMServicesException e) {
            	LOG.error("Can not convert CashMovementEntry: " + e.getMessage(), e);
            	arg0.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not convert CashMovementEntry: !"));
    		}
        }
		
		return result;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		String objName = "";
		if(arg2 != null) {
			objName = ((Long)((CashMovementEntry)arg2).getId()).toString();
        }

		return objName;
	}

}
