package kickstarter.view;

import java.util.List;

import kickstarter.control.State;
import kickstarter.exception.IncorrectInputException;

public interface View {
	void view(List<String> data);

	int choiceItem() throws IncorrectInputException;

	State getDirection(int item) throws IncorrectInputException;
}
