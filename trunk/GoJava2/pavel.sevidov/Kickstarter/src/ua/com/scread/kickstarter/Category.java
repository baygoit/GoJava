package ua.com.scread.kickstarter.data;

public class Category {
    private String name;
    private int index;

    public Category(String name) {
        this.name = name;
    }
    
    public Category(int index, String name) {
        this(name);
        this.index = index;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name + "\n";
    }

    public int getIndex() {
        return index;
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
        
        Category other = (Category) obj;
        
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
