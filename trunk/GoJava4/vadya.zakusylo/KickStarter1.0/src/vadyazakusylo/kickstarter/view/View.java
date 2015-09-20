package vadyazakusylo.kickstarter.view;

import vadyazakusylo.kickstarter.view.factory.State;

public interface View {

	void printHeader();

	void printContent();

	State chooseDirection();

}
