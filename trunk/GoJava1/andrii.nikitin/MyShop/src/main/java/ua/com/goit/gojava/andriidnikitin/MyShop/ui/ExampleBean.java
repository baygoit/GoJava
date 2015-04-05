package ua.com.goit.gojava.andriidnikitin.MyShop.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalog;

@Component
@Scope("session")
public class ExampleBean {
	
	@Autowired
	GoodCatalog catalog;
	
	public void setUserBo(GoodCatalog catalog) {
		this.catalog = catalog;
	}
	
	public String printMsgFromSpring() {	
		return catalog.getTypeList();	
	}


}
