package com.goit.kickstarter.glmax.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.goit.kickstarter.glmax.controller.Position;
import com.goit.kickstarter.glmax.controller.Runner;

public interface View {

	void show(Position position);

	void setRunner(Runner runner);

	int getUserAction(ArrayList<Integer> choisList);

}
