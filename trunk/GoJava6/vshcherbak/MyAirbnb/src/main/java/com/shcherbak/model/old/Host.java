package com.shcherbak.model.old;
/*
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Host extends User {
    private Set<Integer> apartments = new HashSet<>();
    public Host(String name, String surname, String email ) {
        super(name, surname, email);
    }

    public void addApartment(int apartmentID) {
        apartments.add(apartmentID);
    }

    public void delApartment(int apartmentID) {
        apartments.remove(apartmentID);
    /   Iterator<Integer> it = apartments.iterator();
        while (it.hasNext()) {
            Integer ID = it.next();
            if ( ID == apartmentID) {
                it.remove();
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "I am a host";
    }

    @Override
    public boolean validate() {
        return super.validate();
    }
}
*/