package adapter;

import java.util.Comparator;

/**
 * Created by Игорь on 12.12.2015.
 */
public class CarAdapter  implements Car{
    private Tree tree;

    public CarAdapter(Tree tree) {
        this.tree = tree;
    }

    public String getCarName() {
        return tree.getName();
    }

    public String getColor() {
        return tree.getTreeColor();
    }


}
