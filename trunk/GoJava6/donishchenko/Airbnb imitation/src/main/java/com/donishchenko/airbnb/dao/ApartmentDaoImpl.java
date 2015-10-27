package com.donishchenko.airbnb.dao;

import com.donishchenko.airbnb.jdbc.DBUtils;
import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.ApartmentType;
import com.google.common.base.Joiner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ApartmentDaoImpl implements ApartmentDao {
    private static final String saveApartmentQuery =
            "INSERT INTO apartment VALUES(null, ?, ?, ?, ?)";

    private static final String deleteApartmentQuery =
            "DELETE FROM aparment WHERE id = ?";

    private static final String getApartmentByIdQuery =
            "SELECT * FROM apartment WHERE id = ?";

    private static final String getAllApartmentsQuery =
            "SELECT * FROM apartment";

    private static final String updateApartmentQuery =
            "UPDATE apartment SET host = ?, city = ?, type = ?, active = ? WHERE id = ?";

    @Override
    public void save(Apartment apartment) throws SQLException {
        try (Connection conn = DBUtils.getConnection()){
            PreparedStatement stat = conn.prepareStatement(saveApartmentQuery);
            stat.setInt(1, apartment.getHost().getId());
            stat.setString(2, apartment.getCity());
            stat.setInt(3, apartment.getApartmentType().ordinal());
            stat.setBoolean(4, apartment.isActive());

            stat.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(deleteApartmentQuery);
            stat.setInt(1, id);

            stat.executeUpdate();
        }
    }

    @Override
    public void update(int id, Apartment apartment) throws SQLException {
        Apartment existingApartment = get(id);
        if (existingApartment == null) {
            throw new SQLException("Wrong id");
        }

        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(updateApartmentQuery);
            stat.setInt(1, apartment.getHost().getId());
            stat.setString(2, apartment.getCity());
            stat.setInt(3, apartment.getApartmentType().ordinal());
            stat.setBoolean(4, apartment.isActive());
            stat.setInt(5, id);

            stat.executeUpdate();
        }
    }

    @Override
    public Apartment get(int id) throws SQLException {
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(getApartmentByIdQuery);
            stat.setInt(1, id);

            ResultSet result = stat.executeQuery();
            result.next();

            return createApartment(result);
        }
    }

    @Override
    public List<Apartment> getAll() throws SQLException {
        return getAllApartmentsWithParameter();
    }

    @Override
    public List<Apartment> getAllByCity(String city) throws SQLException {
        return getAllApartmentsWithParameter("city", city);
    }

    @Override
    public List<Apartment> getAllByUser(int id) throws SQLException {
        //TODO test
        return getAllApartmentsWithParameter("id", Integer.toString(id));
    }

    private List<Apartment> getAllApartmentsWithParameter(String...args) throws SQLException {
        //TODO QueryBuilder class
//        String query = buildQuery(args);
        String query = getAllApartmentsQuery;
        LinkedList<String> values = new LinkedList<>();

        if (args.length != 0) {
            Joiner joiner = Joiner.on(' ');

            joiner.join(getAllApartmentsQuery, "WHERE");
            for (int i = 0; i < args.length; i++) {
                joiner.join(args[i], "= ?");
                values.add(args[i+1]);
            }
        }

        try (Connection conn = DBUtils.getConnection()) {
            List<Apartment> list = new LinkedList<>();
            PreparedStatement stat = conn.prepareStatement(query);

            int i = 1;
            for (String value : values) {
                stat.setObject(i, value);
            }

            ResultSet result = stat.executeQuery();
            while (result.next()) {
                list.add(createApartment(result));
            }

            return list;
        }
    }

    //TODO QueryBuilder class
//    private String buildQuery(String[] args) {
//        String query = getAllApartmentsQuery;
//
//        if (args.length != 0) {
//            Joiner joiner = Joiner.on(' ');
//            LinkedList<String> values = new LinkedList<>();
//
//            joiner.join(getAllApartmentsQuery, "WHERE");
//            for (int i = 0; i < args.length; i++) {
//                joiner.join(args[i], "= ?");
//                values.add(args[i+1]);
//            }
//        }
//
//        return query;
//    }

    private Apartment createApartment(ResultSet result) throws SQLException {
        int id          = result.getInt(1);
        //TODO getUser
        String city         = result.getString(3);
        ApartmentType type  = ApartmentType.values()[result.getInt(4)];
        boolean active      = result.getBoolean(5);

        Apartment apartment = new Apartment(null, city, type, active);
        apartment.setId(id);

        return apartment;
    }
}
