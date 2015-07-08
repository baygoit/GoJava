package ua.goit.kyrychok.domain;

import java.util.Date;
import java.util.List;

public class Comment {
    private Date createDate;
    private String author;
    private String text;
    private List<Comment> comments;
}
