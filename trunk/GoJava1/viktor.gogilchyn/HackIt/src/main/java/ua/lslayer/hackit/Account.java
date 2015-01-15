package ua.lslayer.hackit;

public class Account {
    private String login;
    private String password;
    private boolean logged = false;
    private Hero hero = new Hero("Meg@P|h@r20125");
    
    public Account (String login, String password) {
        this.login = login;
        this.password = password;
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
        // TODO Auto-generated method stub
        return this.logged;
    }
}
