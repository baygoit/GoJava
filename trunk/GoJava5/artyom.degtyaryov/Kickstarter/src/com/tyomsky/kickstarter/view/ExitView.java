package com.tyomsky.kickstarter.view;

import com.tyomsky.kickstarter.model.Entity;

public class ExitView extends EntityView {

	public ExitView(Entity entity) {
		super(entity);
        viewType = ViewTypes.Exit;
	}

	@Override
	public void show(Output printer) {
		super.show(printer);
		System.exit(0);
	}

	@Override
    protected void prepareLayout() {
		layout.add("Bye!");
	}
	


}
