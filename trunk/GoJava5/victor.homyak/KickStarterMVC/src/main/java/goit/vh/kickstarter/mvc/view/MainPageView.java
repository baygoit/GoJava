package goit.vh.kickstarter.mvc.view;

import goit.vh.kickstarter.Input;
import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.QuoteGenerator;
import goit.vh.kickstarter.mvc.model.MainPageModel;
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

    public void render(MainPageModel model) {

        QuoteGenerator quote = new QuoteGenerator();
        output.println(quote.getQuote() + "\n");

        Map<Integer, ArrayList<ProjectModel>> categories = model.getCategories();
        for (ArrayList<ProjectModel> value : categories.values()) {
            output.println(value.get(0).getParentId() + " " + value.get(0).getParentName());
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
