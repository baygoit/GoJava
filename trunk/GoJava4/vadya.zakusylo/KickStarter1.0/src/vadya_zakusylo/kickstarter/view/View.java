package vadya_zakusylo.kickstarter.view;

import vadya_zakusylo.kickstarter.view.factory.State;

public interface View {

	void printHeader();

	void printContent();

	State chooseDirection();

}
