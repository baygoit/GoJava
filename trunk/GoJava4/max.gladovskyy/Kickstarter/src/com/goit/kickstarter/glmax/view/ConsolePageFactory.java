package com.goit.kickstarter.glmax.view;

import java.util.HashMap;
import java.util.Map;

import com.goit.kickstarter.glmax.controller.Position;
import com.goit.kickstarter.glmax.controller.Runner;
import com.goit.kickstarter.glmax.enteties.Entetie;
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
	public Page getPage(Position position, Entetie entetie) {
		Page page = null;

		if (cache.get(position).containsKey(entetie.getId())) {
			return cache.get(position).get(entetie.getId());
		} else {
			switch (position) {
			case Main:
				page = new MainPage(entetie);
				break;
			case Category:
				page = new CategoryPage(entetie);
				break;
			case Project:
				page = new ProjectPage(entetie);
				break;
			case Payment:
				page = new PaymentPage(entetie);
				break;
			case Question:
				page = new QuestionPage(entetie);
				break;
			}

			cache.get(position).put(entetie.getId(), page);
			return page;
		}
	}

}
