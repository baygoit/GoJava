package com.gojava6;

/**
 * Created by Ярослав on 29.09.2015.
 */
public class OneSwipeArray {
    public boolean solution(int[] trueArray) {
        if (trueArray==null){
            throw new IllegalArgumentException("array must not be null");
        }else if(trueArray.length<2){
            throw new IllegalArgumentException("array must not hav just one element");
        }
        int cout = 0;

        for (int i = 0; i < trueArray.length - 1; i++) {
            for (int k = i + 1; k < trueArray.length; k++) {
                if (trueArray[i] > trueArray[k]) {
                    for (int j = k; j < trueArray.length; j++) {
                        if (trueArray[i] < trueArray[j]) {
                            int temp1 = trueArray[j];
                            int temp2 = trueArray[i];
                            {
                                trueArray[j] = temp2;
                                trueArray[i] = temp1;
                                cout++;
                            }
                        }
                    }
                }
            }
        }
            if (cout == 1) {
                return true;
            } else return false;
    }
}