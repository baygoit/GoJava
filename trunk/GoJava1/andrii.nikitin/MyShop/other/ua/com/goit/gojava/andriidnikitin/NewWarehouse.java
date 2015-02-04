package ua.com.goit.gojava.andriidnikitin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;


@XmlType(propOrder = { "goodMap" },name = "warehouse")
@XmlRootElement
public class NewWarehouse {	
	
	private Map<Category, ArrayList<Good>> goodMap;

	@XmlJavaTypeAdapter(MapOfGoodAdapter.class)
	@XmlElementWrapper(name = "goods")
	@XmlElement(name = "good")
	public Map<Category, ArrayList<Good>> getGoodMap() {
		if (goodMap == null){
			Map<Category, ArrayList<Good>> map = new HashMap<Category, ArrayList<Good>>();
			return map;
		}
		return goodMap;
	}

	public void setGoodMap(Map<Category, ArrayList<Good>> goodMap) {
		this.goodMap = goodMap;
	}
}

