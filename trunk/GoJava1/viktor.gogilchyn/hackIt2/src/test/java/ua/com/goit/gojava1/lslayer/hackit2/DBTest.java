package ua.com.goit.gojava1.lslayer.hackit2;

import org.junit.Test;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.dao.ActorJDBCDAO;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitIOException;

public class DBTest {
    
    @Test
    public void testSaveActor() {
        Actor actor = new HumanControlledCharacter("Testname");
        actor.addAttribute("attribute1", "Value1");
        actor.addAttribute("attribute2", "Val123");
        actor.addAttribute("attribute3", "Valsdf");
        actor.addAttribute("attribute4", "Valuss");
        actor.addAttribute("attribute5", "Valdfg");
        actor.addAttribute("attribute6", "123ue1");
        actor.addAttribute("attribute7", "4434");
        actor.addSkill("Boo");
        ActorJDBCDAO manager = new ActorJDBCDAO();
        try {
            actor.setId(manager.save(actor));
            actor = manager.load(actor.getId());
            manager.delete(33);
            actor.setName("NewName");
            actor = manager.update(actor);
            
        } catch (HackitIOException e) {
            e.printStackTrace();
        }
    }

}
