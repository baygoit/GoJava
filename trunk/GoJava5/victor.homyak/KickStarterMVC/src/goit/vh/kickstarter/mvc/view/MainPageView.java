package goit.vh.kickstarter.mvc.view;

import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.model.Category;
import goit.vh.kickstarter.mvc.model.MainPageModel;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageView {
    
    private Output output;

    public MainPageView(Output output) {
        this.output = output;
    }

    public void render(MainPageModel model) {
        output.println(model.getHelloMsg());
        Category[] categories = model.getCategories();
        for (int i = 0; i < categories.length; i++) {
            output.println(String.valueOf(i + 1) + " " + categories[i].getName());
        }
    }

}
