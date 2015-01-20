package ua.com.goit.group1.admytruk.blabla.complex;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "warehouse")
@XmlAccessorType(XmlAccessType.FIELD)
public class Warehouse {
	
	@XmlElement(name = "category")
	@XmlElementWrapper(name = "categories")
	private List<Category> categoryList;
		
	@XmlElement(name = "product")
	@XmlElementWrapper(name = "products")
	private List<Product> productList;
	
	public List<Category> getCategoryList() {
		if (categoryList == null) {
			categoryList = new ArrayList<Category>();
		}
		return categoryList;
	}
	
	public List<Product> getProductList() {
		if (productList == null) {
			productList = new ArrayList<Product>();
		}
		return productList;
	}
	
}

