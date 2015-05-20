package kickstarter.repository;


public interface iStorage<T> {

	void add(T entity);

	T getEntity(int index);

	int length();

	T getRandom();

	void update(T entity,int index);

}
