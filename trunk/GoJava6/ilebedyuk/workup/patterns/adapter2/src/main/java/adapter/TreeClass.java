package adapter;

/**
 * Created by Игорь on 07.12.2015.
 */
public class TreeClass implements Tree {

    private String name;
    private String treeColor;

    public void setName(String name) {
        this.name = name;
    }

    public void setTreeColor(String treeColor) {
        this.treeColor = treeColor;
    }

    public String getName() {
        return name;
    }

    public String getTreeColor() {
        return treeColor;
    }
}
