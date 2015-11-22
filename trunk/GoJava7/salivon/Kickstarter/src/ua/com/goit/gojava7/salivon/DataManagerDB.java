package ua.com.goit.gojava7.salivon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.beans.Project;

public class DataManagerDB implements ManagerData {

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
            Logger.getLogger(DataManagerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        int number = ((int) (random.nextDouble() * count)) + 1;
        System.out.println(number);
        String query = "SELECT Text, Author FROM quote WHERE IdQuote = " + number;
        res = util.executeQuery(query);
        try {
            res.next();
            quote = res.getString("Text") + "\n Autor:" + res.getString("Author");

        } catch (SQLException ex) {
            Logger.getLogger(DataManagerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return quote;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        ResultSet res = null;
        String query = "SELECT IdCategory, Name FROM category ORDER BY IdCategory";
        util.openConnection();
        res = util.executeQuery(query);
        try {
            while (res.next()) {
                categories.add(new Category(res.getString("Name"), res.getInt("IdCategory")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManagerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return categories;
    }

    @Override
    public Category getCategory(int idCategory) {
        Category requestedCategory = null;
        ResultSet res = null;
        String query = "SELECT Name FROM category WHERE IdCategory = " + idCategory;
        util.openConnection();
        res = util.executeQuery(query);
        try {
            res.next();
            requestedCategory = new Category(res.getString("Name"), idCategory);
        } catch (SQLException ex) {
            Logger.getLogger(DataManagerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return requestedCategory;
    }

    @Override
    public List<Project> getProjectsOfCategory(int idCategory) {
        List<Project> projects = new ArrayList<>();
        ResultSet res = null;
        String query = "SELECT IdProject, Name, Total, IdCategory FROM project WHERE IdCategory = " + idCategory;
        util.openConnection();
        res = util.executeQuery(query);
        try {
            while (res.next()) {
                Project p = new Project(res.getString("Name"), res.getInt("Total"), idCategory, res.getInt("IdProject"));
                p.setFaq(getContextFaq(res.getInt("IdProject")));
                p.setCollectedAmount(getTotal(res.getInt("IdProject")));
                projects.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManagerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return projects;
    }

    @Override
    public Project getProject(int idProject) {
        Project requestedProject = null;
        ResultSet res = null;
        String query = "SELECT Name, Total, IdCategory FROM project WHERE IdProject = " + idProject;
        util.openConnection();
        res = util.executeQuery(query);
        try {
            res.next();
            Project p = new Project(res.getString("Name"), res.getInt("Total"), res.getInt("IdCategory"), idProject);
            p.setFaq(getContextFaq(idProject));
            p.setCollectedAmount(getTotal(idProject));
            requestedProject = p;
        } catch (SQLException ex) {
            Logger.getLogger(DataManagerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requestedProject;
    }

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
            Logger.getLogger(DataManagerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return faq;
    }

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
                total+=res.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataManagerDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        util.closeConnection();
        return total;
    }

}
