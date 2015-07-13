package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.mvc.model.AbstractModel;
import com.tyomsky.kickstarter.mvc.model.ProjectModel;
import com.tyomsky.kickstarter.ui.Output;
import com.tyomsky.kickstarter.mvc.model.MainPageModel;

import java.util.List;

public class MainPageView extends AbstractView {

    public MainPageView(Output output) {
        super(output);
    }

	@Override
    protected void prepareLayout(AbstractModel model) {
		MainPageModel mainPageModel = ((MainPageModel) model);
        layout.clear();
        layout.add(mainPageModel.getQuote());
        layout.add("Welcome to KickStarter");
        layout.add("Please choose category:");
		fillMenu(mainPageModel);
	}

    private void fillMenu(MainPageModel model) {
        List<String> categories = model.getCategories();
        for (int i = 1; i < categories.size(); i++) {
            layout.add(i+") "+categories.get(i-1));
        }
        layout.add("");
        layout.add("0) Exit");
    }

}
