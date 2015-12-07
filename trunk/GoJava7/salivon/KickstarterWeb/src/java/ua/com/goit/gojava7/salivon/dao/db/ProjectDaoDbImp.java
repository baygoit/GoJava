package ua.com.goit.gojava7.salivon.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.FaqDao;
import ua.com.goit.gojava7.salivon.dao.PaymentDao;
import ua.com.goit.gojava7.salivon.dao.ProjectDao;

public class ProjectDaoDbImp implements ProjectDao {

    DBUtil util = new DBUtil();
    FaqDao faq = new FaqDaoDbImp();
    PaymentDao payment = new PaymentDaoDbImp();

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
                p.setFaq(faq.getContextFaq(res.getInt("IdProject")));
                p.setCollectedAmount(payment.getTotal(res.getInt("IdProject")));
                projects.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDaoDbImp.class.getName()).log(Level.SEVERE, null, ex);
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
            p.setFaq(faq.getContextFaq(idProject));
            p.setCollectedAmount(payment.getTotal(idProject));
            requestedProject = p;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDaoDbImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requestedProject;
    }

}
