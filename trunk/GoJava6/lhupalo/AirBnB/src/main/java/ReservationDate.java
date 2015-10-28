/**
 * Created by Ыўср on 05.10.2015.
 */
public class ReservationDate {
    private User user;
    private long start;
    private long end;

    public ReservationDate(User user, long end, long start) {
        this.start = start;
        this.end = end;
        this.user = user;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public User getUser() {
        return user;
    }

}

