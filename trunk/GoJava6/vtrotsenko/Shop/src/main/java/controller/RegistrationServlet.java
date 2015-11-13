package controller;

import com.mysql.jdbc.Connection;
import jdbc.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by root on 04.11.15.
 */
@WebServlet(urlPatterns={ "/registration"})
public class RegistrationServlet extends HttpServlet {

    public static final String SQL_REGISTRATION_USER = "INSERT INTO user VALUES (?,?)";
    private DBHelper dbHelper = new DBHelper();
    private Connection connection = (Connection) dbHelper.getConnection();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String usermane = request.getParameter("username");
        String password = request.getParameter("password");
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_REGISTRATION_USER);
            preparedStatement.setString(1, usermane);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    dbHelper.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
