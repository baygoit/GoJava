package com.goit.kickstarter.glmax.view;

import java.util.HashMap;
import java.util.Map;

import com.goit.kickstarter.glmax.controller.Position;
import com.goit.kickstarter.glmax.controller.Runner;
import com.goit.kickstarter.glmax.pages.*;

public class ConsolePageFactory implements PageFactory {

	private Map<Position, Map<Integer, Page>> cache;

	public ConsolePageFactory() {
		this.cache = new HashMap<Position, Map<Integer, Page>>();

		for (Position position : Position.values()) {
			cache.put(position, new HashMap<Integer, Page>());
		}
	}

	@Override
	public Page getPage(Position position, Runner runner) {
		Page page = null;
		int entetieIndex = runner.getCurrentEntetieIndex();

		if (cache.get(position).containsKey(entetieIndex)) {
			return cache.get(position).get(entetieIndex);
		} else {
			switch (position) {
			case Main:
				page = new MainPage(runner);
				break;
			case Category:
				page = new CategoryPage(runner);
				break;
			case Project:
				page = new ProjectPage(runner);
				break;
			case Payment:
				page = new PaymentPage(runner);
				break;
			case Question:
				page = new QuestionPage(runner);
				break;
			}

			cache.get(position).put(entetieIndex, page);
			return page;
		}
	}

}
