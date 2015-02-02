package ua.com.goit.gojava.andriidnikitin.model;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "categoryList", "goodList" },name = "warehouse")
@XmlRootElement
public class Warehouse {	
	
	public Warehouse() {
	}

	private List<Category> categoryList;
	private List<Good> goodList;

	@XmlElementWrapper(name = "categoryList")
	@XmlElement(name = "category")
	public List<Category> getCategoryList() {
		if (categoryList == null) {
			categoryList = new ArrayList<Category>();
		}
		return categoryList;
	}
	
	public List<Good> getProductList() {
		if (goodList == null) {
			goodList = new ArrayList<Good>();
		}
		return goodList;
	}
	
	@XmlElementWrapper(name = "goodList")
	@XmlElement(name = "good")
	public List<Good> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<Good> goodList) {
		this.goodList = goodList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	private Category setId(Category category2) {
		final int prime = 31;
		int result = 1;
		result = prime * result + category2.getName().hashCode();
		return category2.setId(result);
	}
	
	private Good setId(Good good) {
		final int prime = 31;
		int result = 1;
		Category category = good.getCategory();
		result = prime * result + category.getId();
		result = prime * result + good.getName().hashCode();
		return good.setId(result);
	}
	
	@SuppressWarnings("serial")
	public void init(){
		
		final ArrayList<Category> categoryListTemp = new ArrayList<Category>(){{
			this.add(setId(new Category()
						.setName("Guitars")));
			this.add(setId(new Category()
						.setName("Synths")));
			this.add(setId(new Category()
						.setName("Other")));		
		}};
		
		ArrayList<Good> goodListTemp = new ArrayList<Good>() {{
			Good tempGood;
			tempGood = new Good()	
					.setName("Fender Strat")
					.setCategory(categoryListTemp.get(0))
					.setPrice(new BigDecimal(1000.0));
			this.add(setId(tempGood));
			
			tempGood = new Good()	
					.setName("Fender Tele")
					.setCategory(categoryListTemp.get(0))
					.setPrice(new BigDecimal(1200.0));
			this.add(setId(tempGood));
			
			tempGood = new Good()	
					.setName("Gibson SG")
					.setCategory(categoryListTemp.get(0))
					.setPrice(new BigDecimal(1337.0));
			this.add(setId(tempGood));

			tempGood = new Good()	
					.setName("Fender Rhodes")
					.setCategory(categoryListTemp.get(1))
					.setPrice(new BigDecimal(3000.0));
			this.add(setId(tempGood));
			

			tempGood = new Good()	
					.setName("Korg MS-20")
					.setCategory(categoryListTemp.get(1))
					.setPrice(new BigDecimal(2500.0));
			this.add(setId(tempGood));

			tempGood = new Good()	
					.setName("Marshall Drive")
					.setCategory(categoryListTemp.get(2))
					.setPrice(new BigDecimal(300.0945));
			this.add(setId(tempGood));
			}};
			this.setCategoryList(categoryListTemp);
			this.setGoodList(goodListTemp);
	}
}

