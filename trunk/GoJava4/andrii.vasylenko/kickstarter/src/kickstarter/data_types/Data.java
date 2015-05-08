package kickstarter.data_types;

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
