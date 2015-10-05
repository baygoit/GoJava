package com.gojava6.refactoring.extract;

/**
 * Created by sergiigetman on 9/30/15.
 */
public class Management {

    public static final int KOEFF = 15;

    public double award(Employee emp) {
        int base =  emp.getRate() * KOEFF;
        if (emp.hasSpecialSkill())
            return base * 1.05;
        else return base;
    }
}
