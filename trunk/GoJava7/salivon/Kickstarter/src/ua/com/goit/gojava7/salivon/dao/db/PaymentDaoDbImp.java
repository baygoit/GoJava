package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.dao.PaymentDao;

public class PaymentDaoDbImp implements PaymentDao {

    DBUtil util = new DBUtil();

    @Override
    public void savePayment(Payment payment) {
        int idProject = payment.getIdProject();
        String namePayer = payment.getNamePayer();
        long numberCard = payment.getNumberCard();
        int total = payment.getTotal();
        String query = "INSERT INTO payment (Name, NumberCard,Total,IdProject) VALUES('"
                + namePayer + "'," + numberCard + "," + total + "," + idProject + ")";
        util.openConnection();
        util.executeUpdate(query);
        util.closeConnection();
    }

    @Override
    public int getTotal(int idProject) {
        int total = 0;
        String query = "SELECT Total FROM payment WHERE IdProject=" + idProject;
        ResultSet res = null;
        util.openConnection();
        res = util.executeQuery(query);
        try {
            while (res.next()) {
                total += res.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDaoDbImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return total;
    }

}
