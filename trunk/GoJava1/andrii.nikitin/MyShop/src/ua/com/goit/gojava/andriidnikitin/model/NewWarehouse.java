package ua.com.goit.gojava.andriidnikitin.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ua.com.goit.gojava.andriidnikitin.service.util.StorageNestedMapAdapter;


@XmlType(propOrder = { "goodMap" },name = "warehouse")
@XmlRootElement
public class NewWarehouse {	
	
	private Map<Category, List<Good>> goodMap;

	@XmlJavaTypeAdapter(StorageNestedMapAdapter.class)
	@XmlElementWrapper(name = "goods")
	@XmlElement(name = "good")
	public Map<Category, List<Good>> getGoodMap() {
		if (goodMap == null){
			Map<Category, List<Good>> map = new HashMap<Category, List<Good>>();
			return map;
		}
		return goodMap;
	}

	public void setGoodMap(Map<Category, List<Good>> goodMap) {
		this.goodMap = goodMap;
	}
}

