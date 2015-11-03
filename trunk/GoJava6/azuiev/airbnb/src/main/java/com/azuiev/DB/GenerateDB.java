package com.azuiev.db;

import com.azuiev.dao.DaoDB;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 09.10.15.
 */
public class GenerateDB implements DaoDB{
    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String dbName = "airbnb";
    private static final String user = "root";
    private static final String password = "masta";
    private static final String driver = "com.mysql.jdbc.Driver";

    private static Connection connection = null;

    public static void main(String[] args) {
        new GenerateDB().recreate();
    }

    @Override
    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

    @Override
    public void closeConnection() {

    }
    private void recreate() {

        List<String> list = new ArrayList<String>();
        list.add("DropSchema");
        list.add("CreateSchema");
        list.add("CreateUserTable");
        list.add("CreateCityTable");
        list.add("CreateApartmentTable");
        list.add("CreateReservationTable");
        list.add("CreateRoleTable");
        list.add("CreateCityImages");
        list.add("AddUsers");
        list.add("AddCities");
        list.add("AddRole");
        list.add("AddApartment");
        list.add("AddReservations");
        list.add("AddCityImages");


        for (String fileName : list) {
            execute(fileName);

        }


    }

    private void execute(String fileName) {
        DaoDB db = new GenerateDB();
        Connection connection = db.getConnection();
        try {

            ClassLoader cl = this.getClass().getClassLoader();
            BufferedReader reader = new BufferedReader(new FileReader(new File(cl.getResource(fileName).getPath().replaceAll("%20"," "))));
            String query = "";
            String s = "";
            s = reader.readLine();
            while (s != null) {
                query += s;
                s = reader.readLine();
            }
            Statement statement = connection.createStatement();
            if (!statement.execute(query)) {
                System.out.println(fileName + ".sql completed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
