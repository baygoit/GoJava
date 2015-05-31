package com.goit.kickstarter.glmax.pages;

import java.util.Map;

import com.goit.kickstarter.glmax.controller.Position;
import com.goit.kickstarter.glmax.controller.Runner;

public interface PageFactory {

	Page getPage(Position position, Runner runner);


}
