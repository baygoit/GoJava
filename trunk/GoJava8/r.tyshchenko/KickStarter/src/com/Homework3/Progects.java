package com.Homework3;

/**
 * Created by roman on 06.03.16.
 */
public class Progects {
    private  Progect [] progects = new Progect[100];
    private  int count =0;

    public void add(Progect progect) {
        progects[count] = progect;
        count++;
    }
    public  Progect[]  getProgect (Category category) {
        Progect [] rezult = new Progect[100];
        int found = 0;
        for (int index = 0; index<count; index++ ) {
            Progect progect = progects[index];
            if (progect.getCategory().equals(category)) {
                rezult[found] = progect;
                found++;
            }
        }
        Progect[] rezult2  =new  Progect[found];
        System.arraycopy(rezult, 0, rezult2, 0, found);
        return  rezult2;
    }
    public Progect get(int index) {
        return progects[index];

    }
}
