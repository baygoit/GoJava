package main.java.Models;

import java.util.Date;

/**
 * @autor A_Nakonechnyi
 * @date 30.09.2015.
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
