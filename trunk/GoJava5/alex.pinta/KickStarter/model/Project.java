package Lessons1.KickStarter.model;

//import Lessons1.KickStarter.model.projectProperties.FullDescription;
//import Lessons1.KickStarter.model.projectProperties.History;
//import Lessons1.KickStarter.model.projectProperties.QuestionAnswer;
//import Lessons1.KickStarter.model.projectProperties.VideoLink;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 5:18
 * @version: 1.0
 */
public class Project {
    private int id;
    public String name;
    public String fullDescription;
    public double requirementAmount;
    public double balancedAmount;
    public int daysLeft;
    public List<History> historyOfProject = new ArrayList<History>();
    public List<VideoLink> demoLink = new ArrayList<VideoLink>();
    public List<QuestionAnswer> userQuestion = new ArrayList<QuestionAnswer>();

    public class History {
        public String description;
        public String user;
        public Date dateAdded;

        History(String pDescription, String pUser, Date pDateAdded) {
            description = pDescription;
            user = pUser;
            dateAdded = pDateAdded;
        }
    }

    public class VideoLink {
        public String description;
        public String link;

        VideoLink(String pDescription, String pLink) {
            description = pDescription;
            link = pLink;
        }
    }

    public class QuestionAnswer {
        public String description;
        public String user;
        public Date dateAdded;

        QuestionAnswer(String pDescription, String pUser, Date pDateAdded) {
            description = pDescription;
            user = pUser;
            dateAdded = pDateAdded;
        }
    }

    public int getId() {
        return id;
    }

    public Project(int pId, String pName) {
        name = pName;
        id = pId;
    }

    public Project(int pId, String pName, String pFullDescription, double pRequirementAmount, double pBalancedAmount, int pDaysLeft) {
        id = pId;
        name = pName;
        fullDescription = pFullDescription;
        requirementAmount = pRequirementAmount;
        balancedAmount = pBalancedAmount;
        daysLeft = pDaysLeft;
    }

    public void addHistoryOfProject(String pDescription, String pUser, Date pDateAdded) {
        historyOfProject.add(new History(pDescription, pUser, pDateAdded));
    }

    public void addDemoLink(String pDescription, String pLink) {
        demoLink.add(new VideoLink(pDescription, pLink));
    }

    public void addUserQuestionAnswer(String pDescription, String pUser, Date pDateAdded) {
        userQuestion.add(new QuestionAnswer(pDescription, pUser, pDateAdded));
    }

}


