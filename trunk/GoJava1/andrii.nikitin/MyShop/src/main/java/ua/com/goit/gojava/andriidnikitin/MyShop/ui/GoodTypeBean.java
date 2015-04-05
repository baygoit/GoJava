package ua.com.goit.gojava.andriidnikitin.MyShop.ui;

import java.io.Serializable;
import java.util.List;

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
public class GoodTypeBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	GoodCatalog catalog;

	public String name;
	
	public Integer goodTypeId;

	public Integer parentTypeId;

	private Logger log = Logger.getLogger(getClass());
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentTypeId==null? "" : parentTypeId.toString();
	}

	public void setParentId(String input) {
		if (input == null){ 
			this.parentTypeId = null;	
		}
		else {
			this.parentTypeId = Integer.parseInt(input);
		}
	}
	
	public String getTypeId() {
		return goodTypeId==null? "" : goodTypeId.toString();
	} 

	public void setTypeId(String input) {
		if (input == null){ 
			this.goodTypeId = null;	
		}
		else {
			this.goodTypeId = Integer.parseInt(input);
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
			catalog.createType(name, parentTypeId);
		} catch (MyShopException e) {
			ErrorLogger.logException(e, Logger.getLogger(GoodTypeBean.class));
		}

		clearForm();

		return "";
	}

	private void clearForm(){
		setName("");
		setParentId(null);
		setTypeId(null);
	}

}