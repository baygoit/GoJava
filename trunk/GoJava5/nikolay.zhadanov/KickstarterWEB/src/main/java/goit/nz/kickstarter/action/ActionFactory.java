package goit.nz.kickstarter.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	private Map<String, Action> actions;

	public ActionFactory() {
		actions = new HashMap<>();
	}

	public void setActions(Map<String, Action> actions) {
		this.actions = actions;
	}

	public Action getAction(HttpServletRequest request) {
		String method = request.getMethod();
		String path = request.getServletPath();
		return actions.get(method + path);
	}

}
