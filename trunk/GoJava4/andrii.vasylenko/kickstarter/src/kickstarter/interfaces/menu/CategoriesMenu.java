package kickstarter.interfaces.menu;

public enum CategoriesMenu implements Menu {
	EXIT;

	public static int size() {
		return values().length;
	}

	@Override
	public int getId() {
		return ordinal();
	}
}
