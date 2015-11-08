package ua.com.goit.gojava1.lslayer.hackit2.domain.actor;


public class Position {
    private static final int EARTH_DIAMETER = 6371;
    private double latitude;
    private double longitude;
    
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double countDistance(Position from) {
        
        double latDiff = (from.latitude - latitude) * (Math.PI / 180) ;
        double lonDiff = (from.longitude - longitude) * (Math.PI / 180);
        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2) + 
                   Math.cos(latitude * Math.PI / 180) * Math.cos(from.latitude * Math.PI / 180) *
                   Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
        double b = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_DIAMETER * b;
    }

}
