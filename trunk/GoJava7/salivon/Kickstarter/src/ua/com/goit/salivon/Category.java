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
public class Category {

    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
        setId();
    }

    private void setId() {
        IdCategory ic = IdCategory.getInstance();
        id = ic.getNumberId();
        ic.setNumberId();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
