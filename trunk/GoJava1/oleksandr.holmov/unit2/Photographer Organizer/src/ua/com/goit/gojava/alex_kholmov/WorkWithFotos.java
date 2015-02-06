/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.util.ArrayList;

/**
 * @author SASH
 *
 */
public class WorkWithFotos {
    static int TIME_WORKING_IN_DAY = 4; //hours
    private int amountDays;
    private ListOfFotoPackages listOfFotoPackages;

    static int getTIME_WORKING_IN_DAY() {
        return TIME_WORKING_IN_DAY;
    }

    static void setTIME_WORKING_IN_DAY(int tIME_WORKING_IN_DAY) {
        TIME_WORKING_IN_DAY = tIME_WORKING_IN_DAY;
    }

    int getAmountDays() {
        return amountDays;
    }
    //set amount days manually
    void setAmountDays(int amountDays) {
        this.amountDays = amountDays;
    }
    //set amount days automatically base on calculation
    void daysEditFotosInService() {
        int timeSum = 0;
        for (PackageFotos pf : listOfFotoPackages.allFotos) {
            timeSum += timeEditingFotosInPackage(pf);
        }
        amountDays = timeSum / TIME_WORKING_IN_DAY;
    }
    
    //return in hours
    private int timeEditingFotosInPackage(PackageFotos pFotos) {
        int allTime = pFotos.getTimeEditingFoto() * pFotos.getAmountFotos();
        int editAllFotos = allTime + ((allTime * pFotos.getTimeReserve()) / 100);
        return editAllFotos / 60;
    }
}
