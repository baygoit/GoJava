package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.dao.QuoteDao;

public class QuoteDaoDbImp implements QuoteDao {

    DBUtil util = new DBUtil();

    @Override
    public String getRandomQuote() {
        Random random = new Random();
        ResultSet res = null;
        String quote = "";
        util.openConnection();
        res = util.executeQuery("SELECT count(IdQuote) AS count FROM quote");
        int count = 0;
        try {
            res.next();
            count = res.getInt("count");
        } catch (SQLException ex) {
            Logger.getLogger(QuoteDaoDbImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        int number = ((int) (random.nextDouble() * count)) + 1;
        String query = "SELECT Text, Author FROM quote WHERE IdQuote = " + number;
        res = util.executeQuery(query);
        try {
            res.next();
            quote = res.getString("Text") + "\n Autor:" + res.getString("Author");

        } catch (SQLException ex) {
            Logger.getLogger(QuoteDaoDbImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return quote;
    }

}
