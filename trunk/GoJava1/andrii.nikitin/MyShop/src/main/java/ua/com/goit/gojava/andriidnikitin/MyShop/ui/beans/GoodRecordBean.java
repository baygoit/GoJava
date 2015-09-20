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
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodRecord;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.BusinessServiceHandler;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;
import ua.com.goit.gojava.andriidnikitin.MyShop.ui.util.PrimeFacesUtil;

@Component
@Scope("session")
@ManagedBean(name = "goodRecordBean")
@RequestScoped
public class GoodRecordBean implements Serializable{

	private static final long serialVersionUID = 2L;

	@Autowired 	
	private BusinessServiceHandler businessService;

	@ManagedProperty(value="#{good}")
	private Good good;

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GoodRecord getChosenRecord() {
		return chosenRecord;
	}

	public void setChosenRecord(GoodRecord chosenRecord) {
		this.chosenRecord = chosenRecord;
	}

	public void setAllRecords(List<GoodRecord> allRecords) {
		this.allRecords = allRecords;
	}

	public Logger getLog() {
		return log;
	}

	@ManagedProperty(value="#{id}")
	private Integer id;

	@ManagedProperty(value="#{chosenRecord}")	
	private GoodRecord chosenRecord;

	@ManagedProperty(value="#{allRecords}")
	private List<GoodRecord> allRecords;
	
	private Logger log = Logger.getLogger(getClass());

	@ManagedProperty(value="#{amount}")
	private Integer amount;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer quantity) {
		this.amount = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@ManagedProperty(value="#{price}")
	private Integer price;
	
	public void setBusinessService(BusinessServiceHandler businessService) {
		this.businessService = businessService;
	}
	
	public List<GoodRecord> getAllRecords(){
		try {
			allRecords = businessService.getAllRecords();
		} catch (MyShopException e) {
			ErrorLogger.logException(e,log);
			allRecords = new ArrayList<GoodRecord>();
		}
		return allRecords;
	}	
	
	public void addRecord(){	
		try {
			log.info("Chosen good is " + good);
			businessService.deliverGood(good, amount, price);
			PrimeFacesUtil.addMessage("Good was successfully created.");
			clearForm();
		} catch (MyShopException e) {
			ErrorLogger.logException(e, log);
			PrimeFacesUtil.addError("Fail to create good.");
		}
	}
	/*
	public void updateGood(){	
		Integer oldId = chosenGood.getId();
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
	}*/
	
	private void clearForm(){/*
		setName("");
		type = null;
		setId(null);
		setChosenGood(null);
		setChosenType(null);*/
	}

}