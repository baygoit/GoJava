package ua.com.goit.gojava.POM.presentation.beans.cash;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.cash.CashMovementEntry;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.CashMovementService;
import ua.com.goit.gojava.POM.services.POMServicesException;


@SessionScoped
@ManagedBean
public class CashMovementEditorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG=Logger.getLogger(CashMovementEditorBean.class);
	private CashMovementEntry cashMovement = new CashMovementEntry();
	
	public void setCashMovement(CashMovementEntry cashMovement) {
		this.cashMovement = cashMovement;
	}

	public CashMovementEntry getCashMovement() {
		if(cashMovement == null){			
			cashMovement = new CashMovementEntry();
		}
		return cashMovement;
	}
	
	public String loadCashMovementEditor(CashMovementEntry cashMovement){
		
		setCashMovement(cashMovement);
		return "/appPages/cash/CashMovementEditor.xhtml";
	}
	
	public String loadCashMovementCreator(){
		
		setCashMovement(null);
		return "/appPages/cash/CashMovementEditor.xhtml";
	}

	
	public void save() {
		
		CashMovementService cashMovementService = ApplicationContextProvider.getApplicationContext().getBean(CashMovementService.class);
		try {
			if(cashMovement.getId() == 0) {
				cashMovementService.create(cashMovement);
			} else {
				cashMovementService.update(cashMovement);
			}
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Complete!", "CashMovement saved!"));
		
		} catch (POMServicesException e) {
			LOG.error("Can not save CashMovement: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not save CashMovement!"));
		}
	}
	
}
