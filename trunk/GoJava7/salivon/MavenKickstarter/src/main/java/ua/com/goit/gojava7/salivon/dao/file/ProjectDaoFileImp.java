package ua.com.goit.gojava7.salivon.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.FaqDao;
import ua.com.goit.gojava7.salivon.dao.PathFile;
import ua.com.goit.gojava7.salivon.dao.PaymentDao;
import ua.com.goit.gojava7.salivon.dao.ProjectDao;

public class ProjectDaoFileImp implements ProjectDao {

    FaqDao faq = new FaqDaoFileImp();
    PaymentDao payment = new PaymentDaoFileImp();

    @Override
    public List<Project> getProjectsOfCategory(int idCategory) {
        List<Project> projects = new ArrayList<>();
        File file = new File(PathFile.PROJECT.getPath());
        String project = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((project = br.readLine()) != null) {
                String[] arr = project.split("[|]");
                int id = Integer.parseInt(arr[0].trim());
                String title = arr[1].trim();
                int total = Integer.parseInt(arr[2].trim());
                int idCategoryOfProject = Integer.parseInt(arr[3].trim());
                if (idCategoryOfProject == idCategory) {
                    Project p = new Project(title, total, idCategoryOfProject, id);
                    p.setFaq(faq.getContextFaq(id));
                    p.setCollectedAmount(payment.getTotal(id));
                    projects.add(p);
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ProjectDaoFileImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }

    @Override
    public Project getProject(int idProject) {
        Project requestedProject = null;
        File file = new File(PathFile.PROJECT.getPath());
        String project = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((project = br.readLine()) != null) {
                String[] arr = project.split("[|]");
                int id = Integer.parseInt(arr[0].trim());
                String title = arr[1].trim();
                int total = Integer.parseInt(arr[2].trim());
                int idCategory = Integer.parseInt(arr[3].trim());
                if (id == idProject) {
                    requestedProject = new Project(title, total, idCategory, id);
                    requestedProject.setFaq(faq.getContextFaq(idProject));
                    requestedProject.setCollectedAmount(payment.getTotal(idProject));
                    break;
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ProjectDaoFileImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requestedProject;
    }

}
