package goit.nz.kickstarter.action;

import goit.nz.kickstarter.storage.DataStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String execute(HttpServletRequest request, HttpServletResponse response,
			DataStorage storage);
}
