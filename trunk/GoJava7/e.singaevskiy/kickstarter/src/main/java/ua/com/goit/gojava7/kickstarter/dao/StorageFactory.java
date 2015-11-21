package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.file.FileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.PaymentFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.ProjectFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.QuestionsFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.RewardFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.MemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionsMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.RewardMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.Memory;

public class StorageFactory {
    private DataType dataType;
    private DataStorage<Quote> quoteDAO;
    private DataStorage<Category> categoryDAO;
    private ProjectStorage projectDAO;
    private QuestionsStorage questionsDAO;
    private PaymentStorage paymentDAO;
    private RewardStorage rewardDAO;
    
    public StorageFactory(DataType dataType) {
        this.dataType = dataType;
        
        switch (dataType) {
        case MEMORY:
            initMemoryStorage();
            break;
            
        case FILE:
            initFileStorage();
            break;

        default:
            break;
        }
        
    }
    
    private void initMemoryStorage(){
        Memory mem = new Memory();
        quoteDAO = new MemoryDAO<>(mem.getQuotes());
        categoryDAO = new MemoryDAO<>(mem.getCategories());
        paymentDAO = new PaymentMemoryDAO(mem.getPayments());
        
        projectDAO = new ProjectMemoryDAO(mem.getProjects());
        questionsDAO = new QuestionsMemoryDAO(mem.getQuestions());
        rewardDAO = new RewardMemoryDAO(mem.getRewards());
    }
    
    private void initFileStorage(){
        quoteDAO = new FileDAO<>(Quote.class);
        categoryDAO = new FileDAO<>(Category.class);
        
        paymentDAO = new PaymentFileDAO();       
        projectDAO = new ProjectFileDAO();
        questionsDAO = new QuestionsFileDAO();
        rewardDAO = new RewardFileDAO();
    }

    public DataStorage<Category> getCategoryDAO() {
        return categoryDAO;
    }

    public DataType getDataType() {
        return dataType;
    }

    public DataStorage<Quote> getQuoteDAO() {
        return quoteDAO;
    }

    public ProjectStorage getProjectDAO() {
        return projectDAO;
    }

    public QuestionsStorage getQuestionsDAO() {
        return questionsDAO;
    }

    public PaymentStorage getPaymentDAO() {
        return paymentDAO;
    }

    public RewardStorage getRewardDAO() {
        return rewardDAO;
    }
}
