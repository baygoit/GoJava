package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.IncorrectInputException;
import kickstarter.model.dao.DAO;

public class AmountModel implements Model {
	private List<Object> parameters;

	@Override
	public void init(DAO dao, List<Object> parameters) {
		this.parameters = new ArrayList<Object>(parameters);
	}

	@Override
	public List<String> getData() {
		return new ArrayList<>();
	}

	@Override
	public boolean showOnly() {
		return false;
	}

	@Override
	public List<Object> getParameters(int item, String input) throws IncorrectInputException {
		List<Object> result = new ArrayList<>(parameters);

		if (item == 0) {
		} else if (item > 0) {
			int amount = item;
			result.add(0, amount);
		} else {
			throw new IncorrectInputException("item (amount) < 0");
		}

		return result;
	}
}
