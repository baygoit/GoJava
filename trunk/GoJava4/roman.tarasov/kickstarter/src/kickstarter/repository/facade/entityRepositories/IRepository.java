package kickstarter.repository.facade.entityRepositories;

public interface IRepository<T extends IDcontent> {

	void setList(ArrayListExtendedByID<T> entities);

	ArrayListExtendedByID<T> getList();

	void addEntity(T entity);

	String getEntityName();

	void setEntityName(String name);

	String getFolderName();

	void setFolderName(String name);

}
