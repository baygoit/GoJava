package ua.com.goit.gojava.andriidnikitin.MyShop.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava.andriidnikitin.MyShop.commons.ErrorLogger;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.BusinessServiceHandler;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;
import ua.com.goit.gojava.andriidnikitin.MyShop.ui.util.PrimeFacesUtil;

@Component
@Scope("session")
@ManagedBean(name = "autocompleteBean")
@RequestScoped
public class AutocompleteBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired 	
	private BusinessServiceHandler businessService;	
	
	private Logger log = Logger.getLogger(getClass());
	
	public void setBusinessService(BusinessServiceHandler businessService) {
		this.businessService = businessService;
	}

	public List<Good> completeGood(String query){
		List<Good> filteredGoods;
		try{
			filteredGoods = businessService.getGoodsFilteringByName(query);
		} catch (MyShopException e) {
			ErrorLogger.logException(e, log);
			PrimeFacesUtil.addError("Fail to get data.");
			filteredGoods = new ArrayList<Good>();
		}
	    return filteredGoods;
	}
	
	public List<GoodType> completeType(String query){List<GoodType> filteredTypes;
		try{
			filteredTypes = businessService.getGoodTypesFilteringByName(query);
		} catch (MyShopException e) {
			ErrorLogger.logException(e, log);
			PrimeFacesUtil.addError("Fail to get data.");
			filteredTypes = new ArrayList<GoodType>();
		}
		for (GoodType item: filteredTypes){
			log.info(item);
		}
	    return filteredTypes;
	}	
}