package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.QnA;
import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Pledge;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.beans.User;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class Memory {
    private List<Quote> quotes = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();
    private List<Pledge> pledges = new ArrayList<>();
    private List<Reward> rewards = new ArrayList<>();
    
    public Memory() {
        initQuotes();
        
        initCategories();
        
        initProjects();
        
        initPayments();
        
        initPledges();
        
        initRewards();
    }

    private void initQuotes() {
        quotes.add(new Quote("Napoleon Hill", "The starting point of all achievement is desire."));
        quotes.add(new Quote("Audrey Hepburn", "Nothing is impossible, the word itself says 'I'm possible'!"));
        quotes.add(new Quote("Milton Berle", "If opportunity doesn't knock, build a door."));
    }

    private void initCategories() {
        categories.add(new Category("Art"));
        categories.add(new Category("Music"));
        categories.add(new Category("Sports"));
    }

    private void initProjects() {
        String videoUrl = "https://www.youtube.com/watch?v=PaEnaoydUUo";
        
        Project project;
        
        project = new Project("Xpand Lacing System", new User("Charles Harris"), new Category("Sports"));
        project.setDescription("Get your shoes on in 3 seconds flat! No more bows, no more knots, no more tying!");
        project.setStartDate(Utils.dateFromString("25.10.2015"));
        project.setEndDate(Utils.dateFromString("25.11.2015"));
        project.setVideoUrl(videoUrl);
        project.setGoalSum(2000L);
        project.addQnA(new QnA("q1", "a1"));
        project.addQnA(new QnA("q2", "a2"));
        projects.add(project);
        
        project = new Project("Draw Like a Boss : The Physical Book", new User("Ash and Eli"), new Category("Art"));
        project.setDescription("Two years in the making and it's finally ready to become a physical instructional book about drawing.");
        project.setStartDate(Utils.dateFromString("11.10.2015"));
        project.setEndDate(Utils.dateFromString("27.11.2015"));
        project.setVideoUrl(videoUrl);
        project.setGoalSum(9000L);
        project.addQnA(new QnA("q3", "a3"));
        project.addQnA(new QnA("q4", "a4"));
        projects.add(project);
        
        project = new Project("Mini Museum 2: The Second Edition", new User("Hans Fex"), new Category("Art"));
        project.setDescription("Billions of years of life, science and history in the palm of your hand! Curated and handcrafted to inspire for generations.");
        project.setStartDate(Utils.dateFromString("30.10.2015"));
        project.setEndDate(Utils.dateFromString("25.12.2015"));
        project.setVideoUrl(videoUrl);
        project.setGoalSum(5500L);
        project.addQnA(new QnA("q5", "a5"));
        project.addQnA(new QnA("q6", "a6"));
        projects.add(project);
        
        project = new Project("FlyKly Smart Ped", new User("FlyKly"), new Category("Sports"));
        project.setDescription("This beautifully practical kick assist e-bike is the smartest move around the city as it extends your ride and folds easily.");
        project.setStartDate(Utils.dateFromString("29.10.2015"));
        project.setEndDate(Utils.dateFromString("01.01.2016"));
        project.setVideoUrl(videoUrl);
        project.setGoalSum(4000L);
        project.addQnA(new QnA("q7", "a7"));
        project.addQnA(new QnA("q8", "a8"));
        projects.add(project);
        
        project = new Project("Music for Cats", new User("David Teie"), new Category("Music"));
        project.setDescription("We need your help to create an album featuring the first-ever music scientifically proven to enrich cats' lives.");
        project.setStartDate(Utils.dateFromString("15.09.2015"));
        project.setEndDate(Utils.dateFromString("05.01.2016"));
        project.setVideoUrl(videoUrl);
        project.setGoalSum(2500L);
        project.addQnA(new QnA("q9", "a9"));
        project.addQnA(new QnA("q0", "a0"));
        projects.add(project);
    }

    private void initPayments() {
        payments.add(new Payment(new User("John"), 123312L, 200L, Utils.dateFromString("25.04.2015")));
        payments.add(new Payment(new User("Adam"), 53245452L, 300L, Utils.dateFromString("25.05.2015")));
        payments.add(new Payment(new User("Sue"), 15435356L, 400L, Utils.dateFromString("25.06.2015")));
        payments.add(new Payment(new User("Sam"), 830956L, 500L, Utils.dateFromString("21.10.2015")));
        payments.add(new Payment(new User("Pam"), 123754L, 250L, Utils.dateFromString("22.09.2015")));
        payments.add(new Payment(new User("Gwen"), 2536356L, 340L, Utils.dateFromString("01.05.2015")));
        payments.add(new Payment(new User("Rob"), 3679865325L, 230L, Utils.dateFromString("25.03.2015")));
        payments.add(new Payment(new User("Bob"), 123435634L, 540L, Utils.dateFromString("25.05.2015")));
        payments.add(new Payment(new User("Jake"), 12343645L, 550L, Utils.dateFromString("24.05.2015")));
        payments.add(new Payment(new User("Ted"), 4343654L, 330L, Utils.dateFromString("20.05.2015")));
        payments.add(new Payment(new User("Ned"), 23456546L, 210L, Utils.dateFromString("25.08.2015")));
        payments.add(new Payment(new User("Fred"), 2345647543L, 410L, Utils.dateFromString("11.05.2015")));
    }
    
    private void initPledges() {
        pledges.add(new Pledge(projects.get(0), payments.get(0)));
        pledges.add(new Pledge(projects.get(0), payments.get(1)));
        pledges.add(new Pledge(projects.get(0), payments.get(2)));
        pledges.add(new Pledge(projects.get(1), payments.get(3)));
        pledges.add(new Pledge(projects.get(2), payments.get(4)));
        pledges.add(new Pledge(projects.get(3), payments.get(5)));
        pledges.add(new Pledge(projects.get(3), payments.get(6)));
    }
    
    private void initRewards() {
        rewards.add(new Reward(projects.get(0), "Get one package", 5L));
        rewards.add(new Reward(projects.get(0), "Get 3 packages", 15L));
        rewards.add(new Reward(projects.get(0), "Get 7 packages", 30L));
        
        rewards.add(new Reward(projects.get(1), "Get copy of a book", 10L));
        rewards.add(new Reward(projects.get(1), "Get 2 copys of a book and a poster", 30L));
        rewards.add(new Reward(projects.get(1), "Get 2 copys of a book, poster and set of brushes", 50L));
        
        rewards.add(new Reward(projects.get(2), "Get one sample", 5L));
        rewards.add(new Reward(projects.get(2), "Get one sample and discount for next purchase", 10L));
    }
    
    
    public List<Quote> getQuotes() {
        return quotes;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Pledge> getPledges() {
        return pledges;
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
