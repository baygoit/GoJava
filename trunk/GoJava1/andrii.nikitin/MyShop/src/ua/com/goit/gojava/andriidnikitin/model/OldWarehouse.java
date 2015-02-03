package ua.com.goit.gojava.andriidnikitin.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "goodMap" },name = "warehouse")
@XmlRootElement
public class OldWarehouse {	
	
	public OldWarehouse() {
	}

	private List<Category> categoryList;
	private List<Good> goodList;
	private Map<Category, GoodCollection> goodMap;

	@XmlElementWrapper(name = "goods")
	@XmlElement(name = "good")
	public Map<Category, GoodCollection> getGoodMap() {
		if (goodMap == null){
			Map<Category, GoodCollection> map = new HashMap<Category, GoodCollection>();
			return map;
		}
		return goodMap;
	}

	public void setGoodMap(Map<Category, GoodCollection> goodMap) {
		this.goodMap = goodMap;
	}

	private void setGoodList(List<Good> goodList) {
		this.goodList = goodList;
	}

	private void setCategoryList(List<Category> categoryList) {
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
		
		goodMap = new HashMap<Category, GoodCollection>();
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
			for (Category category: categoryList) {
				ArrayList<Good> list = new ArrayList<Good>();
				for (Good good: goodList){
					if (good.getCategory().equals(category)){
						list.add(good);
					}
				}
				GoodCollection collection = new GoodCollection();
				collection.setList(list);
				goodMap.put(category, collection);			
			}
	}
	
	
}

