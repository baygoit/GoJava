package com.azuiev.Books;

import com.azuiev.App;
import com.azuiev.Users.Host;
import com.azuiev.Validator;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lera on 23.09.2015.
 */
public class Book implements Comparable<Book> {
    private static Set<Book> books = new TreeSet<Book>();
    private Host owner;
    private String city;
    private String address;

    private ApartType apartType;

    List<ReservationDates> periods = new LinkedList<ReservationDates>();

    public static Book createBook(Host owner, String city, String address, ApartType apartType){

        Book book = new Book(owner,city,address,apartType);

        Validator v = Validator.getInstance();

        if (!v.validateBook(book)) {
            App.log.error("failed to create - " + book);
        } else {
            App.log.info("successfully created - " + book);
            if(books.add(book)){
                App.log.info("added into listBooks - " + book);
            } else {
                App.log.error("already in listBooks - " + book);
            }
        }
        return null;
    }

    private Book(Host owner, String city, String address, ApartType apartType) {
        this.owner = owner;
        this.city = city;
        this.address = address;
        this.apartType = apartType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ApartType getApartType() {
        return apartType;
    }

    public void setApartType(ApartType apartType) {
        this.apartType = apartType;
    }

    public boolean reserve(Date start, Date end) {
        Date date1, date2;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        for (ReservationDates period : periods) {
            date1 = period.getBegin();
            date2 = period.getEnd();
            if (end.compareTo(date1) <= 0) {
                continue;
            }

            if (start.compareTo(date2) >= 0) {
                continue;
            }

            App.log.error("Can`t be reserved - " + this + " in period {"+dateFormat.format(start)+":"+dateFormat.format(end));
            return false;

        }

        periods.add(new ReservationDates(start, end));
        App.log.info("Successfully reserved - " + this + " in period {" + dateFormat.format(start) + ":" + dateFormat.format(end));
        return true;
    }

    @Override
    public int compareTo(Book o) {
        return city.compareTo(o.getCity())*100+address.compareTo(o.getAddress());
    }

}
