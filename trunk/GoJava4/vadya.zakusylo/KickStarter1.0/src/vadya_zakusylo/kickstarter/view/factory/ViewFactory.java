package vadya_zakusylo.kickstarter.view.factory;

import vadya_zakusylo.kickstarter.view.View;

public interface ViewFactory {

	View getView(State state);

}
