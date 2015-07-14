package goit.vh.kickstarter.mvc.view;

import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.model.Category;
import goit.vh.kickstarter.mvc.model.MainPageModel;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageView {
    private String input;
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
