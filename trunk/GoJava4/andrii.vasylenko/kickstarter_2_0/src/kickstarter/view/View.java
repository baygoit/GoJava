package kickstarter.view;

import java.util.List;

import kickstarter.control.State;
import kickstarter.exception.ProcessedException;

public interface View {
	void view(List<String> data);

	int choiceItem(StringBuilder input) throws ProcessedException;

	State getDirection(int item) throws ProcessedException;
}
