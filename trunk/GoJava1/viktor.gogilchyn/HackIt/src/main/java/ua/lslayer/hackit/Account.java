package ua.lslayer.hackit;

public class Account {
    private String login;
    private String password;
    private boolean logged;
    private Hero hero;
    
    public Account (String login, String password) {
        this.login = login;
        this.password = password;
        this.hero = null;
        this.logged = false;
        
    }
    
    public boolean login (String login, String password) {
         this.logged = ((this.login.equals(login)) && 
                        (this.password.equals(password)));
         return this.logged;
        
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public boolean loggedIn() {
        return this.logged;
    }
}
