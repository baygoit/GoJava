package ua.com.goit.gojava.POM.presentation.beans.profitcost;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.CostItemService;
import ua.com.goit.gojava.POM.services.POMServicesException;


@RequestScoped
@ManagedBean
public class CostItemEditorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG=Logger.getLogger(CostItemEditorBean.class);
	private CostItem costItem;
	
	public void setCostItem(CostItem costItem) {
		this.costItem = costItem;
	}

	public CostItem getCostItem() {
		if(costItem == null){			
			costItem = new CostItem();
		}
		return costItem;
	}
	
	public void save() {
		
		CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
		try {
			if(costItem.getId() == 0) {
				costItemService.create(costItem);
			} else {
				costItemService.update(costItem);
			}
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Complete!", "CostItem saved!"));
		
		} catch (POMServicesException e) {
			LOG.error("Can not save CostItem: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not save CostItem!"));
		}
	}
	
}
