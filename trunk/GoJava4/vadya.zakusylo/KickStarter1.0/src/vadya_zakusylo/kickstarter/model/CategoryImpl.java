package vadya_zakusylo.kickstarter.model;

public class CategoryImpl implements Category {
	private String nameCategory;

	public CategoryImpl(String name) {
		this.nameCategory = name;
	}

	@Override
	public String getName() {
		return nameCategory;
	}
}
