package ua.com.goit.gojava.andriidnikitin.model.DAO;

import java.util.List;

public interface IDAO<T> {
	
	public void create(T arg);
	
	public void update (T arg);
	
	public List<T> getAll ();	

}
