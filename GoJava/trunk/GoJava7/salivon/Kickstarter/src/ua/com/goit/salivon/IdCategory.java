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
public class IdCategory {

    private static IdCategory instance;
    private int numberId = 1;

    private IdCategory() {
    }

    public static IdCategory getInstance() {
        if (instance == null) {
            instance = new IdCategory();
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
