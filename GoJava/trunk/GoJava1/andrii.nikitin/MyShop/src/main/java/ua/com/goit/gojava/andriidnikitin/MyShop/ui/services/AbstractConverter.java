package ua.com.goit.gojava.andriidnikitin.MyShop.ui.services;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.MyShop.commons.ErrorLogger;
import ua.com.goit.gojava.andriidnikitin.MyShop.ui.util.PrimeFacesUtil;

public abstract class AbstractConverter<T> implements Converter {
	
	private Logger log = Logger.getLogger(getConverterClass());

	public Logger getLog() {
		return log;
	}


	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
            try {
               return getById(Integer.parseInt(value));
            } catch(Exception exception) {
            	ErrorLogger.logException(exception, log );
            	PrimeFacesUtil.addError("Not found.");
            	return null;
            }
        }
        else {
        	log.warn("null pointer recieved.");
        	return null;
        }
	}	


	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Integer id = -1;
		@SuppressWarnings("unchecked")
		T object = (T)arg2;
		log.info(object);
		id  = getId(object);
		return id.toString();
	}
	
	protected abstract Integer getId(T object);

	protected abstract T getById(Integer id);

	protected abstract String getConverterClass();

}
