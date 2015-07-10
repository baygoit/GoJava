package com.tyomsky.kickstarter.view;

import com.tyomsky.kickstarter.ui.Output;
import com.tyomsky.kickstarter.model.MainPageModel;

import java.util.List;

public class MainPageView extends AbstractView {

    private MainPageModel model;

    public MainPageView(MainPageModel model, Output output) {
        super(output);
        this.model = model;
    }

	@Override
    protected void prepareLayout() {
		layout.clear();
        layout.add(model.getQuote());
        layout.add("Welcome to KickStarter");
        layout.add("Please choose category:");
		fillMenu();
	}

    private void fillMenu(){
        List<String> categories = model.getCategories();
        for (int i = 1; i < categories.size(); i++) {
            layout.add(i+") "+categories.get(i-1));
        }
        layout.add("");
        layout.add("0) Exit");


    }

}
