package kickstarter.model;

import java.util.ArrayList;
import java.util.List;

import kickstarter.exception.IncorrectInputException;
import kickstarter.exception.ProcessedException;

public class AmountModel implements Model {
	private List<Object> parameters;

	public AmountModel(List<Object> parameters) {
		this.parameters = new ArrayList<Object>(parameters);
	}

	@Override
	public List<String> getData() throws ProcessedException {
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
