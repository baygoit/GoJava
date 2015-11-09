/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.scenes;

import ua.com.goit.salivon.scenes.ProjectScene;
import ua.com.goit.salivon.scenes.ErrorScene;
import ua.com.goit.salivon.scenes.CategoryScene;
import ua.com.goit.salivon.models.StateScene;
import ua.com.goit.salivon.stores.StoreProjects;
import ua.com.goit.salivon.stores.StoreCategories;

/**
 *
 * @author Оля
 */
public class SceneFactory {

    
    public ViewScene getViewScene(StateScene state,StoreCategories categories,
            StoreProjects projects, int indexCategory,int indexProject){
        if (state.isError()) {
            return new ErrorScene();
        }
        if (state.getCurrentState()==StateScene.WELCOME_SCENE) {
            return new WelcomeScene(categories);
        }else if(state.getCurrentState()==StateScene.CATEGORY_SCENE){
            return new CategoryScene(categories, projects, indexCategory);
        }else if (state.getCurrentState()==StateScene.PROJECT_SCENE) {
            return new ProjectScene(projects, indexProject);
        }
        return null;
    }
    
}
