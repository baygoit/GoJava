/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.state;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.handlers.HandlerError;
import ua.com.goit.gojava7.salivon.handlers.HandlerErrorWelcomScene;
import ua.com.goit.gojava7.salivon.state.State;
import ua.com.goit.gojava7.salivon.stores.StoreQuotes;
import ua.com.goit.gojava7.salivon.stores.StoreCategories;
import ua.com.goit.gojava7.salivon.view.Console;

/**
 *
 * @author Salivon Ivan
 */
public class WelcomeState extends State {

    private List<Category> categories = StoreCategories.getCategories();

    public WelcomeState() {
        handler = new HandlerErrorWelcomScene();
        menu = "Enter the number of categories to select it.\n"
                + "Enter 'q' to exit.\n";

    }

    @Override
    public void outputContentState() {
        System.out.println((StoreQuotes.getQuote() + "\n"));
        String str = "Categories:\n";
        for (int i = 0; i < categories.size(); i++) {
            str += categories.get(i).getId() + " - " + categories.get(i).getName() + "\n";
        }
        System.out.println(str);
        System.out.println("--------------------------------------------------");
        System.out.println(menu);
    }

    @Override
    protected void changeState(Console context, String inData) {
        State.setIndexCategory(Integer.parseInt(inData));
        context.setCurrentState(context.getCategoryState());
    }
}
