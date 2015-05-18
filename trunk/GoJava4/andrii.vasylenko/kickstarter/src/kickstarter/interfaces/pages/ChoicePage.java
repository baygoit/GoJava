package kickstarter.interfaces.pages;

import kickstarter.engine.Data;

public interface ChoicePage extends Page {
	void setChosenItem(int itemId);

	Data getChosenItem();
}
