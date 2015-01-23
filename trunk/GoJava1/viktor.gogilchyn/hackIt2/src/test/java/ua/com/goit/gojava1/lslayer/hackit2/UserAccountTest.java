package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserAccountTest {
    @Test
    public void testSmoke() {
        assertTrue(true);
    }
    
    @Test
    public void testAccountCreation() {
        UserAccount account = UserAccount.createAccount("mylogin", "mypassword");
        assertNotNull(account);
    }
   
    @Test
    public void testCredentials() {
        UserAccount account = UserAccount.createAccount("mylogin", "mypassword");
        assertTrue(account.checkLogin("mylogin", "mypassword"));
    }
}
