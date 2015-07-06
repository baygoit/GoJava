package ua.goit.kyrychok;

import java.util.List;
import java.util.Date;

public class Project {
    private String name;
    private String description;
    private String shortDescription;
    private Integer pledgeGoal;
    private Integer pledge;
    private Date createDate;
    private Date deadlineDate;
    private List<Comment> comments;
    private List<Event> events;
}
