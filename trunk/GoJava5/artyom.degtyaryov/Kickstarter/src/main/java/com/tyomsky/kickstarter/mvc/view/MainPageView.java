package com.tyomsky.kickstarter.mvc.view;

import com.tyomsky.kickstarter.model.Category;
import com.tyomsky.kickstarter.ui.Output;
import com.tyomsky.kickstarter.mvc.model.MainPageModel;

import java.util.List;

public class MainPageView extends AbstractPageView<MainPageModel> implements ModelUpdateListener<MainPageModel> {

    public MainPageView(Output output) {
        super(output);
    }

    @Override
    public void render(MainPageModel model) {
        output.print(model.getQuote());
        output.print("");
        List<Category> categories = model.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            output.print(String.valueOf(i + 1)+") " + categories.get(i).getName());
        }
        output.print("");
        output.print("0) Exit");
    }

    @Override
    public void onModelUpdate(MainPageModel model) {
        render(model);
    }

}
