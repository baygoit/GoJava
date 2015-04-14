package ua.com.goit.gojava.andriidnikitin.MyShop.ui.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class PrimeFacesUtil {
	
	 public static void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  "");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	 
	 public static void addWarning(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, summary,  "");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	 
	 public static void addError(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary,  "");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	 
	 public static void addFatalError(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary,  "");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
}
