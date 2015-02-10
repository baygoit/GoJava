package ua.com.goit.gojava.andriidnikitin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MapOfGoodAdapter extends XmlAdapter<String, Map<Category, ArrayList<Good>>> {

	XmlAdapter <String, Map<Category,GoodCollection>> localAdapter;
	
	@Override
	public String marshal(Map<Category, ArrayList<Good>> map) throws Exception {		
		Map<Category, GoodCollection> mapVariable = 
			new HashMap<Category,GoodCollection>();
		for (Entry<Category, ArrayList<Good>> entry: map.entrySet()) {
			mapVariable.put(entry.getKey(), new GoodCollection().setList(entry.getValue()));
		}
		return localAdapter.marshal(mapVariable);
	}

	@Override
	public Map<Category, ArrayList<Good>> unmarshal(String variable) throws Exception {
		Map<Category, GoodCollection> mapVariable =  localAdapter.unmarshal(variable);
		Map<Category, ArrayList<Good>> map = new HashMap<Category, ArrayList<Good>>();
		for (Entry<Category, GoodCollection> entry: mapVariable.entrySet()) {
			map.put(entry.getKey(), entry.getValue().getList());
		}
		return map;
	}

	@XmlRootElement
	private class GoodCollection {
		private ArrayList<Good> list;
		
		@XmlElementWrapper(name = "goodMap")
		@XmlElement(name = "category")
		public ArrayList<Good> getList() {
			if (list == null){
				return new ArrayList<Good>();
			}
			return list;
		}

		public GoodCollection setList(ArrayList<Good> list) {
			this.list = list;
			return this;
		}
	}

}
