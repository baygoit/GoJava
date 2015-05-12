package kickstarter.Repository;

public interface Storage<T> {
	
	

	void add(T entity);
	T getEntity(int index);
}
