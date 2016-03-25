package categories;

public class MemoryCard {

	private Kickstarter kickstarter = new Kickstarter();

	public Kickstarter loadBase() {

		SqlDAO sql = new SqlDAO();
		kickstarter = sql.loadBase();
		return kickstarter;

	}

}
