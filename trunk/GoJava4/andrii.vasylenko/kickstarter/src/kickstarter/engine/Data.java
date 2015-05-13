package kickstarter.engine;

public interface Data {
	int getId();
	
	public enum Defaults implements Data {
		EXIT;

		@Override
		public int getId() {
			return 0;
		}
	}
}
