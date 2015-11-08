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
public class IdProject {

    private static IdProject instance;
    private int numberId = 1;

    private IdProject() {
    }

    public static IdProject getInstance() {
        if (instance == null) {
            instance = new IdProject();
        }
        return instance;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId() {
        numberId++;
    }
}
