package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.dao.FaqDao;

public class FaqDaoDbImp implements FaqDao {

    DBUtil util = new DBUtil();

    @Override
    public void saveFaq(Faq faq) {
        int idProject = faq.getIdProject();
        String context = faq.getContext();
        String query = "INSERT INTO faq (IdProject, Context) VALUES(" + idProject + ",'" + context + "')";
        util.openConnection();
        util.executeUpdate(query);
        util.closeConnection();
    }

    @Override
    public String getContextFaq(int idProject) {
        String faq = "";
        String query = "SELECT Context FROM faq WHERE IdProject=" + idProject;
        ResultSet res = null;
        util.openConnection();
        res = util.executeQuery(query);
        try {
            while (res.next()) {
                faq += res.getString("Context") + "\n";
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaqDaoDbImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return faq;
    }

}
