package main;

import java.util.Date;

/**
 * Created by user on 30.09.2015.
 */
public class Reservation {
    private Date start;
    private Date finish;
    private final int clientId;

    public Reservation(Date start, Date finish, int clientId) {
        this.start = start;
        this.finish = finish;
        this.clientId = clientId;
        System.out.println("Succesfull reserve");
    }

    public Date getStart() {
        return start;
    }
    public Date getFinish() {
        return finish;
    }

    public Boolean idClientChecker (int clientId) {
        return this.clientId == clientId;

    }

}
