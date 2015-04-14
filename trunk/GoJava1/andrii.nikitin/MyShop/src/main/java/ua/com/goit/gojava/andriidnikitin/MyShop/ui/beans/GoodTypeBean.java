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
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.BusinessServiceHandler;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.util.MyShopException;
import ua.com.goit.gojava.andriidnikitin.MyShop.ui.util.PrimeFacesUtil;

@Component
@Scope("session")
@ManagedBean(name = "goodTypeBean")
@RequestScoped
public class GoodTypeBean implements Serializable{

	private static final long serialVersionUID = 2L;

	@Autowired 	
	private BusinessServiceHandler businessService;

	@ManagedProperty(value="#{name}")
	private String name;

	@ManagedProperty(value="#{id}")
	private Integer id;

	@ManagedProperty(value="#{parent}")	
	private GoodType parent;
	
	@ManagedProperty(value="#{chosenType}")	
	private GoodType chosenType;	

	@ManagedProperty(value="#{allTypes}")
	private List<GoodType> allTypes;
	
	private Logger log = Logger.getLogger(getClass());

	
	public GoodType getChosenType() {
		log.info("sending chosen type " + chosenType );
		return chosenType;
	}

	public void setChosenType(GoodType chosenType) {
		log.info("recieving chosen type " + chosenType);
		this.chosenType = chosenType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GoodType getParent() {
		log.info("sending parent type " + parent);
		return parent;
	}

	public void setParent(GoodType type) {
		log.info("recieving parent type " + type );
		this.parent = type;	
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
	
	public List<GoodType> getAllTypes(){
		try {
			allTypes = businessService.getAllTypes();
		} catch (MyShopException e) {
			ErrorLogger.logException(e,log);
			allTypes = new ArrayList<GoodType>();
		}
		log.warn("starts here");
		for (GoodType type: allTypes){
			log.info(type.getName());
		}
		log.warn("ends here");
		return allTypes;
	}	
	
	public void addType(){	
		try {
			Integer parentId = null;
			if (parent!=null){
				parentId = parent.getId();
			}
			businessService.createType(name, parentId);
			PrimeFacesUtil.addMessage("Type was successfully created.");
			clearForm();
		} catch (MyShopException e) {
			ErrorLogger.logException(e, log);
			PrimeFacesUtil.addError("Fail to create type.");
		}
	}
	
	public void updateType(){		
		try {
			if (validateExistance(chosenType.getId())){
				Integer parentId = (parent==null? null : parent.getId());
				businessService.updateGoodType(chosenType.getId(), name, parentId);
				PrimeFacesUtil.addMessage("Type was successfully updated.");
				clearForm();
			}
		} catch (MyShopException e) {
			PrimeFacesUtil.addError("Fail to update type.");
			ErrorLogger.logException(e,log);
		}						
	}
	
	public void deleteType(){	
		try {
			if (validateExistance(chosenType.getId())){
				businessService.deleteGoodType(chosenType.getId());
				PrimeFacesUtil.addMessage("Type was successfully deleted.");
				clearForm();
			}
		} catch (MyShopException e) {
			PrimeFacesUtil.addError("Fail to delete type.");
			ErrorLogger.logException(e, log);			
		}				
	}
	
	private Boolean validateExistance(Integer id){
		try {
			if (businessService.getGoodTypeById(id) == null){
				PrimeFacesUtil.addWarning("Such type does not exist.");
				return false;
			}
		} catch (MyShopException e) {
			PrimeFacesUtil.addError("Fail to check type for existance.");			
			ErrorLogger.logException(e, log);
			return false;
		}
		return true;		
	}

	private void clearForm(){/*
		setName("");
		setParent(null);
		setId(null);
		setChosenType(null);
		setParent(null);*/
	}

}