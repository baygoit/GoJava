package nikfisher.kickstarter.model;

@SuppressWarnings("deprecation")
public class Category {

    final private String NAME;
    private int id;

    @Deprecated
    public Category(String name) {
        this.NAME = name;
    }

    public Category(int id, String name) {
        this(name);
        this.id = id;
    }

    // TODO Temporary method
    @Override
    public String toString(){
        return String.format("Category [name = %s, id=  %s]", NAME,  id);
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
}
