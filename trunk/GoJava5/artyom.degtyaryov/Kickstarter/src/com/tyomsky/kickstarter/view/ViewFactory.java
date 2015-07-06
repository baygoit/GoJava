package com.tyomsky.kickstarter.view;

import com.tyomsky.kickstarter.model.Entity;

public interface ViewFactory {

    EntityView getView(ViewTypes viewType, Entity entity);

	void prepareNextView(EntityView nextView);


}
