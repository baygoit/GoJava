package com.goit.kickstarter.glmax.controller;

import java.util.*;

import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.enteties.Project;
import com.goit.kickstarter.glmax.model.*;
import com.goit.kickstarter.glmax.view.*;

public class Runner {
	private DataSource dataSource;
	private Integer currentMenuObjectIndex;
	private Position currentLevel;
	private Map<Position, Integer> menuHistory;
	private View view;

	public Runner(DataSource dataSource, View view) {
		this.dataSource = dataSource;
		this.view = view;
		this.currentLevel = Position.Main;
		this.currentMenuObjectIndex = 0;

		menuHistory = new HashMap<Position, Integer>();
		for (Position position : Position.values()) {
			menuHistory.put(position, 0);
		}

		view.setRunner(this);
	}

	public void run() {

		while (true) {
			view.show(currentLevel);
			int nextPosition = view.getUserAction(dataSource.getChoisList(
					currentLevel, currentMenuObjectIndex));

			if (nextPosition == 0) {
				moveBack();
			} else {
				moveForward(nextPosition);
			}

		}
	}

	private void moveForward(int nextPosition) {
		if (currentLevel == Position.Main) {
			currentLevel = Position.Category;
			currentMenuObjectIndex = nextPosition;
		} else if (currentLevel == Position.Category) {
			currentLevel = Position.Project;
			menuHistory.put(Position.Category, currentMenuObjectIndex);
			currentMenuObjectIndex = nextPosition;
		} else if (currentLevel == Position.Project && nextPosition == 1) {
			currentLevel = Position.Payment;
			menuHistory.put(Position.Project, currentMenuObjectIndex);
			currentMenuObjectIndex = 1;
		} else if (currentLevel == Position.Project && nextPosition == 2) {
			currentLevel = Position.Question;
			menuHistory.put(Position.Project, currentMenuObjectIndex);
			currentMenuObjectIndex = 2;
		}
	}

	private void moveBack() {
		if (currentLevel == Position.Main) {
			dataSource.persistData();
			System.exit(0);
		} else if (currentLevel == Position.Category) {
			currentLevel = Position.Main;
			currentMenuObjectIndex = 0;
		} else if (currentLevel == Position.Project) {
			currentLevel = Position.Category;
			currentMenuObjectIndex = menuHistory.get(Position.Category);
		} else if (currentLevel == Position.Payment) {
			currentLevel = Position.Project;
			currentMenuObjectIndex = menuHistory.get(Position.Project);
		} else if (currentLevel == Position.Question) {
			currentLevel = Position.Project;
			currentMenuObjectIndex = menuHistory.get(Position.Project);
		}

	}


	public String getSomeQoute() {
		return dataSource.getSomeQuote();
	}

	public ArrayList<Category> getCategories() {
		return dataSource.getCategoriesList();
	}

	public int getCurrentEntetieIndex() {
		return currentMenuObjectIndex;
	}

	public String getCategoryName() {
		return dataSource.getCategoryName(currentMenuObjectIndex);
	}

	public ArrayList<Project> getProjectsList() {
		return dataSource.getProjectsList(currentMenuObjectIndex);
	}

	public Project getProject() {
		return dataSource.getProject(menuHistory.get(Position.Category), currentMenuObjectIndex);
	}
}
