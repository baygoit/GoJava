package ua.com.goit.gojava7.salivon.state;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandlerStateWelcom;
import ua.com.goit.gojava7.salivon.context.Console;

public class WelcomeState extends State {

    private List<Category> categories = getManagerData().getAllCategories();

    public WelcomeState() {
        handler = new ErrorHandlerStateWelcom(getManagerData());
        menu = "Enter the number of categories to select it.\n"
                + "Enter 'q' to exit.\n";
        setCommandZero(false);

    }

    @Override
    public void outputContentState() {
        System.out.println((getManagerData().getRandomQuote() + "\n"));
        String str = "Categories:\n";
        for (int i = 0; i < categories.size(); i++) {
            str += categories.get(i).getId() + " - " + categories.get(i).getName() + "\n";
        }
        System.out.println(str);
        System.out.println("--------------------------------------------------");
        System.out.println(menu);
    }

    @Override
    public void changeState(Console context) {
        String inData = getInData();
        if (inData.equalsIgnoreCase("q")) {
            performExit();
            return;
        }
        State.setIndexCategory(Integer.parseInt(getInData()));
        context.setCurrentState(new CategoryState());
    }
}
