package goit.vh.kickstarter.mvc.view;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.Input;
import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.QuoteGenerator;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;

import java.util.ArrayList;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 */
public class MainPageView {




    private String input;
    private Output output;

    public MainPageView(Output output) {
        this.output = output;
    }

    public void render(CategoryModel categoryModel) {

        QuoteGenerator quote = new QuoteGenerator();
        output.println(quote.getQuote() + "\n");

        Map<Integer, String> categories = categoryModel.getCategories();
        for (Map.Entry<Integer, String> entry : categories.entrySet())
        {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }


        setInput(new Input().getInput());

    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
}
