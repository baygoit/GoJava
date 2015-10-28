package com.gojava6;

import java.util.ArrayList;

/**
 * Created by sergiigetman on 9/22/15.
 */
public class OneSwipeArray {
    /*public boolean solution(int[] trueArray) {
        boolean b = true;
        ArrayList<Integer> c = new ArrayList<Integer>();
        if (trueArray != null) {
            for (int i = 1; i < trueArray.length; i++) {
                if (c.size() < 3) {
                    if (trueArray[i - 1] < trueArray[i]) {
                        c.add(i - 1);
                        i++;
                    }
                } else {
                    b = false;
                }
            }
            if (c.size() == 2) {
                int tmp = trueArray[c.get(0)];
                trueArray[c.get(0)] = c.get(1);
                trueArray[c.get(1)] = tmp;
                for (int i = 1; i < trueArray.length; i++) {
                    if (trueArray[i - 1] > trueArray[i]) {
                        b = false;
                    }
                }
            } else {
                b = false;
            }
        } else {
            b = false;
        }
        return b;
    }*/

    public boolean solution(int[] trueArray) {
        boolean b = true;
        ArrayList<Integer> c = new ArrayList<Integer>();
        if (trueArray != null) {

            for (int i = 0; i < trueArray.length-1; i++) {
                if(trueArray[i]<trueArray[i+1]&&trueArray[i+1]>trueArray[i+2]||trueArray[i]>trueArray[i+1]&&trueArray[i+1]<trueArray[i+2]){
                    c.add(i+1);
                }
            }
        } else {
            b = false;
        }
        return b;
    }
}
