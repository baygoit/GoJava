package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;

public class UserAccountTest {
    @Test
    public void testSmoke() {
        assertTrue(true);
    }
    
    @Test
    public void testAccountCreation() {
        UserAccount account = UserAccount.createAccount("mylogin", "mypassword");
        assertNotNull(account);
        UserAccount account2 = UserAccount.login("mylogin", "mypassword");
        assertNotNull(account2);
    }
   
    @Test
    public void testCredentials() {
        UserAccount account = UserAccount.createAccount("mylogin", "mypassword");
        assertTrue(account.checkLogin("mylogin", "mypassword"));
        assertFalse(account.checkLogin("mylogin", "myWrongpassword"));
        assertFalse(account.checkLogin("myWronglogin", "mypassword"));
        assertFalse(account.checkLogin("myWronglogin", "myWrongpassword"));
    }
    @Test
    public void testNewbornCharacterSkillList() {
        UserAccount account = UserAccount.createAccount("mylogin", "mypassword");
        UserAccount.createCharacterInAccount(account, "MegaPihar2000");
        Actor actor = account.getActor();
        assertNotNull(actor.getSkills());
    }
}
