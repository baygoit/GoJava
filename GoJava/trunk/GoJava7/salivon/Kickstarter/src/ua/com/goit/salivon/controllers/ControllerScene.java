/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.controllers;

import ua.com.goit.salivon.handlers.HendlingError;
import ua.com.goit.salivon.handlers.HendlingErrorFactory;
import ua.com.goit.salivon.scenes.SceneFactory;
import ua.com.goit.salivon.models.StateScene;
import ua.com.goit.salivon.scenes.ViewScene;
import ua.com.goit.salivon.stores.StoreProjects;
import ua.com.goit.salivon.stores.StoreCategories;

/**
 *
 * @author Salivon Ivan
 */
public class ControllerScene {

    private StateScene state;
    private ViewScene scene;
    private String inData;
    private int indexProject;
    private StoreCategories categories;
    private StoreProjects projects;
    private int indexCategory;

    public ControllerScene() {
        categories = new StoreCategories();
        projects = new StoreProjects();
        this.state = new StateScene();

    }

    private void downloadScene() {
        SceneFactory factory = new SceneFactory();
        scene = factory.getViewScene(state, categories, projects, indexCategory, indexProject);
    }

    public StringBuilder getAnswer(String inStr) {
        defineInData(inStr);
        verificationData();
        changeState();
        downloadScene();
        return scene.showScene();
    }

    private void defineInData(String in) {
        inData = in;
    }

    private void changeState() {
        if (!state.isError()) {
            processingOfData();
        }
    }

    private void processingOfData() {
        if (inData == null) {
            return;
        }
        int n = Integer.parseInt(inData);
        if (n == 0) {
            if (state.getCurrentState() == StateScene.CATEGORY_SCENE) {
                state.setCurrentState(StateScene.WELCOME_SCENE);
            }
            if (state.getCurrentState() == StateScene.PROJECT_SCENE) {
                state.setCurrentState(StateScene.CATEGORY_SCENE);

            }
        }
        if (n != 0) {
            if (state.getCurrentState() == StateScene.CATEGORY_SCENE) {
                state.setCurrentState(StateScene.PROJECT_SCENE);
                indexProject = n;

            }

            if (state.getCurrentState() == StateScene.WELCOME_SCENE) {
                state.setCurrentState(StateScene.CATEGORY_SCENE);
                indexCategory = n;

            }

        }
    }

    private void verificationData() {
        HendlingError hend = new HendlingErrorFactory().getHendlingError(state.getCurrentState(), categories, projects, indexCategory);
        if (!hend.validate(inData)) {
            state.setError(true);
            return;
        }
        if (state.isError()) {
            state.setError(false);
        }
    }
}
