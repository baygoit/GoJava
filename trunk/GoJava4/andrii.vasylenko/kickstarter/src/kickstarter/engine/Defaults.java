package kickstarter.engine;

public enum Defaults implements Data {
	EXIT (0);
	
	private int id;

	private Defaults(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}
}
