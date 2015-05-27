package com.goit.kickstarter.glmax.view;

import java.util.HashMap;
import java.util.Map;

import com.goit.kickstarter.glmax.controller.Position;
import com.goit.kickstarter.glmax.controller.Runner;
import com.goit.kickstarter.glmax.pages.MainPage;
import com.goit.kickstarter.glmax.pages.Page;
import com.goit.kickstarter.glmax.pages.PageFactory;

public class ConsolePageFactory implements PageFactory {
	
	private Map<Position, Map<Integer, Page>> cache;
	
	

	public ConsolePageFactory() {
		this.cache = new HashMap<Position, Map<Integer,Page>>();
		
		for (Position position : Position.values()) {
			cache.put(position, new HashMap<Integer, Page>());
		}
	}

	@Override
	public Page getPage(Position position, Runner runner) {

		switch (position) {
		case Main:
			return getPage(runner, Position.Main);
		case Category:
			return getPage(runner, Position.Category);
		case Project:
			return getPage(runner, Position.Project);
		case Payment:
			return getPage(runner, Position.Payment);
		case Question:
			return getPage(runner, Position.Question);
		}
		return null;
	}


	private Page getMainPage(Runner runner, Position position) {
		int entetieIndex = runner.getCurrentEntetieIndex();
		if (cache.get(position).containsKey(0)) {
			return cache.get(Position.Main).get(0);
		} else {
			Page mainPage = new MainPage(runner);
			cache.get(Position.Main).put(0, mainPage);
			return mainPage;
		}
	}

}
