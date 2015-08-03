package KickStarter.dao;

import KickStarter.model.Category;
import KickStarter.model.Project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 30.07.15
 * Time: 12:08
 * @version: 1.0
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLSampleHashMapEntry{
    private Category key;
    private ArrayList<Project> value;

    public XMLSampleHashMapEntry(Category key, ArrayList<Project> value) {
        this.key = key;
        this.value = value;
    }

    public XMLSampleHashMapEntry() {
    }

    public Category getKey() {
        return key;
    }

    public ArrayList<Project> getValue() {
        return value;
    }
}