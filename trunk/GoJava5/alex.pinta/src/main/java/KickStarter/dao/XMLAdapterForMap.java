package KickStarter.dao;

import KickStarter.model.Category;
import KickStarter.model.Project;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 29.07.15
 * Time: 17:39
 * @version: 1.0
 */

public class XMLAdapterForMap extends XmlAdapter<XMLSampleHashMap, HashMap<Category, ArrayList<Project>>>{

    @Override
    public HashMap<Category, ArrayList<Project>> unmarshal(XMLSampleHashMap v) throws Exception {
        HashMap<Category, ArrayList<Project>> map = new HashMap<>(v.getEntries().size());
        for (XMLSampleHashMapEntry key : v.getEntries()) {
//            ArrayList<Project> tmpArrayList = new ArrayList<>();
//            for (Project elem : keyValue.getProjects()){
//                tmpArrayList.add(elem);
//            }
            map.put(key.getKey(), key.getValue());
        }
        return map;
}

    @Override
    public XMLSampleHashMap marshal(HashMap<Category, ArrayList<Project>> varMap) throws Exception {
        XMLSampleHashMap results = new XMLSampleHashMap();
        for (Map.Entry<Category, ArrayList<Project>> entry : varMap.entrySet()) {
            results.setEntries(entry);
        }
        return results;
    }
}
