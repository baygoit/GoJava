package vadyazakusylo.kickstarter.controller;

import vadyazakusylo.kickstarter.view.View;
import vadyazakusylo.kickstarter.view.factory.State;
import vadyazakusylo.kickstarter.view.factory.ViewFactory;

public class KickStarter {
	private Controller controller;
	private ViewFactory viewFactory;

	public KickStarter(Controller controller, ViewFactory viewFactory) {
		this.controller = controller;
		this.viewFactory = viewFactory;
	}

	public void go() {
		controller.setState(State.START);
		while (true) {
			State state = controller.getState();
			View view = viewFactory.getView(state);
			view.printHeader();
			if (state == State.EXIT) {
				break;
			}
			view.printContent();
			controller.setState(view.chooseDirection());
		}
	}
}
