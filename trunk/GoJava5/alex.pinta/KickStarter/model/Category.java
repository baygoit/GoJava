package Lessons1.KickStarter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 5:42
 * @version: 1.0
 */

public class Category {
    public String name;
    private int id;
    public Category(int pId, String pName) {
        name = pName;
        id = pId;
    }

    public int getId() {
        return id;
    }
}
