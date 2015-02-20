package ua.com.scread.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.Bonus;

public class Bonuses {
    private List<Bonus> bonuses = new ArrayList<Bonus>();
    
    public Bonuses(List<Bonus> bonuses) {
        this.bonuses = bonuses;
    }
    
    public Bonuses(Bonus bonus) {
        bonuses.add(bonus);
    }
    
    public void add(Bonus bonus) {
        bonuses.add(bonus);
    }
    
    public List<Bonus> getBonuses() {
        return bonuses;
    }
    
    public Bonus getBonus(int index) {
        return bonuses.get(index);
    }
    
    public int size() {
        return bonuses.size();
    }
}
