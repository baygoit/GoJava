package com.donishchenko.airbnb.dao.old;

import com.donishchenko.airbnb.dao.ApartmentDao;
import com.donishchenko.airbnb.dbutils.JdbcUtils;
import com.donishchenko.airbnb.dbutils.QueryBuilder;
import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.ApartmentType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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
    public void save(Apartment apartment) {
        try (Connection conn = JdbcUtils.getConnection()){
            PreparedStatement stat = conn.prepareStatement(saveApartmentQuery, Statement.RETURN_GENERATED_KEYS);
            stat.setInt(1, apartment.getHost().getId());
            stat.setString(2, apartment.getCity());
            stat.setInt(3, apartment.getApartmentType().ordinal());
            stat.setBoolean(4, apartment.isActive());

            stat.executeUpdate();

            ResultSet keys = stat.getGeneratedKeys();
            keys.next();
            apartment.setId(keys.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Apartment get(Integer id) {
        Apartment apartment = null;

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(getApartmentByIdQuery);
            stat.setInt(1, id);

            ResultSet result = stat.executeQuery();
            if (result.next()) {
                apartment = createApartment(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return apartment;
    }

    @Override
    public boolean update(Apartment apartment) {
        boolean updated = false;

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(updateApartmentQuery);
            stat.setInt(1, apartment.getHost().getId());
            stat.setString(2, apartment.getCity());
            stat.setInt(3, apartment.getApartmentType().ordinal());
            stat.setBoolean(4, apartment.isActive());
            stat.setInt(5, apartment.getId());

            int affectedRows = stat.executeUpdate();

            updated = affectedRows != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updated;
    }

    @Override
    public boolean delete(Integer id) {
        boolean deleted = false;

        try (Connection conn = JdbcUtils.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(deleteApartmentQuery);
            stat.setInt(1, id);

            int affectedRows = stat.executeUpdate();

            deleted = affectedRows != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return deleted;
    }

    @Override
    public List<Apartment> getAll() {
        return getAllApartmentsWithParameter();
    }

    @Override
    public List<Apartment> getAllByCity(String city) {
        return getAllApartmentsWithParameter("city", city);
    }

    @Override
    public List<Apartment> getAllByUser(Integer id) {
        return getAllApartmentsWithParameter("userId", id);
    }

    private List<Apartment> getAllApartmentsWithParameter(Object...args) {
        List<Apartment> list = Collections.emptyList();

        QueryBuilder queryBuilder = new QueryBuilder(getAllApartmentsQuery);
        queryBuilder.parse(args);

        try (Connection conn = JdbcUtils.getConnection()) {
            list = new ArrayList<>();

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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    private Apartment createApartment(ResultSet result) throws SQLException {
        int id              = result.getInt(1);
        int userId          = result.getInt(2);
        String city         = result.getString(3);
        ApartmentType type  = ApartmentType.values()[result.getInt(4)];
        boolean active      = result.getBoolean(5);

        //TODO setUser
//        Apartment apartment = new Apartment(userId, city, type, active);
//        apartment.setId(id);

        return new Apartment();
    }
}
