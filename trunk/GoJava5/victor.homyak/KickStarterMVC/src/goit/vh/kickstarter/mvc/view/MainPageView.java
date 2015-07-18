package goit.vh.kickstarter.mvc.view;

import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.QuoteGenerator;
import goit.vh.kickstarter.mvc.model.MainPageModel;
import goit.vh.kickstarter.model.Category;

import java.util.Scanner;


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

        Category[] categories = model.getCategories();
        for (int i = 0; i < categories.length; i++) {
            output.println(String.valueOf(i + 1) + " " + categories[i].getName());
        }

    }

    public void readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        this.input = userInput;
    }


    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return this.input;
    }
}
