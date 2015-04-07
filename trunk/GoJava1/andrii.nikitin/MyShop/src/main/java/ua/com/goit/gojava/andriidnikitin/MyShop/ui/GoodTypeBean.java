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
public class GoodTypeBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired 
	@ManagedProperty(value="#{catalog}")
	private GoodCatalog catalog;

	@ManagedProperty(value="#{name}")
	private String name;

	@ManagedProperty(value="#{id}")
	private Integer id;

	@ManagedProperty(value="#{parentId}")	
	private Integer parentId;
	
	private Logger log = Logger.getLogger(getClass());
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parentId==null? "" : parentId.toString();
	}

	public void setParent(String input) {
		if (input == null){ 
			this.parentId = null;	
		}
		else {
			this.parentId = Integer.parseInt(input);
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
			ErrorLogger.logException(e, Logger.getLogger(GoodTypeBean.class));
		}
		return null;
	}

	public String addType(){		
		try {
			catalog.createType(name, parentId);
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodTypeBean.class));
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
				catalog.updateGoodType(id, name, parentId);
				clearForm();
			}
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodTypeBean.class));
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
			ErrorLogger.logException(e, Logger.getLogger(GoodTypeBean.class));
		}
		return "";
	}
	
	private String validateExistance(Integer id){
		try {
			if (catalog.getGoodTypeById(id)!= null){
				return "such type does not exist!";
			}
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodTypeBean.class));
		}
		return null;
		
	}

	private void clearForm(){
		setName("");
		setParent(null);
		setId(null);
	}

}