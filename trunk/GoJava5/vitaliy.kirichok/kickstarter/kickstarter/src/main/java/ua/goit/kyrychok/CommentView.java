package ua.goit.kyrychok;

import java.util.Date;

public class CommentView {

    public void print(String author, String text, Date createDate){
        System.out.println(createDate.toString() + " " + author + ": ");
        System.out.println(text);
    }
}
