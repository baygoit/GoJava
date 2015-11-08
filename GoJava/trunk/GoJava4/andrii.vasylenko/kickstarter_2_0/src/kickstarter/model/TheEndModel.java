package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.model.dao.DAO;

public class TheEndModel implements Model {

	@Override
	public void init(DAO dao, List<Object> parameters) {

	}

	@Override
	public List<String> getData() {
		return new ArrayList<>();
	}

	@Override
	public boolean showOnly() {
		return true;
	}

	@Override
	public List<Object> getParameters(int item, String input) {
		return null;
	}
}
