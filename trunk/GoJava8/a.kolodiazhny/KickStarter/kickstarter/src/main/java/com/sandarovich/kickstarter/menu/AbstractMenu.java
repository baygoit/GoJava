package com.sandarovich.kickstarter.menu;

import com.sandarovich.kickstarter.Output;

/**
 * @author Olexander Kolodiazhny 2016 Describes common stuff for all menu
 */

public abstract class AbstractMenu {

	public AbstractMenu(Output output, MenuReader menuReader) {
		this.output = output;
		this.menuReader = menuReader;
	}

	protected MenuElement[] menuElements;
	protected String headerLabel;
	protected int menuId;
	protected Output output;
	protected MenuReader menuReader;

	public void show() {
		output.print("-----------");
		output.print("{" + menuId + "} " + headerLabel);
		output.print("-----------");
		if (menuElements.length > 1) {
			for (int index = 0; index < menuElements.length; index++) {
				output.print(menuElements[index].toString());
			}
		} else {
			output.print("<< Is empty >>");
		}
		output.print("---");
	}

	public int readUserFeedback() {
		int result = menuReader.read();
		if (isvalidMenuElement(result)) {
			return result;
		} else {
			output.print(">> Option is not found. Please try again");
			return readUserFeedback();
		}
	}

	protected boolean isvalidMenuElement(int checkedNumber) {
		boolean result = true;
		if (checkedNumber < 0 || checkedNumber > menuElements.length - 1) {
			return false;
		}
		return result;
	}

	public abstract void doAction(int choise);

}
