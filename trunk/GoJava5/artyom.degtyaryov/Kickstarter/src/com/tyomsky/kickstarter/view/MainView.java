package com.tyomsky.kickstarter.view;

import com.tyomsky.kickstarter.model.Entity;

public class MainView extends EntityView {
	
	public MainView(Entity entity) {
		super(entity);
		viewType = ViewTypes.Main;
    }

	@Override
    protected void prepareLayout() {

		layout.add(this.entity.getName());
        layout.add("Welcome to KickStarter");
        layout.add("Plese choose category:");
		fillMenu();
		layout.add("");
		layout.add("0) Quit.");
	}

}
