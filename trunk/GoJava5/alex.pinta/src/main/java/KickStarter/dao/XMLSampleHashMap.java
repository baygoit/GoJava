package KickStarter.dao;

import KickStarter.model.Category;
import KickStarter.model.Project;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 29.07.15
 * Time: 17:49
 * @version: 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class XMLSampleHashMap {
//    @XmlElement
//    private Category key;

    public XMLSampleHashMap() {
    }

    //@XmlElement(type = Project.class, required = true, namespace = "")
    private ArrayList<XMLSampleHashMapEntry> entries = new ArrayList<>();

    public ArrayList<XMLSampleHashMapEntry> getEntries() {
        return entries;
    }

    public void setEntries(Map.Entry<Category, ArrayList<Project>> entries) {
        this.entries.add(new XMLSampleHashMapEntry(entries.getKey(), entries.getValue()));
    }
}