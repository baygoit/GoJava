package ua.com.goit.gojava.andriidnikitin.MyShop.ui;

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
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;

@Component
@Scope("session")
@ManagedBean(name = "goodBean", eager = true)
@RequestScoped
public class GoodBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired 
	private GoodCatalog catalog;

	@ManagedProperty(value="#{name}")
	private String name;

	@ManagedProperty(value="#{id}")
	private Integer id;

	@ManagedProperty(value="#{type}")	
	private Integer type;
	
	private Logger log = Logger.getLogger(getClass());
	
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
			return catalog.getAllGoods();
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodBean.class));
		}
		return null;
	}

	public String addGood(){		
		try {
			catalog.createGood(name, type);
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodBean.class));
		}

		clearForm();

		return "";
	}
	
	public String updateGood(){		
		try {
			String validation = validateExistance(id);
			if (validation !=null){
				return validation;
			}
			else {
				catalog.updateGood(id, name, type);
				clearForm();
			}
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodBean.class));
		}
		return "";
	}
	
	public String deleteGood(){	
		try {
			String validation = validateExistance(id);
			if (validation !=null){
				return validation;
			}
			else {
				catalog.deleteGood(id);
				clearForm();
			}
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodBean.class));
		}
		return "";
	}
	
	private String validateExistance(Integer id){
		try {
			if (catalog.getGoodById(id) == null){
				return "such good does not exist!";
			}
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodBean.class));
		}
		return null;
		
	}

	private void clearForm(){
		setName("");
		setType(null);
		setId(null);
	}

}