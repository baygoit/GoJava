package com.gojava2.kickstarter.controller;

import java.util.InputMismatchException;

import com.gojava2.kickstarter.view.ConsoleView;
import com.gojava2.kickstarter.view.InPut;

public abstract class Menu {

	private int i;
	
	private InPut input;
	private ConsoleView view;

	public Menu(InPut input, ConsoleView view, int i) {
		this.view = view;
		this.input = input;
		this.i = i;
	}

	public final void levelGo() {
		selectOption(this.i);

		try {
			int in = input.read();
			logic(in);
		} catch (InputMismatchException e) {
			view.inputMismatchMessage();
			recursion();
		}
	}

	public final void selectOption(int i) {
		view.selectOption(i);
	}

	abstract void recursion();
	abstract void logic(int i);
}