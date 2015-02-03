package ua.com.goit.gojava.andriidnikitin.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "goodMap" },name = "warehouse")
@XmlRootElement
public class Warehouse {	
	
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
}

