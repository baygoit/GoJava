package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.ui.Output;
import com.tyomsky.kickstarter.mvc.model.MainPageModel;

import java.util.ArrayList;
import java.util.List;

public class MainPageView {

    private ArrayList<String> layout = new ArrayList<>();
    private Output output;

    public MainPageView(Output output) {
        this.output = output;
    }

    public void prepareLayout(MainPageModel model) {
        layout.clear();
        layout.add(model.getQuote());
        layout.add("Welcome to KickStarter");
        fillMenu(model);
    }

    private void fillMenu(MainPageModel model) {
        List<Category> categories = model.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            layout.add(String.valueOf(i + 1) + ") " + categories.get(i).getName());
        }
        layout.add("");
        layout.add("0) Exit");
    }

    public void show(MainPageModel model) {
        prepareLayout(model);
        output.print(layout);
    }

    public ArrayList<String> getLayout() {
        return layout;
    }
}
