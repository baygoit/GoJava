package home_work.adapter;

public class TreeImpl implements Tree, Marker {
    private String name;
    private String color;

    public TreeImpl(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getTreeName() {
        return name;
    }

    @Override
    public String getTreeColor() {
        return color;
    }

    @Override
    public String toString() {
        return getTreeName() + " " + getTreeColor();
    }
}
