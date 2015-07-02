package Lessons1.KickStarter.Model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 5:42
 * @version: 1.0
 */

public class Node implements StructureElement {
    public enum NodesType{
        MAIN, CATEGORY, PROJECT;
    }
    private String name;
    private NodesType nodeType;
    private ArrayList<StructureElement> nodeArrayList;

    public Node(String pName, NodesType pNodeType) {
        nodeType = pNodeType;
        name = pName;
    }

    @Override
    public boolean isProject() {
        return false;
    }
    public void addElement(StructureElement pStructureElement){
        nodeArrayList.add(pStructureElement);
    }
}
