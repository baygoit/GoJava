package MyAirBnB.Dao;

import java.sql.Connection;

/**
 * Created by macmini on 13.10.15.
 */
public interface DaoBD {

    Connection getConnection();
    void closeConnection();
}
