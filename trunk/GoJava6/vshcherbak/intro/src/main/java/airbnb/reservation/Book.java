package airbnb.reservation;

import airbnb.model.RentType;

import java.util.*;

public class Book {
    private String city;
    private RentType rentType;
    private List<ReservationDates> reservationDates;
    private List<Integer> place = new ArrayList<>();
    private List<Integer> room = new ArrayList<>();
    private List<Integer> apartment = new ArrayList<>();

    public Book(String city) { this.city = city; }
    public String getCity() { return city; }
    public void addPlace (int id) { place.add(id); }
    public void addRoom (int id) { room.add(id); }
    public void addApartment (int id) { apartment.add(id); }
    public void removePlace (int id) { place.remove(id); }
    public void removeRoom (int id) { room.remove(id); }
    public void removeApartment (int id) { apartment.remove(id); }

    public int isAvailable(Date start, Date end, RentType rent) {
        switch (rent) {
            case PLACE: return search(place, start, end);
            case ROOM: return search(room, start, end);
            case APARTMENT: return search(apartment, start, end);
        }
        return -1;
    }

    private int search(List<Integer> list, Date start, Date end) {
        next: for ( Integer ID: list) {
            boolean present = true;
            for ( ReservationDates reserv: reservationDates ) {
                if (ID.equals(reserv.getHostID())) {
                    if (start.compareTo(reserv.getEnd()) < 0 || end.compareTo(reserv.getStart()) > 0 ) {
                        present = false;
                        continue next;
                    }
                }
            }
            if (present) {
                return ID;
            }
        }
        return -1;
    }

    public void makeReservation(int clientID, Date start, Date end,  RentType rent) {
        int hostID = isAvailable(start, end, rent);
        if (hostID >= 0) {
            reservationDates.add(new ReservationDates(hostID, clientID, start, end,  rent));
        }
    }
}
