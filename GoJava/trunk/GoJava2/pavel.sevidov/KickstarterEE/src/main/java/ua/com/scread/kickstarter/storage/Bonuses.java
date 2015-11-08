package ua.com.scread.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;

import ua.com.scread.kickstarter.data.Bonus;
import ua.com.scread.kickstarter.data.FAQ;

public class Bonuses {
    private List<Bonus> bonuses = new ArrayList<Bonus>();
    
    public Bonuses(List<Bonus> bonuses) {
        this.bonuses = bonuses;
    }
    
    public Bonuses(Bonus bonus) {
        bonuses.add(bonus);
    }
    
    public Bonuses() { }

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
    
    @Override
    public String toString() {
    	String result = "";
    	for(Bonus bonus: bonuses) {
    		result += bonus.toString();
    	}
    	return result;
    }
}
