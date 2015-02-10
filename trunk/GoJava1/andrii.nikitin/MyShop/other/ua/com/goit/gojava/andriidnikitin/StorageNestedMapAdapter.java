package ua.com.goit.gojava.andriidnikitin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StorageNestedMapAdapter extends XmlAdapter<ArrayList<StorageNestedMapAdapter.GoodCollection>, HashMap<Category, ArrayList<Good>>> {
	
	@XmlRootElement 
	class GoodCollection {
		
		private Category category;
		
		private ArrayList<Good> list;		

		@XmlAttribute
		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		
		@XmlElementWrapper(name = "list")
		@XmlElement(name = "good")
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
	public ArrayList<GoodCollection> marshal(HashMap<Category, ArrayList<Good>> arg0)
			throws Exception {
		ArrayList<GoodCollection> list = new ArrayList<GoodCollection>(); 
		for (Entry<Category, ArrayList<Good>> entry: arg0.entrySet()){
			GoodCollection collection = new GoodCollection();
			collection.setList(entry.getValue());
			list.add(collection);
		}		
		return list;
	}

	@Override
	public HashMap<Category, ArrayList<Good>> unmarshal(
			ArrayList<GoodCollection> arg0) throws Exception {
		HashMap<Category, ArrayList<Good>> result = 
				new HashMap<Category, ArrayList<Good>>();
		for (GoodCollection collection: arg0){
			result.put(collection.getCategory(), collection.getList());
		}		
		return result;
	}

	
	/*@XmlRootElement class GoodCollection {
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
	}*/
}	