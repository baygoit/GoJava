import com.shcherbak.accounting.ReservationDates;
import com.shcherbak.common.Processor;
import com.shcherbak.model.Apartment;
import com.shcherbak.model.RentType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Booking {
    private Set<Apartment> apartments;
    private List<ReservationDates> reservation;
    private Processor processor;

    public Booking(Processor processor) {
        this.processor = processor;
    }

    public void makeReservation(int apartmentID, int clientID, String startString, String endString)throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dt.parse(startString);
        Date end = dt.parse(endString);
        processor.addReservation(apartmentID, clientID, start, end);
    }

    public List<Apartment> search( String city, RentType rent, String startString, String endString ) throws ParseException {
        List<Apartment> apartments;
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dt.parse(startString);
        Date end = dt.parse(endString);
        apartments = processor.search(city, rent, start, end);
        return apartments;
    }

    public void clean(int id) {
        processor.removeReservation(id);
    }

    public void clean(Date date) {
        processor.removeReservations(date);
    }
}
