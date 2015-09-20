package ua.com.goit.gojava.POM.presentation.beans.profitcost;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ua.com.goit.gojava.POM.dataModel.profitcost.CostItem;
import ua.com.goit.gojava.POM.services.ApplicationContextProvider;
import ua.com.goit.gojava.POM.services.CostItemService;
import ua.com.goit.gojava.POM.services.POMServicesException;
import ua.com.goit.gojava.POM.services.Paginator;


@ViewScoped
@ManagedBean
public class CostItemListBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG=Logger.getLogger(CostItemListBean.class);
	private LazyDataModel<CostItem> costItems;
	private CostItem selectedCostItem;
	
	private LazyDataModel<CostItem> initCostItems() {
		
		return new LazyDataModel<CostItem>() {

			private static final long serialVersionUID = 1L;
			
			private List<CostItem> costItemList;
			
			@Override
			public List<CostItem> load(int first, int pageSize, 
							String sortField, SortOrder sortOrder, Map<String,Object> filters) {
				
				CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
				Paginator paginator = new Paginator();
				paginator.setFirstResult(first);
				paginator.setMaxResults(pageSize);
				
				try {
					costItemList = costItemService.retrieveAll(paginator);
				} catch (POMServicesException e) {
					LOG.error("Can not retrieve CostItem List: " + e.getMessage(), e);
					FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not retrieve CostItem List!"));
				}
				
				setRowCount(paginator.getTotal());
		        setPageSize(pageSize);
		 
		        return costItemList;
		    }
			
			@Override
			public Object getRowKey(CostItem costItem) {
				return costItem.getId();
			}

			@Override
			public CostItem getRowData(String costItemId) {
				Long id = Long.valueOf(costItemId);
				for (CostItem costItem : costItemList) {
					if (id.equals(costItem.getId())) {
						return costItem;
					}
				}
				return null;
			}
		};
	}

	public void deleteCostItem(CostItem costItem){
		
		if(costItem == null){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Nothing is done!", "CostItem not selected!"));
			return;
		}
		
		CostItemService costItemService = ApplicationContextProvider.getApplicationContext().getBean(CostItemService.class);
		try {
			costItemService.delete(costItem);
			costItems = initCostItems();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Complete!", "CostItem deleted!"));
			
		} catch (POMServicesException e) {
			LOG.error("Can not delete CostItem: " + e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Can not delete CostItem!"));
		}
	}
	
	public LazyDataModel<CostItem> getCostItems() {
		if(costItems == null){			
			costItems = initCostItems();
		}
		return costItems;
	}
	
	public CostItem getSelectedCostItem() {
		return selectedCostItem;
	}

	public void setSelectedCostItem(CostItem selectedCostItem) {
		this.selectedCostItem = selectedCostItem;
	}
	
}
