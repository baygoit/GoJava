package ua.com.goit.gojava.andriidnikitin.service;

import java.util.List;

public interface IDAO<T> {
	
	public boolean create(T arg);
	
	public void update (T arg);
	
	public List<T> getAll ();	

}
