package kickstarter.model;

public class Category {
    
    private String name;
    private int index;
    
    public Category(String name, int index) {
	this.name = name;
	this.index = index;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
	this.name = name;
    }

    public int getIndex() {
        return index;
    }
}
