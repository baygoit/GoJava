package ua.com.goit.gojava.POM.presentation.beans.profitcost;

import java.io.Serializable;
import java.util.List;

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
public class CostItemAutoCompleter implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(CostItemAutoCompleter.class);

	public List<CostItem> completeText(String query) {

		CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
		List<CostItem> result = null;
		try {
			if(!query.isEmpty()){
				result = costItemService.findByName(query);
			} else {
				result = costItemService.retrieveAll();
			}
		} catch (POMServicesException e) {
			LOG.error("Can not retrieve CostItem List: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not retrieve CostItem List!"));
		}
		result.add(0, null);
		return result;
    }
}
