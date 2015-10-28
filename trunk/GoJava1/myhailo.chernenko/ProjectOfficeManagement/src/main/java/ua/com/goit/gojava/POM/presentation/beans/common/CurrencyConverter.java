package ua.com.goit.gojava.POM.presentation.beans.common;

import java.util.Currency;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;


@FacesConverter(forClass = Currency.class)
public class CurrencyConverter implements Converter {

	private static final Logger LOG = Logger.getLogger(CurrencyConverter.class);
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		Currency result = null;
		
		if(arg2 != null && arg2.trim().length() > 0) {
			
			try {
            	result = Currency.getInstance(arg2);    
            } catch( NullPointerException | IllegalArgumentException e) {
            	LOG.error("Can not convert Currency: " + e.getMessage(), e);
            	arg0.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not convert Currency: !"));
    		}
        }
		
		return result;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		String objName = "";
		if(arg2 != null) {
			objName = ((Currency)arg2).getCurrencyCode();
        }

		return objName;
	}

}
