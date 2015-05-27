package com.goit.kickstarter.glmax.controller;

import java.util.ArrayList;
import java.util.List;

import com.goit.kickstarter.glmax.enteties.Category;
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

	public int getVariantsAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void process(int fromUser) {
		// TODO Auto-generated method stub
		
	}

	public String getSomeQoute() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Category> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCurrentEntetieIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
}
