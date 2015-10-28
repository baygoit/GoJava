package ua.com.goit.gojava.andriidnikitin.MyShop.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

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
@ManagedBean(name = "goodBean")
@RequestScoped
public class GoodBean implements Serializable{

	private static final long serialVersionUID = 2L;

	@Autowired 	
	private BusinessServiceHandler businessService;

	@ManagedProperty(value="#{name}")
	private String name;

	@ManagedProperty(value="#{id}")
	private Integer id;

	@ManagedProperty(value="#{type}")	
	private GoodType type;
	
	@ManagedProperty(value="#{chosenGood}")	
	private Good chosenGood;	

	@ManagedProperty(value="#{chosenType}")	
	private GoodType chosenType;	

	public GoodType getChosenType() {
		return chosenType;
	}

	public void setChosenType(GoodType chosenType) {
		this.chosenType = chosenType;
	}
	
	public void recieveChosenTypeFromEvent(ActionEvent event) {
		this.chosenType = (GoodType)event.getComponent().getAttributes().get("chosenType");
		System.out.println("listened" + chosenType.getName());
	}	
	
	@ManagedProperty(value="#{allGoods}")
	private List<Good> allGoods;
	
	private Logger log = Logger.getLogger(getClass());
	
	public Good getChosenGood() {
		return chosenGood;
	}

	public void setChosenGood(Good chosenGood) {
		this.chosenGood = chosenGood;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		if (type==null){
			return null;
		}
		return type.getName();
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
	
	public void setBusinessService(BusinessServiceHandler businessService) {
		this.businessService = businessService;
	}
	
	public List<Good> getAllGoods(){
		try {
			allGoods = businessService.getAllGoods();
		} catch (MyShopException e) {
			ErrorLogger.logException(e,log);
			allGoods = new ArrayList<Good>();
		}
		return allGoods;
	}	
	
	public List<Good> getGoodsByChosenType(){
		List<Good> result = null;
		try {
			result =  businessService.getGoodsByType(chosenType);
		} catch (MyShopException e) {
			log.error(e);
			result = new ArrayList<Good>();
			PrimeFacesUtil.addFatalError("Something goes wrong...");
		}
		System.out.println("chosen type" + chosenType);
		for (Good good: result){
			System.out.println("-" + good.getName());
		}
		return result;
	}
	
	public void addGood(){	
		try {
			log.info("Chosen type is " + chosenType);
			businessService.createGood(name, chosenType.getId());
			PrimeFacesUtil.addMessage("Good was successfully created.");
			clearForm();
		} catch (MyShopException e) {
			ErrorLogger.logException(e, log);
			PrimeFacesUtil.addError("Fail to create good.");
		}
	}
	
	public void updateGood(){
		Integer oldId = (chosenGood==null ? null : chosenGood.getId());
		try {
				if (!checkForUpdates()){
					PrimeFacesUtil.addWarning("Nothing to update.");
					return;
				}
				businessService.updateGood(oldId, name, chosenType.getId());
				PrimeFacesUtil.addMessage("Good was successfully updated.");				
				clearForm();
		} catch (MyShopException e) {
			PrimeFacesUtil.addError("Fail to update good.");
			ErrorLogger.logException(e,log);
		}			
	}

	private Boolean checkForUpdates() {
		boolean notUpdateName = false;
		boolean notUpdateType = false;
		
		if (name == null){
			name = chosenGood.getName();
			notUpdateName = true;
		}
		else {
			if (name.equals(chosenGood.getName())){
				notUpdateName = true;						
			}
		}
		
		if (chosenType==null){
			chosenType = chosenGood.getType();
			notUpdateType = (chosenType!=null);
		}
		else{
			notUpdateType = (chosenType.equals(chosenGood.getType()));			
		}
			return !(notUpdateName && notUpdateType);
	}
	
	public void deleteGood(){	
		Integer oldId = chosenGood.getId();
		try {
				businessService.deleteGood(oldId);
				PrimeFacesUtil.addMessage("Good was successfully deleted.");				
				clearForm();
		} catch (MyShopException e) {
			PrimeFacesUtil.addError("Fail to delete good.");
			ErrorLogger.logException(e, log);			
		}			
	}
	
	private void clearForm(){
		setName("");
		type = null;
		setId(null);
		setChosenGood(null);
		setChosenType(null);
	}

}