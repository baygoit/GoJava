package com.goit.kickstarter.glmax.controller;

import java.util.List;

import com.goit.kickstarter.glmax.model.DataSource;
import com.goit.kickstarter.glmax.view.CategoryPage;
import com.goit.kickstarter.glmax.view.Input;
import com.goit.kickstarter.glmax.view.MainPage;
import com.goit.kickstarter.glmax.view.Output;
import com.goit.kickstarter.glmax.view.ProjectPage;

import pages.*;
import entities.*;

public class Runner {
	private static final int CATEGORY_LEVEL = 0;
	private static final int PROJECT_LEVEL = 1;
	private Output output;
	private Input input;
	private DataSource dataSource;
	private int[] menuPosition = {0,0};

	public Runner(Output output, Input input) {
		this.output = output;
		this.input = input;
	}

	public void run() {
		
		
		while (true) {
			if (menuPosition[CATEGORY_LEVEL] == 0) {
			output.print(new MainPage().getPage());
			} else if (menuPosition[PROJECT_LEVEL] == 0) {
				CategoryPage categoryPage = new CategoryPage(menuPosition[CATEGORY_LEVEL]);
				output.print(categoryPage.getPage());
			} else {
				ProjectPage projectPage = new ProjectPage(menuPosition[CATEGORY_LEVEL],menuPosition[PROJECT_LEVEL]);
				output.print(projectPage.getPage());
			}
			input.getFromUser(menuPosition);
			
		}
		
	}
}
