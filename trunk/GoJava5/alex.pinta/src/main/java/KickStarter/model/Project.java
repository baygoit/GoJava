package KickStarter.model;

import sun.reflect.Reflection;
import sun.reflect.generics.tree.FieldTypeSignature;

import javax.xml.bind.annotation.*;
import java.lang.reflect.Field;
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
@XmlRootElement(name = "Project")
@XmlAccessorType (XmlAccessType.FIELD)
public class Project {
    @XmlTransient
    private boolean isChangedProperty = false;
    @XmlAttribute
    private int Id;

    @XmlAttribute
    public String name;

    @XmlAttribute
    public String fullDescription;

    @XmlAttribute
    public double requirementAmount;

    @XmlAttribute
    public double balancedAmount;

    @XmlAttribute
    public int daysLeft;

    public boolean isChangedProperty() {
        return isChangedProperty;
    }

    public void commitChange() {
        isChangedProperty = false;
    }

    @XmlTransient
    public ArrayList<History> historyOfProject = new ArrayList<History>();

    @XmlTransient
    public ArrayList<VideoLink> demoLink = new ArrayList<VideoLink>();

    @XmlTransient
    public ArrayList<QuestionAnswer> userQuestion = new ArrayList<QuestionAnswer>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (Id != project.Id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Id;
    }

    @XmlTransient
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

    @XmlTransient
    public class VideoLink {
        public String description;
        public String link;

        VideoLink(String pDescription, String pLink) {
            description = pDescription;
            link = pLink;
        }
    }

    @XmlTransient
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

    public Project() {
    }

    public int getId() {
        return Id;
    }

    public Project(int pId, String pName) {
        name = pName;
        Id = pId;
    }

    public Project(int pId, String pName, String pFullDescription, double pRequirementAmount, double pBalancedAmount, int pDaysLeft) {
        Id = pId;
        name = pName;
        fullDescription = pFullDescription;
        requirementAmount = pRequirementAmount;
        balancedAmount = pBalancedAmount;
        daysLeft = pDaysLeft;
    }

    public void addHistoryOfProject(String pDescription, String pUser, Date pDateAdded) {
        historyOfProject.add(new History(pDescription, pUser, pDateAdded));
        isChangedProperty = true;
    }

    public void addDemoLink(String pDescription, String pLink) {
        demoLink.add(new VideoLink(pDescription, pLink));
        isChangedProperty = true;
    }

    public void addUserQuestionAnswer(String pDescription, String pUser, Date pDateAdded) {
        userQuestion.add(new QuestionAnswer(pDescription, pUser, pDateAdded));
        isChangedProperty = true;
    }

    public <T> boolean updateData(String field, T value){
        Field classField;
        try {
            classField = Project.class.getField(field);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Illegal name of class field");
        }
        try {
            classField.set(this, value);
            isChangedProperty = true;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unexpected type of value for class field: " + field);
        }
        return true;
    }
}


