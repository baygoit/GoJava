/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.scenes;

/**
 *
 * @author Salivon Ivan
 */
public abstract class ViewScene {

    protected StringBuilder textScene = new StringBuilder();
    protected String menu;

    public StringBuilder showScene() {
        return textScene;
    }

    protected abstract void createScene();
}
