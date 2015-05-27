package com.goit.kickstarter.glmax.controller;

import java.util.List;

import com.goit.kickstarter.glmax.model.*;
import com.goit.kickstarter.glmax.view.*;

public class Runner {
	private DataSource dataSource;
	private Position menuPosition;
	private View view;

	public Runner(DataSource dataSource) {
		this.dataSource = dataSource;
		this.view = new ConsoleView(this);

	}

	public void run() {

		view.show(Position.Main);
	}
}
