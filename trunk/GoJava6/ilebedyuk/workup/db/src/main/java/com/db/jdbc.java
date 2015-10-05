//package com.db;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// * Created by Игорь on 02.10.2015.
// */
//public class Jdbc {
//    private int id;
//    private String name;
//    private String surname;
//    private String city;
//    private Connection conn;
//
//    public boolean connect(){
//        boolean success = true;
//
//        String url = "jdbc:mysql//localhost:3306/USER";
//        String user = "root";
//        String pass = "root";
//
//        try {
//            conn = DriverManager.getConnection(url, user, pass);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            success = false;
//        }
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public Jdbc(int id, String name, String surname, String city) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.city = city;
//    }
//}
