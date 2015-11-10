/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.scenes;

import ua.com.goit.salivon.scenes.ViewScene;
import ua.com.goit.salivon.stores.Quotes;
import ua.com.goit.salivon.stores.StoreCategories;

/**
 *
 * @author Salivon Ivan
 */
public class WelcomeScene extends ViewScene {

    private StoreCategories categories;
    private Quotes quotes;

    public WelcomeScene(StoreCategories store) {
        quotes = new Quotes();
        categories = store;
        menu = "Enter the number of categories to select it.\n"
                + "Enter 'q' to exit.\n";
        createScene();

    }

    @Override
    protected void createScene() {

        textScene.append(quotes.getQuote() + "\n");
        textScene.append(categories.getAllCategories());
        textScene.append("--------------------------------------------------\n");
        textScene.append(menu);

    }
}
