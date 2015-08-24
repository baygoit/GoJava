package goit.nz.kickstarter.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	private Map<String, Action> actions;

	public ActionFactory() {
		actions = new HashMap<>();
		Action mainPageAction = new MainPageAction();
		actions.put("GET/", mainPageAction);
		actions.put("GET/home", mainPageAction);
		actions.put("GET/category", new CategoryAction());
		actions.put("GET/project", new ProjectAction());
		Action pledgeAction = new PledgeAction();
		actions.put("GET/pledge", pledgeAction);
		actions.put("POST/pledge", pledgeAction);
	}

	public Action getAction(HttpServletRequest request) {
		String method = request.getMethod();
		String path = request.getServletPath();
		return actions.get(method + path);
	}

}
