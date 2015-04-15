package ua.com.goit.gojava.POM.presentation.beans.profitcost;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.CostItemService;
import ua.com.goit.gojava.POM.services.POMServicesException;


@FacesConverter(forClass = CostItem.class)
public class CostItemConverter implements Converter {

	private static final Logger LOG = Logger.getLogger(CostItemConverter.class);
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		CostItem result = null;
		
		if(arg2 != null && arg2.trim().length() > 0) {
			
			CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
			try {
            	result = costItemService.retrieveById(Long.parseLong(arg2));    
            } catch( NullPointerException | IllegalArgumentException | POMServicesException e) {
            	LOG.error("Can not convert CostItem: " + e.getMessage(), e);
            	arg0.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not convert CostItem: !"));
    		}
        }
		
		return result;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		String objName = "";
		if(arg2 != null) {
			objName = ((Long)((CostItem)arg2).getId()).toString();
        }

		return objName;
	}

}
