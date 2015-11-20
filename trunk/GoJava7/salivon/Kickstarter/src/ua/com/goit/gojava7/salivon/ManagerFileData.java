package ua.com.goit.gojava7.salivon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.beans.Faq;
import ua.com.goit.gojava7.salivon.beans.Payment;
import ua.com.goit.gojava7.salivon.beans.Project;

public class ManagerFileData implements ManagerData {

    private static final String PATH_TO_QUOTE = "resource/quote.csv";
    private static final String PATH_TO_CATEGORY = "resource/category.csv";
    private static final String PATH_TO_PROJECT = "resource/project.csv";
    private static final String PATH_TO_FAQ = "resource/faq.csv";
    private static final String PATH_TO_PAYMENT = "resource/payment.csv";

    @Override
    public String getRandomQuote() {

        Random random = new Random();
        String quote = null;
        File file = new File(PATH_TO_QUOTE);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            br.mark((int) file.length() + 1);
            int count = 0;
            while ((quote = br.readLine()) != null) {
                count++;
            }
            int number = (int) (random.nextDouble() * count);
            br.reset();
            while (true) {
                quote = br.readLine();
                if (number == 0) {
                    String[] arr = quote.split("[|]");
                    quote = arr[0] + "\n Autor:" + arr[1];
                    break;
                } else {
                    number--;
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ManagerFileData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quote;
    }

    @Override
    public List<Category> getAllCategories() {

        List<Category> categories = new ArrayList<>();
        File file = new File(PATH_TO_CATEGORY);
        String category = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((category = br.readLine()) != null) {
                String[] arr = category.split("[|]");
                int id = Integer.parseInt(arr[0].trim());
                String name = arr[1].trim();
                categories.add(new Category(name, id));
            }

        } catch (IOException ex) {
            Logger.getLogger(ManagerFileData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    @Override
    public Category getCategory(int idCategory) {
        Category requestedCategory = null;
        File file = new File(PATH_TO_CATEGORY);
        String category = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((category = br.readLine()) != null) {
                String[] arr = category.split("[|]");
                int id = Integer.parseInt(arr[0].trim());
                String name = arr[1].trim();
                if (id == idCategory) {
                    requestedCategory = new Category(name, id);
                    break;
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ManagerFileData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requestedCategory;
    }

    @Override
    public List<Project> getProjectsOfCategory(int idCategory) {
        List<Project> projects = new ArrayList<>();
        File file = new File(PATH_TO_PROJECT);
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
                    p.setFaq(getFaq(id));
                    p.setCollectedAmount(getTotal(id));
                    projects.add(p);
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ManagerFileData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }

    @Override
    public Project getProject(int idProject) {
        Project requestedProject = null;
        File file = new File(PATH_TO_PROJECT);
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
                    requestedProject.setFaq(getFaq(idProject));
                    requestedProject.setCollectedAmount(getTotal(idProject));
                    break;
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ManagerFileData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requestedProject;
    }

    @Override
    public void saveFaq(Faq faq) {
        File file = new File(PATH_TO_FAQ);
        int idProject = faq.getIdProject();
        String context = faq.getContext();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file, true))) {

            br.write(idProject + "|" + context + "\n");
        } catch (IOException ex) {
            Logger.getLogger(ManagerFileData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getFaq(int idProject) {
        String faq = "";
        File file = new File(PATH_TO_FAQ);
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                String[] arr = line.split("[|]");
                int id = Integer.parseInt(arr[0].trim());
                String context = arr[1].trim();
                if (id == idProject) {
                    faq += context + "\n";

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ManagerFileData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return faq;
    }

    @Override
    public void savePayment(Payment payment) {
        File file = new File(PATH_TO_PAYMENT);
        int idProject = payment.getIdProject();
        String namePayer = payment.getNamePayer();
        long numberCard = payment.getNumberCard();
        int total = payment.getTotal();
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file, true))) {

            br.write(idProject + "|" + namePayer + "|" + numberCard + "|" + total + "\n");
        } catch (IOException ex) {
            Logger.getLogger(ManagerFileData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getTotal(int idProject) {
        int total = 0;
        File file = new File(PATH_TO_PAYMENT);
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            while ((line = br.readLine()) != null) {
                String[] arr = line.split("[|]");
                int id = Integer.parseInt(arr[0].trim());
                int sum = Integer.parseInt(arr[3].trim());
                if (id == idProject) {
                    total += sum;

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ManagerFileData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
}
