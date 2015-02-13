package ua.com.scread.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Bonuses {
    private List<Bonus> bonuses;
    
    public Bonuses(List<Bonus> bonuses) {
        this.bonuses = new ArrayList<Bonus>();
        this.bonuses = bonuses;
    }
    
    public Bonuses(Bonus bonus) {
        this.bonuses = new ArrayList<Bonus>();
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
