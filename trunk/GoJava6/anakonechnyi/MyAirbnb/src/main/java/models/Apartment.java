package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import observerFr.Observer;
import observerFr.Subject;

@Entity
@Table (name = "apartments")
public class Apartment implements Subject {
    @Id
    @Column(name = "idapartments"/*, nullable = false, unique = true*/)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int apartmentId;
    @Column (name = "type")
    @Enumerated (EnumType.ORDINAL)
    private ApartmentType apartmentType;
    @Column (name = "address")
    private String address;
    @OneToMany /*(mappedBy = "idapartment")*/
    @JoinColumn (name = "idapartment")
    private List<Reservation> reservationList;
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="city_id")
    private City city;
    //private static String city;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="host_id")
    private User host;
    //@OneToMany (mappedBy = "")
    @Transient
    private List<Observer> listOfClients = new ArrayList();

    public Apartment(int apartmentId, User userHost, ApartmentType type, String address, City city) {
        this.apartmentId = apartmentId;
        this.apartmentType = type;
        this.address = address;
        this.host = userHost;
        this.city = city;
    }

    public void registerObserver(Observer o) {
        System.out.println("Register: " + o.toString());
        this.listOfClients.add(o);
        o.loyalty(10, this);
    }

    public void removeObserver(Observer o) {
        System.out.println("Remove: " + o.toString());
        this.listOfClients.remove(o);
    }

    public void notifyObservers() {
        System.out.println("Notify Observers");
        Iterator var1 = this.listOfClients.iterator();

        while(var1.hasNext()) {
            Observer obs = (Observer)var1.next();
            obs.update(this);
        }

    }

    public City getCity() {
        return city;
    }

    public Boolean isAvailable(Date dateToCheck) {
        Iterator var2 = this.reservationList.iterator();

        Reservation res;
        do {
            if(!var2.hasNext()) {
                return Boolean.valueOf(true);
            }

            res = (Reservation)var2.next();
        } while(res.getStart().compareTo(dateToCheck) >= 1 || res.getFinish().compareTo(dateToCheck) <= -1);

        return Boolean.valueOf(false);
    }

    public int getApartmentId() {
        return this.apartmentId;
    }

    public User getHost() {
        return this.host;
    }

    public Boolean cancelReservation(User client, Reservation reservation) {
        if(reservation.clientChecker(client).booleanValue()) {
            this.reservationList.remove(this.reservationList.indexOf(reservation));
            return Boolean.valueOf(true);
        } else {
            return Boolean.valueOf(false);
        }
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }
}
