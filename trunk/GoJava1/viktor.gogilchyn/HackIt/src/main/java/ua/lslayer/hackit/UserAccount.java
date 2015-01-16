package ua.lslayer.hackit;

public class UserAccount {
    private String login;
    private String password;
    private boolean loggedIn;
    private Hero hero;
    
    public UserAccount (String login, String password) {
        this.login = login;
        this.password = password;
        this.hero = null;
        this.loggedIn = false;
        
    }
    
    public void saveProgress() {
        //Here I will save a hero to database
    }
    
    public void loadProgress() {
        //Here I will load a hero from database
    }
    
    public boolean login (String login, String password) {
         this.loggedIn = ((this.login.equals(login)) && 
                        (this.password.equals(password)));
         return this.loggedIn;
        
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public boolean loggedIn() {
        return this.loggedIn;
    }
    
    public void logOut() {
        this.loggedIn = false;
        this.saveProgress();
    }
}
