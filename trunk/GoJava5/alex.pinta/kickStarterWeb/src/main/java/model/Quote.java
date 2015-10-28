package model;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 15.08.15
 * Time: 19:34
 * @version: 1.0
 */
public class Quote {
    private int id;
    private String description;

    public Quote(int pId, String pDescription) {
        id = pId;
        description = pDescription;
    }


    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String pDescription) {
        description = pDescription;
    }

}
