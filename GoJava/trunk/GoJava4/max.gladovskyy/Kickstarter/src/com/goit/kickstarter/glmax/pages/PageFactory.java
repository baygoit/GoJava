package com.goit.kickstarter.glmax.pages;

import com.goit.kickstarter.glmax.controller.Position;
import com.goit.kickstarter.glmax.enteties.Entetie;

public interface PageFactory {

	Page getPage(Position position, Entetie entetie);


	void prepareNextPage(Page nextPage);


}
