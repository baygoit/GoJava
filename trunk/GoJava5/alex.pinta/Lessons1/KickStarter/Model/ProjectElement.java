package Lessons1.KickStarter.Model;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 5:25
 * @version: 1.0
 */
public interface ProjectElement {
    public HashMap<String, Integer> getLayout() throws InstantiationException;
    public void setLayout(HashMap<String, Integer> layout);
    public HashMap<String, Integer> getLayoutPattern();
}
