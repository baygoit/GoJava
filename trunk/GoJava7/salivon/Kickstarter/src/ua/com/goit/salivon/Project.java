/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author salivon.i
 */
public class Project {

    private int id;
    private int idCategory;
    private String title;
    private String description;
    private int total;
    private int collectedAmount;
    private int numberOfDaysToImplement;
    private Date dateStart;

    public Project(String title, int total, int idCategory) {
        setDateStart();
        description = "...description...";
        collectedAmount = 0;
        this.title = title;
        this.total = total;
        this.idCategory = idCategory;
        setId();
    }

    private void setDateStart() {
        dateStart = new Date();

    }

    public int getCollectedAmount() {
        return collectedAmount;
    }

    public int getTotal() {
        return total;
    }

    public String getDescription() {
        return description;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfDaysToEnd() {
        long milSecondStart = dateStart.getTime();
        long milSecondEnd = Calendar.getInstance().getTimeInMillis();
        int numberOfDaysInWork = (int) (milSecondEnd - milSecondStart) / (1000 * 60 * 60 * 24);
        return numberOfDaysInWork - numberOfDaysToImplement;
    }

    private void setId() {
        IdProject ic = IdProject.getInstance();
        id = ic.getNumberId();
        ic.setNumberId();
    }

    public int getId() {
        return id;
    }
    

}
