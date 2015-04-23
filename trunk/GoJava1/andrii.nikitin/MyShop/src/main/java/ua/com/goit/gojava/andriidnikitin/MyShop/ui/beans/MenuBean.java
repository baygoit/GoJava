package ua.com.goit.gojava.andriidnikitin.MyShop.ui.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
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
@ManagedBean(name = "menuBean")
@RequestScoped
public class MenuBean {

	@Autowired 	
	private BusinessServiceHandler businessService;
	
    private MenuModel catalogModel = null;    

    private List<Good> chosenGoods;
    
    private GoodType chosenType;
 
    public MenuBean() {
    }
    
    public void initCatalogModel(){
    	catalogModel = new DefaultMenuModel();
        DefaultSubMenu mainSubmenu = new DefaultSubMenu("Categories");
        List<GoodType> types = null;
		try {
			types = businessService.getAllChildrenTypes();
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(getClass()));
			PrimeFacesUtil.addFatalError("Something gone wrong.");	
			types = new ArrayList<GoodType>();
		}
        for (GoodType type: types){
        	DefaultMenuItem item = new DefaultMenuItem(type.getName());
        	item.setOnclick("updateContents('" +type.getId().toString() + "')");
        	item.setUpdate("menuMessages");
            mainSubmenu.addElement(item);
        }   
        catalogModel.addElement(mainSubmenu); 
    }
 
    public MenuModel getCatalogModel() {
    	if (catalogModel == null){
            initCatalogModel();
    	}
        return catalogModel;
    }
}