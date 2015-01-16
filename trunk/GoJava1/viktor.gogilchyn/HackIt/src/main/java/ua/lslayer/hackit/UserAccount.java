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
    
    private void saveProgress() {
        //Here I will save a hero to database
    }
    
    private void loadProgress() {
        //Here I will load a hero from database
    }
    
    public static UserAccount registerUserAccount(String login, String password) {
        //TODO make an account creation mechanism
        //Some mess with database to make an account
        return null;
    }
    
    public void changePassword() {
        //TODO make an password change mechanism
    }
    
    public boolean login (String login, String password) {
         this.loggedIn = ((this.login.equals(login)) && 
                        (this.password.equals(password)));
         this.loadProgress();
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
