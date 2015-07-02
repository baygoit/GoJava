package Lessons1.KickStarter.Model;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 7:36
 * @version: 1.0
 */
public class LoaderData {

    public void loadDataWebSite(){
        Node mainNode = new Node("List of category",    Node.NodesType.MAIN);
        mainNode.addElement(new Node("Education",       Node.NodesType.CATEGORY));
        mainNode.addElement(new Node("Games",           Node.NodesType.CATEGORY));
        mainNode.addElement(new Node("Software",        Node.NodesType.CATEGORY));


    }
}
