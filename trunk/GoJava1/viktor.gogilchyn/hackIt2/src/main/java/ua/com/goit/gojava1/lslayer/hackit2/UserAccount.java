package ua.com.goit.gojava1.lslayer.hackit2;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;


public final class UserAccount { //Just couple of static methods to maintain UserAccountData
    
    public static UserAccountData createAccount(String login, String password) throws HackitWrongParameterException {
        if (login == null || password == null) 
            throw new HackitWrongParameterException("No null fields accepted");
        UserAccountData account = new UserAccountData();
        account.setLoginName(login);
        account.setPassword(password);
        return account;
    }
    
    public static UserAccountData createCharacterInAccount(UserAccountData account, String characterName) throws HackitWrongParameterException {
        if (account == null) throw new HackitWrongParameterException("Need a place for newborn character");
        Actor character =  new HumanControlledCharacter(characterName);
        character.addSkill("scan");   //
        character.addSkill("develop");// Three default skills added to newborn hero
        character.addSkill("hack");   //
        account.setCharacter(character);
        return account;
    }
}
