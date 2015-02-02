package freetime;

public class DayStatus {
    private int workloadPercent;
    private boolean dayoff;
    
    public boolean isAvailable(){
        
        if (dayoff || workloadPercent==100) {
            return false;
        }
    
        return true;
    }
}
