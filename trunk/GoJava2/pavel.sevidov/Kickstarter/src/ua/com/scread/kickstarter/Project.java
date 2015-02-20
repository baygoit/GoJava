package ua.com.scread.kickstarter.data;

import ua.com.scread.kickstarter.storage.Bonuses;

public class Project {
    private String name;
    private String description;
    private double collected;
    private double amount;
    private int days;
    private Category category;
    private AdditionalInfo details;

    public Project(String name, String description, double amount, int days, AdditionalInfo delails) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.days = days;
        this.details = delails;
        collected = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCollected() {
        return collected;
    }

    public double getAmount() {
        return amount;
    }

    public int getDays() {
        return days;
    }

    public Category getCategory() {
        return category;
    }
    
    public void addMoney(double amount) {
        collected += amount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public AdditionalInfo getDetails() {
        return details;
    }
    
    public void addFAQ(FAQ faq) {
        details.addFAQ(faq);
    }

    public Bonus getBonus(int index) {
        return details.getBonus(index);
    }
    
    public Bonuses getBonuses() {
        return details.getBonuses();
    }

    @Override
    public String toString() {
        return name + ";" + description + ";" + collected + ";" + amount + ";" 
                    + days + ";" + details.toString() + "\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;            
        }
        
        if (obj == null) {
            return false;            
        }
        
        if (getClass() != obj.getClass()) {
            return false;            
        }
        
        Project other = (Project) obj;
        
        if (name == null) {
            if (other.name != null) {
                return false;                
            }
        } else if (!name.equals(other.name)) {
            return false;            
        }
        
        return true;
    }
}
