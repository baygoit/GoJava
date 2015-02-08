package ua.com.goit.gojava.andriidnikitin.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import ua.com.goit.gojava.andriidnikitin.model.Category;
import ua.com.goit.gojava.andriidnikitin.model.Good;

public class StorageNestedMapAdapter extends XmlAdapter<HashMap<Category, StorageNestedMapAdapter.GoodCollection>, Map<Category, ArrayList<Good>>> {
	
	@XmlRootElement class GoodCollection {
		private ArrayList<Good> list;
		
		@XmlElementWrapper(name = "goodMap")
		@XmlElement(name = "category")
		public ArrayList<Good> getList() {
			if (list == null){
				return new ArrayList<Good>();
			}
			return list;
		}
	
		public void setList(ArrayList<Good> list) {
			this.list = list;
		}
	}

	@Override
	public HashMap<Category, GoodCollection> marshal(Map<Category, ArrayList<Good>> arg)
			throws Exception {
		HashMap<Category, GoodCollection> result = 
				new HashMap<Category, StorageNestedMapAdapter.GoodCollection>();
		for (Entry<Category, ArrayList<Good>> entry: arg.entrySet()){
			GoodCollection collection = new GoodCollection();
			collection.setList(entry.getValue());
			result.put(entry.getKey(), collection);
		}		
		return result;
	}

	@Override
	public Map<Category, ArrayList<Good>> unmarshal(HashMap<Category, GoodCollection> arg)
			throws Exception {
		Map<Category, ArrayList<Good>> result = 
				new HashMap<Category, ArrayList<Good>>();
		for (Entry<Category, GoodCollection> entry: arg.entrySet()){
			result.put(entry.getKey(), entry.getValue().getList());
		}		
		return result;
	}
}	