package ua.com.goit.gojava7.kickstarter.dao.memory.util;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Question;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.util.Utils;

public class Memory {
    private List<Quote> quotes = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();
    private List<Reward> rewards = new ArrayList<>();
    private List<Question> qnAs = new ArrayList<>();
    
    public Memory() {
        initQuotes();
        
        initCategories();
        
        initProjects();
        
        initPayments();
        
        initQnA();
        
        initRewards();
    }

    private void initQuotes() {
        quotes.add(new Quote("Napoleon Hill", "The starting point of all achievement is desire."));
        quotes.add(new Quote("Audrey Hepburn", "Nothing is impossible, the word itself says 'I'm possible'!"));
        quotes.add(new Quote("Milton Berle", "If opportunity doesn't knock, build a door."));
    }

    private void initCategories() {
        categories.add(new Category(1, "Art"));
        categories.add(new Category(2, "Music"));
        categories.add(new Category(3, "Sports"));
    }

    private void initProjects() {
        String videoUrl = "https://www.youtube.com/watch?v=PaEnaoydUUo";
        
        Project project;
        
        project = new Project("Xpand Lacing System", "Charles Harris", categories.get(2));
        project.setId(1);
        project.setDescription("Get your shoes on in 3 seconds flat! No more bows, no more knots, no more tying!");
        project.setStartDate(Utils.dateFromString("25.10.2015"));
        project.setEndDate(Utils.dateFromString("25.11.2015"));
        project.setVideoUrl(videoUrl);
        project.setGoalSum(2000L);
        projects.add(project);
        
        project = new Project("Draw Like a Boss : The Physical Book", "Ash and Eli", categories.get(0));
        project.setId(2);
        project.setDescription("Two years in the making and it's finally ready to become a physical instructional book about drawing.");
        project.setStartDate(Utils.dateFromString("11.10.2015"));
        project.setEndDate(Utils.dateFromString("27.11.2015"));
        project.setVideoUrl(videoUrl);
        project.setGoalSum(9000L);
        projects.add(project);
        
        project = new Project("Mini Museum 2: The Second Edition", "Hans Fex", categories.get(0));
        project.setId(3);
        project.setDescription("Billions of years of life, science and history in the palm of your hand! Curated and handcrafted to inspire for generations.");
        project.setStartDate(Utils.dateFromString("30.10.2015"));
        project.setEndDate(Utils.dateFromString("25.12.2015"));
        project.setVideoUrl(videoUrl);
        project.setGoalSum(5500L);
        projects.add(project);
        
        project = new Project("FlyKly Smart Ped", "FlyKly", categories.get(2));
        project.setId(4);
        project.setDescription("This beautifully practical kick assist e-bike is the smartest move around the city as it extends your ride and folds easily.");
        project.setStartDate(Utils.dateFromString("29.10.2015"));
        project.setEndDate(Utils.dateFromString("01.01.2016"));
        project.setVideoUrl(videoUrl);
        project.setGoalSum(4000L);
        projects.add(project);
        
        project = new Project("Music for Cats", "David Teie", categories.get(1));
        project.setId(5);
        project.setDescription("We need your help to create an album featuring the first-ever music scientifically proven to enrich cats' lives.");
        project.setStartDate(Utils.dateFromString("15.09.2015"));
        project.setEndDate(Utils.dateFromString("05.01.2016"));
        project.setVideoUrl(videoUrl);
        project.setGoalSum(2500L);
        projects.add(project);
    }

    private void initPayments() {
        payments.add(new Payment(projects.get(0), "John", 123312L, 200L, Utils.dateFromString("25.04.2015")));
        payments.add(new Payment(projects.get(0), "Adam", 53245452L, 300L, Utils.dateFromString("25.05.2015")));
        payments.add(new Payment(projects.get(0), "Sue", 15435356L, 400L, Utils.dateFromString("25.06.2015")));
        payments.add(new Payment(projects.get(1), "Sam", 830956L, 500L, Utils.dateFromString("21.10.2015")));
        payments.add(new Payment(projects.get(1), "Pam", 123754L, 250L, Utils.dateFromString("22.09.2015")));
        payments.add(new Payment(projects.get(1), "Gwen", 2536356L, 340L, Utils.dateFromString("01.05.2015")));
        payments.add(new Payment(projects.get(2), "Rob", 3679865325L, 230L, Utils.dateFromString("25.03.2015")));
        payments.add(new Payment(projects.get(2), "Bob", 123435634L, 540L, Utils.dateFromString("25.05.2015")));
        payments.add(new Payment(projects.get(3), "Jake", 12343645L, 550L, Utils.dateFromString("24.05.2015")));
        payments.add(new Payment(projects.get(3), "Ted", 4343654L, 330L, Utils.dateFromString("20.05.2015")));
        payments.add(new Payment(projects.get(3), "Ned", 23456546L, 210L, Utils.dateFromString("25.08.2015")));
        payments.add(new Payment(projects.get(4), "Fred", 2345647543L, 410L, Utils.dateFromString("11.05.2015")));
    }
    
    private void initQnA() {
        qnAs.add(new Question(projects.get(0), "q1", "a1"));
        qnAs.add(new Question(projects.get(0), "q2", "a2"));
        qnAs.add(new Question(projects.get(0), "q3", "a3"));
        qnAs.add(new Question(projects.get(1), "q4", "a4"));
        qnAs.add(new Question(projects.get(2), "q5", "a5"));
        qnAs.add(new Question(projects.get(3), "q6", "a6"));
        qnAs.add(new Question(projects.get(3), "q7", "a7"));
    }
    
    private void initRewards() {
        rewards.add(new Reward(1, projects.get(0), "Get one package", 5L));
        rewards.add(new Reward(2, projects.get(0), "Get 3 packages", 15L));
        rewards.add(new Reward(3, projects.get(0), "Get 7 packages", 30L));
        
        rewards.add(new Reward(4, projects.get(1), "Get copy of a book", 10L));
        rewards.add(new Reward(5, projects.get(1), "Get 2 copys of a book and a poster", 30L));
        rewards.add(new Reward(6, projects.get(1), "Get 2 copys of a book, poster and set of brushes", 50L));
        
        rewards.add(new Reward(7, projects.get(2), "Get one sample", 5L));
        rewards.add(new Reward(8, projects.get(2), "Get one sample and discount for next purchase", 10L));
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

    public List<Question> getQuestions() {
        return qnAs;
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
