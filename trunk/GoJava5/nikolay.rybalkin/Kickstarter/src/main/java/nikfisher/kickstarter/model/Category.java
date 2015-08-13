package nikfisher.kickstarter.model;

public class Category {

    final private String NAME;
    private int id;

    public Category(int id, String name) {
        this.NAME = name;
        this.id = id;
    }

    public String getName() {
        return NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return !(NAME != null ? !NAME.equals(category.NAME) : category.NAME != null);
    }

    @Override
    public int hashCode() {
        return NAME != null ? NAME.hashCode() : 0;
    }

    public int getID() {
        return id;
    }
}
