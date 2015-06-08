package ua.com.gojava4.kickstarter.view.pages;

import ua.com.gojava4.kickstarter.control.ExitProgramException;

public interface Page {

	void showPage();

	Page getNextPage() throws ExitProgramException;

}
