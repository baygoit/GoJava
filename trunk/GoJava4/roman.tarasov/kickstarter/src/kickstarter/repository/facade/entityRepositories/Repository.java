package kickstarter.repository.facade.entityRepositories;

public class Repository<T> implements IRepository<IDcontent> {
	ArrayListExtendedByID<IDcontent> list;
	String entityName;
	String folderName;

	@Override
	public String getEntityName() {
		return entityName;
	}

	@Override
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Override
	public void setList(ArrayListExtendedByID<IDcontent> entities) {
		this.list = entities;
	}

	@Override
	public ArrayListExtendedByID<IDcontent> getList() {
		return list;
	}

	@Override
	public void addEntity(IDcontent entity) {
		if (list != null) {
			list.add(entity);
			return;
		}
		list = new ArrayListExtendedByID<IDcontent>();
		list.add(entity);
	}

	@Override
	public String getFolderName() {
		return folderName;
	}

	@Override
	public void setFolderName(String name) {
		this.folderName = name;
	}
}
