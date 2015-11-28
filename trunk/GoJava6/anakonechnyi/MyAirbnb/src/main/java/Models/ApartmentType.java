package models;

/**
 * @autor A_Nakonechnyi
 * @date 29.10.2015.
 */
public enum ApartmentType {
    PLACE(1) ,
    ROOM(2),
    APARTMENT(3);

    private int id;
    private ApartmentType (int id) {
        this.id=id;
    }
    public static ApartmentType getType(Integer id) {

        if (id == null) {
            return null;
        }

        for (ApartmentType position : ApartmentType.values()) {
            if (id.equals(position.getId())) {
                return position;
            }
        }
        throw new IllegalArgumentException("No matching type for id " + id);
    }

    public int getId() {
        return id;
    }
}

