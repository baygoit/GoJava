package com.gojava6.refactoring.extract;

import java.util.Timer;

/**
 * Created by sergiigetman on 9/30/15.
 */
public class Smartphone {

    public long getCurrentTime(){
        return System.currentTimeMillis();
    }

    public Timer getTimer() {
        return new Timer();
    }

    public int getTemperature() {
        return 0;
    }
}
