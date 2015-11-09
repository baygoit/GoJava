/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.scenes;

/**
 *
 * @author Оля
 */
public class ErrorScene extends ViewScene {

    public ErrorScene() {
        createScene();
    }
    
    

    @Override
    protected void createScene() {
         textScene.append("Enter the correct data!");
    }
    
}
