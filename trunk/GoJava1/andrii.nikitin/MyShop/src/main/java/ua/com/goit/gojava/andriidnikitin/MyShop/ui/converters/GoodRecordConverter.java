package ua.com.goit.gojava.andriidnikitin.MyShop.ui.converters;

import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava.andriidnikitin.MyShop.commons.ErrorLogger;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.MyShop.ui.util.PrimeFacesUtil;

@Component
@RequestScoped
@FacesConverter("goodRecordConverter")
public class GoodRecordConverter implements Converter {
	
	@Autowired 	
	private GoodCatalog catalog;
	private Logger log = Logger.getLogger(getClass());

	public GoodCatalog getCatalog() {
		return catalog;
	}

	public void setCatalog(GoodCatalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
            try {
               return catalog.getGoodById(Integer.parseInt(value));
            } catch(Exception exception) {
            	ErrorLogger.logException(exception, log );
            	PrimeFacesUtil.addError("Record not found.");
            	return null;
            }
        }
        else {
        	return null;
        }
	}	

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Integer id = -1;
		if (arg2 instanceof GoodRecord){
			GoodRecord record = (GoodRecord)arg2;
			log.info(record);
			id  = record.getId();
		}
		return id.toString();
	}

}
