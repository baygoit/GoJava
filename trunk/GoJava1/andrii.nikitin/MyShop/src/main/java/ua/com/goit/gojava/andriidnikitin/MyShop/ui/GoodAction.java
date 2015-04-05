package ua.com.goit.gojava.andriidnikitin.MyShop.ui;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.andriidnikitin.MyShop.domain.service.GoodCatalogImpl;

import com.opensymphony.xwork2.ActionSupport;

public class GoodAction extends ActionSupport {
	
	private static Logger log = Logger.getLogger("MyShop.UI");
	
	private static final long serialVersionUID = 1L;

	private GoodCatalogImpl catalog;
	
	public GoodCatalogImpl getCatalog() {
		log.info("instance of catalog was sent");
		return catalog;
	}

	public void setCatalog(GoodCatalogImpl catalog) {
		this.catalog = catalog;
	}

	public String execute(){
		catalog = GoodCatalogImpl.getInstance();
		log.info("GoodAction executed");
		return SUCCESS;		
	}
}
