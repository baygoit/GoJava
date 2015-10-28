package goit.dm.kickstarter.mvc.view;

import goit.dm.kickstarter.Output;
import goit.dm.kickstarter.mvc.model.CategoryModel;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryView {

    private Output output;

    public CategoryView(Output output) {
        this.output = output;
    }

    public void render(CategoryModel model) {
        output.println("You choose option " + model.getCategoryIndex() + ": " + model.getCategoryName());
    }
}
