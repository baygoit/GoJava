package ua.com.goit.gojava7.salivon.state;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.context.Console;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;

public class WelcomeState extends State {

    private List<Category> categories = DaoFactory.getCategoryDao(getCurrentDataType()).getAllCategories();

    public WelcomeState() {
        menu = "Enter the number of categories to select it.\n"
                + "Enter 'q' to exit.\n";
        setCommandZero(false);

    }

    @Override
    public void outputContentState() {
        System.out.println((DaoFactory.getQuoteDao(getCurrentDataType()).getRandomQuote() + "\n"));
        String str = "Categories:\n";
        for (int i = 0; i < categories.size(); i++) {
            str += (i + 1) + " - " + categories.get(i).getName() + "\n";
        }
        System.out.println(str);
        System.out.println("--------------------------------------------------");
        System.out.println(menu);
    }

    @Override
    public boolean validate(String data) {
        try {
            int n = Integer.parseInt(data);
            return n - 1 >= 0 && n - 1 < categories.size();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void changeState(Console context) {
        String inData = getInData();

        if (inData.equalsIgnoreCase("q")) {
            performExit();
            return;
        }
        int index = Integer.parseInt(inData);
        State.setIdCategory(convertIndexToId(index));
        context.setCurrentState(new CategoryState());
    }

    protected int convertIndexToId(int index) {
        return categories.get(index - 1).getId();
    }
}
