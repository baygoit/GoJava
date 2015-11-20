package ua.com.goit.gojava7.salivon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.beans.Quote;
import ua.com.goit.gojava7.salivon.stores.StoreCategories;
import ua.com.goit.gojava7.salivon.stores.StoreProjects;
import ua.com.goit.gojava7.salivon.stores.StoreQuotes;

public class ObjectDataManager implements ManagerData {

    private StoreQuotes storeQuotes = new StoreQuotes();
    private StoreCategories storeCategories = new StoreCategories();
    private StoreProjects storeProjects = new StoreProjects();

    @Override
    public String getRandomQuote() {
        Random random = new Random();
        List<Quote> quotes = storeQuotes.getQuotes();
        String quote;
        int number = (int) (random.nextDouble() * quotes.size());
        quote = quotes.get(number).getText() + "\n Autor:" + quotes.get(number).getAutor();
        return quote;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = storeCategories.getCategories();
        return categories;
    }

    @Override
    public Category getCategory(int idCategory) {
        Category requestedCategory = null;
        List<Category> categories = storeCategories.getCategories();
        for (Category category : categories) {
            if (category.getId() == idCategory) {
                requestedCategory = category;
                break;
            }
        }
        return requestedCategory;
    }

    @Override
    public List<Project> getProjectsOfCategory(int idCategory) {
        List<Project> projects = StoreProjects.getProjects();
        List<Project> requestedCategory = new ArrayList<>();
        for (Project project : projects) {
            if (project.getIdCategory() == idCategory) {
                requestedCategory.add(project);
            }
        }
        return requestedCategory;
    }

    @Override
    public Project getProject(int idProject) {
        List<Project> projects = StoreProjects.getProjects();
        Project requestedProject = null;
        for (Project project : projects) {
            if (project.getId() == idProject) {
                requestedProject = project;
                break;
            }
        }
        return requestedProject;
    }

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
    public String getFaq(int idProject) {
        return null;
    }

    @Override
    public void savePayment(Payment payment) {
        int id = payment.getIdProject();
        int total = payment.getTotal();
        List<Project> projects = StoreProjects.getProjects();
        for (Project project : projects) {
            if (id == project.getId()) {
                project.setCollectedAmount(total);
                break;
            }
        }
    }

    @Override
    public int getTotal(int idProject) {
        return 0;
    }
}
