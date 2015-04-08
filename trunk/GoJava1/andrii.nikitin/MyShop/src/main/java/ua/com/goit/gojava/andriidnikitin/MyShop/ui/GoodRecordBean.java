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
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;

@Component
@Scope("session")
@ManagedBean(name = "goodTypeBean", eager = true)
@RequestScoped
public class GoodRecordBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired 
	private GoodCatalog catalog;

	@ManagedProperty(value="#{name}")
	private String name;

	@ManagedProperty(value="#{id}")
	private Integer id;

	@ManagedProperty(value="#{parent}")	
	private Integer parent;
	
	private Logger log = Logger.getLogger(getClass());
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent==null? "" : parent.toString();
	}

	public void setParent(String input) {
		this.parent = null;	
		if (input != null){ 
			try{
				this.parent = Integer.parseInt(input);
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
		log.info("an instance of GoodCatalog was recieved");
	}

	public List<GoodType> getAllTypes(){
		try {
			return catalog.getAllTypes();
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodRecordBean.class));
		}
		return null;
	}

	public String addType(){		
		try {
			catalog.createType(name, parent);
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodRecordBean.class));
		}

		clearForm();

		return "";
	}
	
	public String updateType(){		
		try {
			String validation = validateExistance(id);
			if (validation !=null){
				return validation;
			}
			else {
				catalog.updateGoodType(id, name, parent);
				clearForm();
			}
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodRecordBean.class));
		}
		return "";
	}
	
	public String deleteType(){	
		try {
			String validation = validateExistance(id);
			if (validation !=null){
				return validation;
			}
			else {
				catalog.deleteGoodType(id);
				clearForm();
			}
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodRecordBean.class));
		}
		return "";
	}
	
	private String validateExistance(Integer id){
		try {
			if (catalog.getGoodTypeById(id) == null){
				return "such type does not exist!";
			}
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodRecordBean.class));
		}
		return null;
		
	}

	private void clearForm(){
		setName("");
		setParent(null);
		setId(null);
	}

}