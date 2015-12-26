//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package dao;

import dao.AbstractDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.City;

public class CitiesDAO extends AbstractDAO {
    public CitiesDAO() {
    }

    public void createCity(String city) {
        String sqlQuery = "INSERT INTO cities (`city_name`) VALUES (\'" + city + "\');";
        this.updateDB(sqlQuery);
    }

    public void updateCityByID(City city) {
        String sqlQuery = "UPDATE cities SET city_name = \'" + city.getName() + "WHERE city_id = " + city.getId();
        this.updateDB(sqlQuery);
    }

    public List<City> getCities() {
        return (List<City>)(List<?>)readDB("SELECT * FROM cities");
    }

    public void deleteCityByID(City city) {
        String sqlQuery = "DELETE FROM cities WHERE city_id = " + city.getId();
        this.updateDB(sqlQuery);
    }

    public City getCityByID(City city) {
        String sqlQuery = "SELECT * FROM cities WHERE city_id =" + city.getId();
        List cityList = this.readDB(sqlQuery);
        return (City)cityList.get(0);
    }

    City readObj(ResultSet resultSet) throws SQLException {
        City result = new City(resultSet.getInt("city_id"), resultSet.getString("city_name"));
        return result;
    }
}

