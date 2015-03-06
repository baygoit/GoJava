//To use this class you must put mysql-connector-java-3.0.10-stable-bin.jar and postgresql-9.4-1200.jdbc4.jar in /lib folfer
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("Hello World!");
        pw.println("<br>");
        pw.println("Hello World!");
        pw.println("<br>");

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1/kickstarter", "postgres",
                    "pass");
        } catch (SQLException e) {
            pw.println("Не могу подключится к базе!!!1");
            pw.println("<br>");
        } catch (ClassNotFoundException e) {
            pw.println("ClassNotFoundException" + e);
        }

        if (connection != null) {
            pw.println("You made it, take control your database now!");
        } else {
            pw.println("Failed to make connection!");
        }

        java.sql.Statement statement;
        try {
            statement = connection.createStatement();
            // Выполним запрос
            ResultSet result;
            try {
                result = (statement).executeQuery("SELECT * FROM categories");
                while (result.next()) {
                    pw.println(result.getString("name"));
                    pw.println("<br>");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

}
