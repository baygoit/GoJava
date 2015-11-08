package exercises;

import java.util.List;


public interface Police {
    String disarm(String person);

    String eliminate(String person);

    String lockUp(String person);

    List<String> getLockedUp();

    void setWeapons(List<String> weapons);

    String makeFee();

}