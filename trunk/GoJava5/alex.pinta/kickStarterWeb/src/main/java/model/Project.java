package model;

import javax.persistence.*;
import java.util.Date;
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

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String name;
    private String fullDescription;
    private double requirementAmount;
    private double balancedAmount;
    private int daysLeft;

    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "Id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Category category;

    @OneToMany(targetEntity = History.class, fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.REMOVE)
    private List<History> historyOfProject = new ArrayList<History>();

    @OneToMany(targetEntity = VideoLink.class, fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.REMOVE)
    private List<VideoLink> demoLink = new ArrayList<VideoLink>();

    @OneToMany(targetEntity = QuestionAnswer.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="project_id")
    private List<QuestionAnswer> userQuestion = new ArrayList<QuestionAnswer>();

    @OneToMany(targetEntity = Terms.class, fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.REMOVE)
    private List<Terms> termsList = new ArrayList<Terms>();

    @Entity
    @Table(name = "history")
    public static class History {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int Id;

        @Column(length = 500)
        private String description;

        @Column(length = 100)
        private String userName;

        @Temporal(TemporalType.DATE)
        private Date dateAdded;

        @ManyToOne(fetch = FetchType.LAZY, targetEntity = Project.class)
        @JoinColumn(name = "project_id", referencedColumnName = "Id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
        private Project project;

        public History() {
        }

        public History(String pDescription, String pUser, Date pDateAdded) {
            description = pDescription;
            userName = pUser;
            dateAdded = pDateAdded;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String user) {
            this.userName = user;
        }

        public Date getDateAdded() {
            return dateAdded;
        }

        public void setDateAdded(Date dateAdded) {
            this.dateAdded = dateAdded;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }
    }

    @Entity
    @Table(name = "video_link")
    public static class VideoLink {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int Id;
        @Column(length = 500)
        private String description;
        @Column(length = 100)
        private String link;

        @ManyToOne(fetch = FetchType.LAZY, targetEntity = Project.class)
        @JoinColumn(name = "project_id", referencedColumnName = "Id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
        private Project project;

        VideoLink(String pDescription, String pLink) {
            description = pDescription;
            link = pLink;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public VideoLink() {
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }
    }
    @Entity
    @Table(name = "question_answer")
    public static class QuestionAnswer {
        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="question_answer_seq_gen")
        @SequenceGenerator(name="question_answer_seq_gen", sequenceName="question_answer_id_seq", allocationSize = 1)
        private int Id;

        @Column(length = 500)
        private String description;
        @Column(length = 100)
        private String userName;

        @Temporal(TemporalType.DATE)
        private Date dateAdded;

        QuestionAnswer(String pDescription, String pUser, Date pDateAdded) {
            description = pDescription;
            userName = pUser;
            dateAdded = pDateAdded;
        }

        public QuestionAnswer() {
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String user) {
            this.userName = user;
        }

        public Date getDateAdded() {
            return dateAdded;
        }

        public void setDateAdded(Date dateAdded) {
            this.dateAdded = dateAdded;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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

    public Project() {
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
    }

    public void addDemoLink(String pDescription, String pLink) {
        demoLink.add(new VideoLink(pDescription, pLink));
    }

    public void addUserQuestionAnswer(String pDescription, String pUser, Date pDateAdded) {
        userQuestion.add(new QuestionAnswer(pDescription, pUser, pDateAdded));
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String pFullDescription) {
        fullDescription = pFullDescription;
    }

    public double getRequirementAmount() {
        return requirementAmount;
    }

    public void setRequirementAmount(Double pRequirementAmount) {
        requirementAmount = pRequirementAmount;
    }

    public double getBalancedAmount() {
        return balancedAmount;
    }

    public void setBalancedAmount(Double pBalancedAmount) {
        balancedAmount = pBalancedAmount;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int pDaysLeft) {
        daysLeft = pDaysLeft;
    }

    public List<History> getHistoryOfProject() {
        return historyOfProject;
    }

    public void setHistoryOfProject(List<History> pHistoryOfProject) {
        historyOfProject = pHistoryOfProject;
    }

    public List<VideoLink> getDemoLink() {
        return demoLink;
    }

    public void setDemoLink(List<VideoLink> pDemoLink) {
        demoLink = pDemoLink;
    }

    public List<QuestionAnswer> getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(List<QuestionAnswer> pUserQuestion) {
        userQuestion = pUserQuestion;
    }

    public List<Terms> getTermsList() {
        return termsList;
    }

    public void setTermsList(List<Terms> termsList) {
        this.termsList = termsList;
    }

    @Entity
    @Table(name = "terms")
    public static class Terms{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int Id;
        @Column(name = "pay_amount")
        private double payAmount;
        @Column(name = "definition_of_advantage")
        private String definitionOfAdvantage;

        @ManyToOne(fetch = FetchType.LAZY, targetEntity = Project.class)
        @JoinColumn(name = "project_id", referencedColumnName = "Id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
        private Project project;

        public double getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(double payAmount) {
            this.payAmount = payAmount;
        }

        public String getDefinitionOfAdvantage() {
            return definitionOfAdvantage;
        }

        public void setDefinitionOfAdvantage(String definitionOfAdvantage) {
            this.definitionOfAdvantage = definitionOfAdvantage;
        }

        public Terms() {
        }

        public Terms(double payAmount, String definitionOfAdvantage) {
            this.payAmount = payAmount;
            this.definitionOfAdvantage = definitionOfAdvantage;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }
    }


}


