package Lessons1.KickStarter.Model;

import Lessons1.KickStarter.Model.ProjectElements.ProjectDescription;
import Lessons1.KickStarter.Model.ProjectElements.ProjectHistory;
import Lessons1.KickStarter.Model.ProjectElements.ProjectLink;
import Lessons1.KickStarter.Model.ProjectElements.ProjectQuestionAnswer;

import java.sql.*;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 7:36
 * @version: 1.0
 */
public class LoaderData {

    public Node loadDataWebSite(){
        Node mainNode = new Node("List of category",    Node.NodesType.MAIN);
        mainNode.addElement(new Node("Education",       Node.NodesType.CATEGORY));
        mainNode.addElement(new Node("Games",           Node.NodesType.CATEGORY));
        mainNode.addElement(new Node("Software",        Node.NodesType.CATEGORY));

        Project locProject;
        ProjectElement locProjectElement;
        locProject = new Project("Project math for school");
        locProjectElement = new ProjectDescription("Project for pupils 9-10 class", 100, 80, 31);
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectHistory("We create new feature - online check your test", "Developer", Date.valueOf("20140510"));
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectLink("Demo version", "http://");
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectQuestionAnswer("How long are u going to develop this project?", "Ivanov", Date.valueOf("20140115"));
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectQuestionAnswer("During 3 month", "Moderator", Date.valueOf("20140116"));
        locProject.loadDataProjectElement(locProjectElement);
        ((Node)mainNode.getChild().get(0)).addElement(locProject);

        locProject = new Project("Project english for school");
        locProjectElement = new ProjectDescription("Do you speak english? Let's study together!!!", 1000, 756, 45);
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectHistory("We finish case test! We start production as soon as possible", "Developer", Date.valueOf("20140510"));
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectLink("Demo version", "http://");
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectQuestionAnswer("Oh buddy it's good idea. I'm looking for similar project for pupils 2-3 class. Is it interesting for you?"
                                                      ,"Teacher", Date.valueOf("20140322"));
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectQuestionAnswer("Yes, send me your contact on offer@kickstarter.com", "Moderator", Date.valueOf("20140116"));
        locProject.loadDataProjectElement(locProjectElement);
        ((Node)mainNode.getChild().get(0)).addElement(locProject);

        locProject = new Project("Project chemistry for school");
        ((Node)mainNode.getChild().get(0)).addElement(locProject);

        locProject = new Project("Worms");
        locProjectElement = new ProjectDescription("WORMS!!! WORMS!!! WORMS!!! Challenge everybody.", 5505, 5505, 1);
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectHistory("We decided to realized worms in 3D", "Developer", Date.valueOf("20140510"));
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectLink("Demo version", "http://");
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectQuestionAnswer("Will be there opportunity of multi and single player?", "Gamer Vasya", Date.valueOf("20140725"));
        locProject.loadDataProjectElement(locProjectElement);
        locProjectElement = new ProjectQuestionAnswer("Yeah, either we are going to start championship!!! And it will be soon.", "Moderator", Date.valueOf("20140107"));
        locProject.loadDataProjectElement(locProjectElement);
        ((Node)mainNode.getChild().get(1)).addElement(locProject);

        locProject = new Project("Balda");
        ((Node)mainNode.getChild().get(1)).addElement(locProject);

        locProject = new Project("Puzzles");
        ((Node)mainNode.getChild().get(1)).addElement(locProject);

        return mainNode;
    }
}
