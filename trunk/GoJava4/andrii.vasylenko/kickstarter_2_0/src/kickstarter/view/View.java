package kickstarter.view;

import java.util.List;

import kickstarter.control.State;

public interface View {
	void view(List<String> data);

	int choiceItem();

	State getDirection(int item);
}
