package ua.com.goit.gojava.andriidnikitin;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlType(propOrder = { "goodMap" },name = "warehouse")
@XmlRootElement
public class WarehouseNew {	
	
	private HashMap<Category, List<Good>> goodMap;

	@XmlJavaTypeAdapter(StorageNestedMapAdapter.class)
	@XmlElement(name = "goods")
	public HashMap<Category, List<Good>> getGoodMap() {
		if (goodMap == null){
			goodMap =  new HashMap<Category, List<Good>>();;
			return goodMap;
		}
		return goodMap;
	}

	public void setGoodMap(HashMap<Category, List<Good>> goodMap) {
		this.goodMap = goodMap;
	}
	
	
}

