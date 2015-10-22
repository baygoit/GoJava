package com.gojava6.refactoring.extract;

/**
 * Created by sergiigetman on 9/30/15.
 */
public class CentalOffice {
    public double charge(Employee emp, int days) {
        int base =  emp.getRate() * days;
        if (emp.hasSpecialSkill())
            return base * 1.05;
        else return base;
    }
}
