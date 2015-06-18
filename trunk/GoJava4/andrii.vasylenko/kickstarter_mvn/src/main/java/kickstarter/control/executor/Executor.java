package kickstarter.control.executor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kickstarter.control.state.State;

public interface Executor {
	/**
	 * get Data from Model and show these data to View
	 */
	void execute(State state, HttpServletRequest request, HttpServletResponse response);
}
