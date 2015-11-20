package ua.com.goit.gojava7.kickstarter.dao;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.file.FileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.PledgeFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.ProjectFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.file.RewardFileDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.Memory;
import ua.com.goit.gojava7.kickstarter.dao.memory.MemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.PledgeMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectMemoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.RewardMemoryDAO;

public class StorageFactory {
    private DataType dataType;
    private DataStorage<Quote> quoteDAO;
    private DataStorage<Category> categoryDAO;
    private ProjectStorage projectDAO;
    private PledgeStorage pledgeDAO;
    private DataStorage<Payment> paymentDAO;
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
        paymentDAO = new MemoryDAO<>(mem.getPayments());
        
        projectDAO = new ProjectMemoryDAO(mem.getProjects());
        pledgeDAO = new PledgeMemoryDAO(mem.getPledges());
        rewardDAO = new RewardMemoryDAO(mem.getRewards());
    }
    
    private void initFileStorage(){
        quoteDAO = new FileDAO<>(Quote.class);
        categoryDAO = new FileDAO<>(Category.class);
        paymentDAO = new FileDAO<>(Payment.class);
        
        projectDAO = new ProjectFileDAO();
        pledgeDAO = new PledgeFileDAO();
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

    public PledgeStorage getPledgeDAO() {
        return pledgeDAO;
    }

    public DataStorage<Payment> getPaymentDAO() {
        return paymentDAO;
    }

    public RewardStorage getRewardDAO() {
        return rewardDAO;
    }
}
