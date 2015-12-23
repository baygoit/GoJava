package com.gojava6.dao;

public class CitiesDAO {
    private String addNewCity = "insert into airbnb.cities (city) values (?)";
    //private String findCity = "select from airbnb.users where id=?";
    private String getAllCities = "select * from airbnb.cities";


}
