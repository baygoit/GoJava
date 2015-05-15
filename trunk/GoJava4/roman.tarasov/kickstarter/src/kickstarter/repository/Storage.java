package kickstarter.repository;


public interface Storage<T> {

	void add(T entity);

	T getEntity(int index);

	int length();

	T getRandom();

}
