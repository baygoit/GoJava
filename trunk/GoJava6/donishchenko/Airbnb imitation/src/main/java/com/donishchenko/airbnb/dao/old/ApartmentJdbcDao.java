package com.donishchenko.airbnb.dao.old;

import com.donishchenko.airbnb.dao.ApartmentDao;
import com.donishchenko.airbnb.dbutils.JdbcUtils;
import com.donishchenko.airbnb.dbutils.QueryBuilder;
import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.ApartmentType;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ApartmentJdbcDao implements ApartmentDao {
    private static final String saveApartmentQuery =
            "INSERT INTO apartment VALUES(null, ?, ?, ?, ?)";

    private static final String deleteApartmentQuery =
            "DELETE FROM apartment WHERE id = ?";

    private static final String getApartmentByIdQuery =
            "SELECT * FROM apartment WHERE id = ?";

    private static final String getAllApartmentsQuery =
            "SELECT * FROM apartment";

    private static final String updateApartmentQuery =
            "UPDATE apartment SET userId = ?, city = ?, type = ?, active = ? WHERE id = ?";

    @Override
    public int save(Apartment apartment) throws SQLException {
        try (Connection conn = JdbcUtils.getConnection()){
            PreparedStatement stat = conn.prepareStatement(saveApartmentQuery, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, apartment.getHostId());
            stat.setString(2, apartment.getCity());
            stat.setInt(3, apartment.getApartmentType().ordinal());
            stat.setBoolean(4, apartment.isActive());

            stat.executeUpdate();

            ResultSet keys = stat.getGeneratedKeys();
            keys.next();
            apartment.setId(keys.getInt(1));

            return apartment.getId();
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(deleteApartmentQuery);
            stat.setInt(1, id);

            int affectedRows = stat.executeUpdate();

            return affectedRows != 0;
        }
    }

    @Override
    public boolean update(int id, Apartment apartment) throws SQLException {
        Apartment existingApartment = get(id);
        if (existingApartment == null) {
            throw new SQLException("Wrong id");
        }

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(updateApartmentQuery);
            stat.setInt(1, apartment.getHostId());
            stat.setString(2, apartment.getCity());
            stat.setInt(3, apartment.getApartmentType().ordinal());
            stat.setBoolean(4, apartment.isActive());
            stat.setInt(5, id);

            int affectedRows = stat.executeUpdate();

            return affectedRows != 0;
        }
    }

    @Override
    public Apartment get(int id) throws SQLException {
        try (Connection conn = JdbcUtils.getConnection()) {
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
        return getAllApartmentsWithParameter("userId", Integer.toString(id));
    }

    private List<Apartment> getAllApartmentsWithParameter(String...args) throws SQLException {
        QueryBuilder queryBuilder = new QueryBuilder(getAllApartmentsQuery);
        queryBuilder.parseSql(args);

        try (Connection conn = JdbcUtils.getConnection()) {
            List<Apartment> list = new LinkedList<>();
            String query = queryBuilder.getQuery();
            PreparedStatement stat = conn.prepareStatement(query);

            int i = 1;
            for (Object value : queryBuilder.values()) {
                stat.setObject(i++, value);
            }

            ResultSet result = stat.executeQuery();
            while (result.next()) {
                list.add(createApartment(result));
            }

            return list;
        }
    }

    private Apartment createApartment(ResultSet result) throws SQLException {
        int id              = result.getInt(1);
        int userId          = result.getInt(2);
        String city         = result.getString(3);
        ApartmentType type  = ApartmentType.values()[result.getInt(4)];
        boolean active      = result.getBoolean(5);

        Apartment apartment = new Apartment(userId, city, type, active);
        apartment.setId(id);

        return apartment;
    }
}
