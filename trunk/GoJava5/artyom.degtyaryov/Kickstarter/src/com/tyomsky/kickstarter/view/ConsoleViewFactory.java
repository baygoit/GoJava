package com.tyomsky.kickstarter.view;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.model.Entity;

import java.util.ArrayList;

public class ConsoleViewFactory implements ViewFactory {

	DataProvider dataProvider;

	public ConsoleViewFactory(DataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	@Override
    public EntityView getView(ViewTypes viewType, Entity entity) {
        EntityView view = null;

        switch (viewType) {
            case Main:
                view = initMainView(entity);
            break;
            case Category:
                view = new CategoryView(entity);
                break;
            case Project:
                view = new ProjectView(entity);
                break;
        }

        return view;

    }

    private MainView initMainView(Entity entity) {
        ArrayList<EntityView> childViews = new ArrayList<>();
        MainView result = new MainView(entity);
        for (Category category : dataProvider.getCategoriesList()) {
            EntityView view = this.getView(ViewTypes.Category, category);
            view.setParentView(result);
            childViews.add(view);
        }
        result.setChildViews(childViews);
        result.setParentView(new ExitView(entity));
        return result;
    }

	@Override
	public void prepareNextView(EntityView nextView) {
		ArrayList<EntityView> childViews = new ArrayList<>();
		for (Entity entity: dataProvider.getEntitiesList(nextView.getViewType(), nextView.getId())) {
            EntityView view = this.getView(nextView.getViewType().next(), entity);
            view.setParentView(nextView);
			childViews.add(view);
		}
		nextView.setChildViews(childViews);
	}

}
