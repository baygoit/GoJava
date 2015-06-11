package com.goit.kickstarter.glmax.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.goit.kickstarter.glmax.controller.Position;
import com.goit.kickstarter.glmax.controller.Runner;
import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.enteties.Entetie;
import com.goit.kickstarter.glmax.model.DataSource;
import com.goit.kickstarter.glmax.pages.*;

public class ConsolePageFactory implements PageFactory {

	private Map<Position, HashMap<Integer, Page>> cache;
	DataSource dataSource;

	public ConsolePageFactory(DataSource dataSource) {
		this.cache = new HashMap<Position, HashMap<Integer, Page>>();
		this.dataSource = dataSource;
		for (Position position : Position.values()) {
			cache.put(position, new HashMap<Integer, Page>());
		}
	}

	@Override
	public Page getPage(Position position, Entetie entetie) {
		Page page = null;

//		if (cache.get(position).containsKey(entetie.getId())) {
//			return cache.get(position).get(entetie.getId());
//		} else {
			switch (position) {
			case Main:
				page = initMainPage(entetie);
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
//		}
	}

	private MainPage initMainPage(Entetie entetie) {
		ArrayList<Page> childPages = new ArrayList<Page>();
		MainPage result = new MainPage(entetie);
		for (Category category : dataSource.getCategoriesList()) {
			Page page = this.getPage(Position.Category, category);
			page.setParentPage(result);
			childPages.add(page);
		}
		result.addChildPages(childPages);
		result.setParentPage(new ExitPage(null));
		return result;
	}

	public void addChildPagesTo(Page page, Position currentMenuLevel) {
		
	}

	@Override
	public void prepareNextPage(Page nextPage) {
		ArrayList<Page> childPages = new ArrayList<Page>();
		for (Entetie entetie: dataSource.getEntetiesList(nextPage.getCurrentMenuLevel(),nextPage.getId())) {
			Page page = this.getPage(nextPage.getCurrentMenuLevel().next(), entetie);
			page.setParentPage(nextPage);
			childPages.add(page);
		}
		nextPage.addChildPages(childPages);
	}

}
