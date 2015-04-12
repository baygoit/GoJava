package ua.com.goit.gojava.andriidnikitin.MyShop.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava.andriidnikitin.MyShop.commons.ErrorLogger;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.Good;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;
import ua.com.goit.gojava.andriidnikitin.MyShop.ui.util.PrimeFacesUtil;

@Component
@Scope("session")
@ManagedBean(name = "goodBean")
@RequestScoped
public class GoodBean implements Serializable{

	private static final long serialVersionUID = 2L;
	
	@Autowired 	
	private GoodCatalog catalog;

	@ManagedProperty(value="#{name}")
	private String name;

	@ManagedProperty(value="#{id}")
	private Integer id;

	@ManagedProperty(value="#{type}")	
	private Integer type;
	
	@ManagedProperty(value="#{chosenGood}")	
	private Good chosenGood;	

	@ManagedProperty(value="#{allGoods}")
	private List<Good> allGoods;
	
	private Logger log = Logger.getLogger(getClass());

	private List<Good> filteredGoods;
	
	private String previousQuery;	

	public Good getChosenGood() {
		log.info("recieving chosen good " + chosenGood );
		return chosenGood;
	}

	public void setChosenGood(Good chosenGood) {
		log.info("setting chosen good with id=" + chosenGood.getId());
		this.chosenGood = chosenGood;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type==null? "" : type.toString();
	}

	public void setType(String input) {
		this.type = null;	
		if (input != null){ 
			try{
				this.type = Integer.parseInt(input);
			} catch (NumberFormatException exception){				
			}
		}
	}
	
	public String getId() {
		return id==null? "" : id.toString();
	} 

	public void setId(String input) {
		if (input == null){ 
			this.id = null;	
		}
		else {
			this.id = Integer.parseInt(input);
		}
	}

	public void setGoodCatalog(GoodCatalog catalog) {
		this.catalog = catalog;
	}
	
	public List<Good> getAllGoods(){
		try {
			allGoods = catalog.getAllGoods();
		} catch (MyShopException e) {
			ErrorLogger.logException(e,log);
			allGoods = new ArrayList<Good>();
		}
		return allGoods;
	}	
	
	public void addGood(){	
		try {
			catalog.createGood(name, type);
			PrimeFacesUtil.addMessage("Good was successfully created.");
		} catch (MyShopException e) {
			ErrorLogger.logException(e, log);
			PrimeFacesUtil.addError("Fail to create good.");
		}
		clearForm();
	}
	
	public void updateGood(){		
		try {
			if (validateExistance(id)){
				catalog.updateGood(id, name, type);
				PrimeFacesUtil.addMessage("Good was successfully updated.");
			}
		} catch (MyShopException e) {
			PrimeFacesUtil.addError("Fail to update good.");
			ErrorLogger.logException(e,log);
		}						
		clearForm();
	}
	
	public void deleteGood(){	
		try {
			if (validateExistance(id)){
				catalog.deleteGood(id);
				PrimeFacesUtil.addMessage("Good was successfully deleted.");
			}
		} catch (MyShopException e) {
			PrimeFacesUtil.addError("Fail to delete good.");
			ErrorLogger.logException(e, log);			
		}				
		clearForm();
	}
	
	public List<Good> completeGood(String query){
		Boolean useOlderResult = false;
		if (previousQuery!= null){
			useOlderResult = query.startsWith(previousQuery);
		}
		if (useOlderResult){
      	  return filteredPreviouslyExtractedResult(query);
		}
		try{
			filteredGoods = catalog.getGoodsFilteringByName(query);
		} catch (MyShopException e) {
			ErrorLogger.logException(e, log);
			PrimeFacesUtil.addError("Fail to get data.");
			filteredGoods = new ArrayList<Good>();
		}
		previousQuery = query;
        return filteredGoods;
	}

	private List<Good> filteredPreviouslyExtractedResult(String query) {
		List<Good> result = new ArrayList<Good>();
		for (int i = 0; i < filteredGoods.size(); i++) {
		     Good good = filteredGoods.get(i);
		     if((good.getName()).toLowerCase().startsWith(query)) {
		    	 result.add(good);
		     }
		}      
	    return result;
	}
	
	private Boolean validateExistance(Integer id){
		try {
			if (catalog.getGoodById(id) == null){
				PrimeFacesUtil.addWarning("Such good does not exist.");
				return false;
			}
		} catch (MyShopException e) {
			PrimeFacesUtil.addError("Fail to check good for existance.");			
			ErrorLogger.logException(e, log);
			return false;
		}
		return true;
		
	}

	private void clearForm(){
		setName("");
		setType(null);
		setId(null);
	}

}