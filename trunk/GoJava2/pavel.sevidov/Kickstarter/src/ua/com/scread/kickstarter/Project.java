package ua.com.scread.kickstarter;

public class Project {
	private String name;
	private String description;
	private double collected;
	private double amount;
	private int days;
	private Category category;
	private Details details;

	public Project(String name, String description, double amount, int days, Details delails) {
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

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Details getDetails() {
		return details;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result
                + ((category == null) ? 0 : category.hashCode());
        temp = Double.doubleToLongBits(collected);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + days;
        result = prime * result
                + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((details == null) ? 0 : details.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Project other = (Project) obj;
        if (Double.doubleToLongBits(amount) != Double
                .doubleToLongBits(other.amount))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (Double.doubleToLongBits(collected) != Double
                .doubleToLongBits(other.collected))
            return false;
        if (days != other.days)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (details == null) {
            if (other.details != null)
                return false;
        } else if (!details.equals(other.details))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
