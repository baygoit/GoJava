package ua.com.goit.gojava7.kickstarter.beans;

public class Category {

    private String name;
    
    public Category() {
        // default bean constructor
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category [name=" + name + "]";
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
        if (name == null && other.name != null) {
            return false;
        }
        if (name != null && !name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
