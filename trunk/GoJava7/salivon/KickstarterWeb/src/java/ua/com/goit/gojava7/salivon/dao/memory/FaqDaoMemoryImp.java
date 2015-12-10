package ua.com.goit.gojava7.salivon.dao.memory;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.dao.FaqDao;
import ua.com.goit.gojava7.salivon.stores.StoreProjects;

public class FaqDaoMemoryImp implements FaqDao {

    @Override
    public void saveFaq(Faq faq) {
        int id = faq.getIdProject();
        String context = faq.getContext();
        List<Project> projects = StoreProjects.getProjects();
        for (Project project : projects) {
            if (id == project.getId()) {
                project.setFaq(context);
                break;
            }
        }
    }

    @Override
    public String getContextFaq(int idProject) {
        return null;
    }

}
