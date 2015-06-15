package vadya_zakusylo.kickstarter.controller;

import vadya_zakusylo.kickstarter.controller.Controller;
import vadya_zakusylo.kickstarter.view.View;
import vadya_zakusylo.kickstarter.view.factory.State;
import vadya_zakusylo.kickstarter.view.factory.ViewFactory;

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
