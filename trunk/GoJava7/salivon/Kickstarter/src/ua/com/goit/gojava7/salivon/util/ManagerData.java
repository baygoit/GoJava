package ua.com.goit.gojava7.salivon.util;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.beans.Project;

public interface ManagerData {

    public String getRandomQuote();

    public List<Category> getAllCategories();

    public Category getCategory(int idCategory);

    public List<Project> getProjectsOfCategory(int idCategory);

    public Project getProject(int idProject);

    public void saveFaq(Faq faq);

    public String getContextFaq(int idProject);

    public void savePayment(Payment payment);

    public int getTotal(int idProject);
}
