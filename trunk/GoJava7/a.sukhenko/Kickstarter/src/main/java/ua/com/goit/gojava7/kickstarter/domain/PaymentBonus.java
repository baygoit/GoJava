package ua.com.goit.gojava7.kickstarter.domain;

import java.util.HashMap;
import java.util.Map;

public class PaymentBonus{
    private Map<Integer, String> bonuses = new HashMap<>();

    public PaymentBonus() {
        bonuses.put(1, "Bonus for 1");
        bonuses.put(10, "Bonus for 10");
        bonuses.put(40, "Bonus for 40");
    }

    public Map<Integer, String> getBonuses() {
        return bonuses;
    }

    public void setBonuses(Map<Integer, String> bonuses) {
        this.bonuses = bonuses;
    }

}
