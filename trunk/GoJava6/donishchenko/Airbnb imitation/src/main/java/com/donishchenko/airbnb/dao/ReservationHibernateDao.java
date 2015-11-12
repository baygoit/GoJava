package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.model.Reservation;

import java.util.Date;
import java.util.List;

public class ReservationHibernateDao implements ReservationDao {
    private HibernateDefaultRawDao defaultDao = new HibernateDefaultRawDao(Reservation.class);

    private static final String getAllBetweenDatesQuery =
            "FROM Reservation R WHERE R.start >= ? AND R.end <= ?";

    public ReservationHibernateDao() {}

    @Override
    public void save(Reservation reservation) {
        defaultDao.save(reservation);
    }

    @Override
    public Reservation get(Integer id) {
        return defaultDao.get(id);
    }

    @Override
    public boolean update(Reservation reservation) {
        return defaultDao.update(reservation);
    }

    @Override
    public boolean delete(Integer id) {
        return defaultDao.delete(id);
    }

    @Override
    public List<Reservation> getAll() {
        return defaultDao.getList();
    }

    @Override
    public List<Reservation> getAllByApartment(Integer apartmentId) {
        return defaultDao.getList("apartment.id", apartmentId);
    }

    @Override
    public List<Reservation> getAllByUser(Integer userId) {
        return defaultDao.getList("user.id", userId);
    }

    @Override
    public List<Reservation> getAllBetweenDates(Date start, Date end) {
        return defaultDao.getList(getAllBetweenDatesQuery, new Object[] {start, end});
    }
}
