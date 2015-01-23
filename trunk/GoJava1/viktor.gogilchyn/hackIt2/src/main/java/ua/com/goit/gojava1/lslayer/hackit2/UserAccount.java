package ua.com.goit.gojava1.lslayer.hackit2;

public class UserAccount {
    private String loginName;
    private String password;
    private Actor character;
    private UserAccount() {
        
    }
    
    private void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setCharacter(Actor character) {
        this.character = character;
    }

    public Actor getActor() {
        return this.character;
    }
    public static UserAccount login(String login, String password) {
        /*
         * Here comes description-code. 
         * When persistent will be allowed by pro100fox,
         * here I should check whether there is an account 
         * with given credentials in database, and I will return it. 
         * For now, new account is created and returned;
         */
        
        return UserAccount.createAccount(login, password);
    }
    
    public boolean checkLogin(String login, String password) { //Sometimes, when some important thisng happens,
                                  //I should check if it's really this account
        return this.loginName.equals(login) && this.password.equals(password);
    }
    
    public static UserAccount createAccount(String login, String password) {
        UserAccount account = new UserAccount();
        account.setLoginName(login);
        account.setPassword(password);
        return account;
    }
    
    public static UserAccount createCharacterInAccount(UserAccount account, String characterName) {
        account.setCharacter(new HumanControlledCharacter(characterName));
        return account;
    }
}
