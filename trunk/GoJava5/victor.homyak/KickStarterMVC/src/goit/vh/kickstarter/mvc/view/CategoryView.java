package goit.vh.kickstarter.mvc.view;

import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class CategoryView {

    private Output output;

    public CategoryView(Output output) {
        this.output = output;
    }

    public void render(CategoryModel categoryModel) {
        output.println("You choose option " + categoryModel.getCategoryIndex() + ": " + categoryModel.getCategoryName());
    }

}
