package ua.com.goit.gojava.andriidnikitin.MyShop.db;

import java.util.ArrayList;
import java.util.List;

public abstract class StubGenericDao <T> implements GenericDao <T> {
	private List<T> content;
	protected abstract Integer getId(T object);
	protected abstract T setId(Integer id, T object);
	protected abstract Integer generateId(T object);
	
	public Integer create(T object) {
		Integer id = generateId(object);
		content.add(setId(id, object));
		return id;
	}

	public T read(Integer id){
		for (T element: content) {
			if (getId(element).equals(id))
				return element;
		}
		return null;
	}

	public void update(T object){
		T oldObject = read(getId(object));
		if (oldObject == null){
			create(object);
		}
		else {
			delete(oldObject);
			content.add(object);
		}
	}
	
	public void delete(T object){
		content.remove(object);
	}	

	public List<T> getAll(){
		List<T> result = new ArrayList<T>();
		for (T element: content) {
			result.add(element);
		}
		return result;
	}
	
	protected void init(){
		content = new ArrayList<T>();
	}
	
	public List<T> getFilteringByName(String query) {
		List<T> all = getAll();
		List<T> result = new ArrayList<T>();
		for (int i = 0; i < all.size(); i++) {
	          T good = all.get(i);
	          if(getName(good).toLowerCase().startsWith(query)) {
	        	  result.add(good);
	          }
		}      
		return result;
	}
	
	protected abstract String getName(T object);

}