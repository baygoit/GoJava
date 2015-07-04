package Lessons1.KickStarter.Model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 5:16
 * @version: 1.0
 */
public interface StructureElement {
    public boolean isProject();
    public ArrayList<StructureElement> getChild();
}
