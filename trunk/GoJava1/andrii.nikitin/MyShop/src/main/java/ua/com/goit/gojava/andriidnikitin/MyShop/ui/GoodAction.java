package ua.com.goit.gojava.andriidnikitin.MyShop.ui;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalogImpl;

import com.opensymphony.xwork2.ActionSupport;

public class GoodAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private GoodCatalog catalog;
	
	public GoodCatalog getCatalog() {
		return catalog;
	}

	public void setCatalog(GoodCatalog catalog) {
		this.catalog = catalog;
	}

	public String execute(){
		catalog = GoodCatalogImpl.getInstance();		
		return SUCCESS;		
	}
	

}
