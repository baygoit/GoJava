package Lessons1.KickStarter.Model.ProjectElements;

import Lessons1.KickStarter.Model.ProjectElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 5:57
 * @version: 1.0
 */
public class ProjectLink implements ProjectElement {
    private HashMap<String, Integer> layout;
    private ArrayList<DataElement> dataArrayList;

    public ProjectLink(String pDescription, String pUser) {
        dataArrayList.add(new DataElement(pDescription, pUser));
    }

    @Override
    public HashMap<String, Integer> getLayout() throws InstantiationException{
        if (layout.isEmpty()) {
            new InstantiationException("Element don't have layout parameters");
            return null;
        } else {
            return layout;
        }
    }

    @Override
    public HashMap<String, Integer> getLayoutPattern() {
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        temp.put("description",     0);
        temp.put("link",            0);

        return temp;
    }

    @Override
    public void setLayout(HashMap<String, Integer> layout) {
        this.layout = layout;
    }

    public class DataElement {
        public String description;
        public String link;

        DataElement(String pDescription, String pUser) {
            description = pDescription;
            link = pUser;
        }
    }
}