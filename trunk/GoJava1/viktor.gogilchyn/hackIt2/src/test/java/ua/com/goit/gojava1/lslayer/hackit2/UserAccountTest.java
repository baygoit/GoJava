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
    public void testAccountCreation() throws Exception {
        UserAccount account = UserAccount.createAccount("mylogin", "mypassword");
        assertNotNull(account);
        UserAccount account2 = UserAccount.login("mylogin", "mypassword");
        assertNotNull(account2);
    }
   
    @Test
    public void testCredentials() throws Exception {
        UserAccount account = UserAccount.createAccount("mylogin", "mypassword");
        assertTrue(account.checkLogin("mylogin", "mypassword"));
        assertFalse(account.checkLogin("mylogin", "myWrongpassword"));
        assertFalse(account.checkLogin("myWronglogin", "mypassword"));
        assertFalse(account.checkLogin("myWronglogin", "myWrongpassword"));
    }
    @Test
    public void testNewbornCharacterSkillList() throws Exception {
        UserAccount account = UserAccount.createAccount("mylogin", "mypassword");
        try {
            UserAccount.createCharacterInAccount(account, "MegaPihar2000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Actor actor = account.getActor();
        assertNotNull(actor.getSkills());
    }
    @Test(expected=HackitWrongParameterException.class)
    public void testExceptionOnSettingCharacter() throws Exception {
        UserAccount account = UserAccount.createAccount("mylogin", "mypassword");
        account.setCharacter(null);
    }

    @Test
    public void testExceptionAccountCreation() {
        try {
            @SuppressWarnings("unused")
            UserAccount account = UserAccount.createAccount(null, "mypassword");
        } catch (Exception e) {
            assertEquals("No null fields accepted", e.getMessage());
        }
        
        try {
            @SuppressWarnings("unused")
            UserAccount account = UserAccount.createAccount(null, null);
        } catch (Exception e) {
            assertEquals("No null fields accepted", e.getMessage());
        }

        try {
            @SuppressWarnings("unused")
            UserAccount account = UserAccount.createAccount("myaccount", null);
        } catch (Exception e) {
            assertEquals("No null fields accepted", e.getMessage());
        }
}

    @Test
    public void testException() throws Exception {
        try {
            UserAccount.createCharacterInAccount(null, "Homeless");
        } catch (Exception e) {
            assertEquals("Need a place for newborn character", e.getMessage());
        }
    }
}
