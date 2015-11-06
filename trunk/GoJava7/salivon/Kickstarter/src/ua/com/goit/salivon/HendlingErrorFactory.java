/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon;

/**
 *
 * @author salivon.i
 */
public class HendlingErrorFactory {

    public HendlingError getHendlingError(String stateScene, StoreCategories categories, StoreProjects projects) {
        if (stateScene.equalsIgnoreCase("WELCOME")) {
            return new HendlingErrorWelcomScene(categories);
        } else if (stateScene.equalsIgnoreCase("CATEGORY")) {
            return new HendlingErrorCategoryScene(projects);
        } else if (stateScene.equalsIgnoreCase("PROJECT")) {
            return new HendlingErrorProjectScene();
        }
        return null;
    }
}
