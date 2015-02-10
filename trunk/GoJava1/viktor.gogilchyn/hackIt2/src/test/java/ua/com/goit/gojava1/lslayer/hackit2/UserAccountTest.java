package ua.com.goit.gojava1.lslayer.hackit2;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.gear.Gear;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.BombDevice;
import ua.com.goit.gojava1.lslayer.hackit2.gear.hardware.devices.ScanDevice;

public class UserAccountTest {
    @Test
    public void testSmoke() {
        assertTrue(true);
    }
    
    @Test
    public void testAccountCreation() throws Exception {
        UserAccountData account = UserAccount.createAccount("mylogin", "mypassword");
        assertNotNull(account);
        assertEquals("mylogin", account.getLoginName());
        assertEquals("mypassword", account.getPassword());
    }
   
    @Test
    public void testNewbornCharacterSkillList() {
        UserAccountData account = new UserAccountData();
        try {
            account = UserAccount.createAccount("mylogin", "mypassword");
            UserAccount.createCharacterInAccount(account, "MegaPihar2000");
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        Actor actor = account.getCharacter();
        assertNotNull(actor.getSkills());
    }
    
    @Test(expected=HackitWrongParameterException.class)
    public void testExceptionOnSettingCharacter() throws HackitWrongParameterException {
        UserAccountData account = UserAccount.createAccount("mylogin", "mypassword");
        account.setCharacter(null);
    }
    
    @Test
    public void testSomeExceptions() {
        UserAccountData account = null;
        try {
            account = UserAccount.createAccount("mylogin", "mypassword");
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        
        try {
            account.setStuff(null);
        } catch (HackitWrongParameterException e) {
            assertEquals("List doesn't exist", e.getMessage());
        }

        try {
            account.addStuff(null);
        } catch (HackitWrongParameterException e) {
            assertEquals("Where is item?", e.getMessage());
        }
        try {
            UserAccount.createCharacterInAccount(null, "Homeless");
        } catch (Exception e) {
            assertEquals("Need a place for newborn character", e.getMessage());
        }
    }

    @Test
    public void testExceptionAccountCreation() {
        try {
            @SuppressWarnings("unused")
            UserAccountData account = UserAccount.createAccount(null, "mypassword");
        } catch (Exception e) {
            assertEquals("No null fields accepted", e.getMessage());
        }
        
        try {
            @SuppressWarnings("unused")
            UserAccountData account = UserAccount.createAccount(null, null);
        } catch (Exception e) {
            assertEquals("No null fields accepted", e.getMessage());
        }

        try {
            @SuppressWarnings("unused")
            UserAccountData account = UserAccount.createAccount("myaccount", null);
        } catch (Exception e) {
            assertEquals("No null fields accepted", e.getMessage());
        }
}

    @Test
    public void testAccountStuff() {
        UserAccountData account = new UserAccountData();
        try {
            account = UserAccount.createAccount("login", "password");
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        List<Gear> testList = new LinkedList<Gear>();
        Gear someGearToPass = null;
        Gear anotherGear = null;
        try {
            someGearToPass = new ScanDevice("ScanMaster2000");
            anotherGear = new BombDevice("C4");
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        try {
            account.setStuff(testList);
        } catch (HackitWrongParameterException e) {
            assertEquals("List doesn't exist", e.getMessage());
        }
        assertEquals(testList, account.getStuff());

        testList.add(anotherGear);
        try {
            account.setStuff(testList);
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        
        try {
            account.addStuff(someGearToPass);
        } catch (HackitWrongParameterException e) {
            fail(e.getMessage());
        }
        assertNotEquals(testList, account.getStuff());
        
        
    }
    
    
}
