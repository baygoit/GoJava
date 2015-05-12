package logic;

import java.util.List;

import pages.*;
import UserInterface.Input;
import UserInterface.Output;
import datasource.DataSource;
import entities.*;

public class Runner {
	private static final int CATEGORY_LEVEL = 0;
	private static final int PROJECT_LEVEL = 0;
	private Output output;
	private Input input;
	private DataSource dataSource;
	private int[] menuCurrentPosition = new int[2];

	public Runner(Output output, Input input, DataSource dataSource) {
		this.output = output;
		this.input = input;
		this.dataSource = dataSource;

	}

	public void run() {
		
		
		while (true) {
			if (menuCurrentPosition[CATEGORY_LEVEL] == 0) {
			output.print(new MainPage().getPage());
			} else if (menuCurrentPosition[PROJECT_LEVEL] == 0) {
				CategoryPage categoryPage = new CategoryPage(menuCurrentPosition[CATEGORY_LEVEL]);
				output.print(categoryPage.getPage());
			} else {
				ProjectPage projectPage = new ProjectPage(menuCurrentPosition[PROJECT_LEVEL]);
				output.print(projectPage.getPage());
			}
			
		}
		
	}
}
