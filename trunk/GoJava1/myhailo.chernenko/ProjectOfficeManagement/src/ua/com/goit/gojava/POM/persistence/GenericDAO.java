package ua.com.goit.gojava.POM.persistence;

import java.util.List;

public interface GenericDAO<T> {
	
	public T create();
	public T getByName(String name);
	public void update(T obj);
	public void delete(T obj);
	public List<T> getList();
	
}
