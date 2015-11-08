package freetime;

public class DayStatus {

    private int workloadPercent; // now is not used. If Employee is busy a part
                                 // of a day
    private boolean dayoff; // workloadPercent have no meaning in this case

    public DayStatus(boolean dayoff) {
        this.dayoff = dayoff;
    }
    
    public DayStatus() {
        this.dayoff = false;
        this.workloadPercent = 0;
    }

    public int getWorkloadPercent() {
        return workloadPercent;
    }

    public void setWorkloadPercent(int workloadPercent)
            throws FreetimeException {
        if (workloadPercent > 100 || workloadPercent < 0) {
            throw new FreetimeException();
        }
        this.workloadPercent = workloadPercent;
    }

    public boolean isDayoff() {
        return dayoff;
    }

    public void setDayoff(boolean dayoff) {
        this.dayoff = dayoff;
    }

    public boolean isAvailable() {

        if (dayoff || workloadPercent == 100) {
            return false;
        }

        return true;
    }

}
