package com.gojava6.refactoring.extract;

/**
 * Created by sergiigetman on 9/30/15.
 */
public class Employee  {
    public int getRate(){
        return 5;
    }

    public boolean hasSpecialSkill() {
        return false;
    }

    public String getName() {
        return null;
    }

    public String getDepartment() {
        return null;
    }

    public String getPosition() {
        return null;
    }



    public void printDetails(int period) {
        System.out.println("name: " + getName());

        System.out.println("department: " + getDepartment());
        System.out.println("department: " + getDepartment());

        System.out.println("salary for period "  + period + " days :" + period * getRate());

    }

    public static void main(String[] args) {

    }

}
