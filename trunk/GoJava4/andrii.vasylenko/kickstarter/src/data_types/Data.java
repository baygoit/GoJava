package data_types;

public interface Data {
	public int getId();
	
	public enum Default implements Data {
		EXIT;

		@Override
		public int getId() {
			throw new UnsupportedOperationException();
		}
	}
}
