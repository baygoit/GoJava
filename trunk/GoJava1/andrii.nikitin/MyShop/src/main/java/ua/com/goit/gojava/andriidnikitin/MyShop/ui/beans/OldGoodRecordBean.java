package ua.com.goit.gojava.andriidnikitin.MyShop.ui.beans;

import java.io.Serializable;
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

@Component
@Scope("session")
@ManagedBean(name = "goodRecordBean", eager = true)
@RequestScoped
public class OldGoodRecordBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired 	
	private BusinessServiceHandler businessService;

	@ManagedProperty(value="#{id}")
	private Integer id;

	@ManagedProperty(value="#{good}")	
	private Integer good;
	
	@ManagedProperty(value="#{amount}")	
	private Integer amount;
	
	@ManagedProperty(value="#{price}")	
	private Integer price;
	
	private Logger log = Logger.getLogger(OldGoodRecordBean.class);
		
	public String getGood() {
		return good==null? "" : good.toString();
	}

	public void setGood(String input) {
		this.good = null;	
		if (input != null){ 
			try{
				this.good = Integer.parseInt(input);
			} catch (NumberFormatException exception){				
			}
		}
	}
	
	
	
	public String getPrice() {
		return getIntAttribute(price);
	} 

	public void setPrice(String input) {
		price = setIntAttribute(input);
	}
	
	public String getAmount() {
		return getIntAttribute(amount);
	}	
	
	public void setAmount(String input) {
		amount = setIntAttribute(input);
	}

	public String getId() {
		return getIntAttribute(id);
	} 

	public void setId(String input) {
		id = setIntAttribute(input);
	}

	public void setBusinessService(BusinessServiceHandler businessService) {
		this.businessService = businessService;
	}

	public List<GoodRecord> getAllRecords(){
		try {		
			return businessService.getAllRecords();
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(OldGoodRecordBean.class));
		}
		return null;
	}

	public String addRecord(){	
		try {
			Good goodInstance = businessService.getGoodById(good);
			log.info(goodInstance);
			businessService.deliverGood(goodInstance, amount, price);
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(OldGoodRecordBean.class));
		}

		clearForm();

		return "";
	}
	
	
	@SuppressWarnings("unused")
	private String validateExistance(Integer id){
		try {
			if (businessService.getRecord(id) == null){
				return "such record does not exist!";
			}
		} catch (MyShopException e) {
			ErrorLogger.logException(e, log);
		}
		return null;
		
	}

	private void clearForm(){
		setGood(null);
		setId(null);
		setAmount(null);
		setPrice(null);
	}
	
	private String getIntAttribute(Integer arg){
		return arg==null? "" : arg.toString();
	}
	
	private Integer setIntAttribute(String input) {
		if (input == null){ 
			return null;	
		}
		else {
			return Integer.parseInt(input);
		}
	}

}