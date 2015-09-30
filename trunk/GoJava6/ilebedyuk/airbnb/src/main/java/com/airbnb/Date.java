package com.airbnb;

/**
 * Created by Игорь on 27.09.2015.
 */
public class Date {
    private long dateBegin;
    private long dateEnd;

    public Date(long dateBegin, long dateEnd) {
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public long getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(long dateBegin) {
        this.dateBegin = dateBegin;
    }

    public long getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(long dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void getPeriod(){
        System.out.println("Period is begin " + dateBegin + " and end " + dateEnd);
    }
}
