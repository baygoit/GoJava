package com.gojava6.junit.exercises;

import java.util.List;

/**
 * Created by sergiigetman on 9/24/15.
 */
public interface Police {
    String disarm(String person);

    String eliminate(String person);

    String lockUp(String person);

    List<String> getLockedUp();

    void setWeapons(List<String> weapons);

    String makeFee();

}