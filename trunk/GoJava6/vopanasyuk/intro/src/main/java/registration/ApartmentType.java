package registration;

/**
 * Created by oktopus on 21.09.15.
 */
public enum ApartmentType {
    PLACE ("place"),
    ROOM ("room"),
    APARTMENT ("apartment");

    private final String apartmentType;

    ApartmentType(String apartmentType) {
        this.apartmentType = apartmentType;
    }
    public String getAppartmentType(){
        return apartmentType;
    }
}
