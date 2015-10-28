package exercises;

import java.util.ArrayList;
import java.util.List;


public class PoliceImpl implements  Police {

    private List<String> weapons;
    private List<String> lockedUp;

    public PoliceImpl() {
        lockedUp = new ArrayList<String>();
    }

    public String disarm(String person) {
        if (person == null) {
            throw new IllegalArgumentException();
        }
        if (isPoliceman(person)) {
            throw new IllegalArgumentException("policeman can be disarmed");
        }
        /*for (String weapon : weapons) {
            person = person.replace(weapon, "");
        }*/
        return person;
    }

    public String eliminate(String person) {
        return null;
    }

    public String lockUp(String person) {
        weapons.add(person);
        return null;
    }

    private boolean isPoliceman(String person) {
        return person.toLowerCase().contains("policeman".toLowerCase());
    }

    public void setWeapons(List<String> weapons) {
        this.weapons = weapons;
    }

    public String makeFee() {
        return null;
    }

    public List<String> getLockedUp() {
        return lockedUp;
    }
}
